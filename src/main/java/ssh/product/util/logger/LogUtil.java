package ssh.product.util.logger;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.log4j.spi.LoggerRepository;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 直接通过类名调用日志方法
 * 目前只简单封装了原有的四个日志级别，更丰富的方法待完善
 *
 */
public class LogUtil {

    private static org.slf4j.Logger logger;

    // 使LocationInfo类中初始化className为该类的上一个栈，即抛出异常的位置。
    private static final String FQCN = LogUtil.class.getName();

    // 使用代理初始化logger
    static {
        try {
            Enhancer eh = new Enhancer();
            eh.setSuperclass(Logger.class);
            eh.setCallbackType(LogInterceptor.class);
            Class c = eh.createClass();
            Enhancer.registerCallbacks(c, new LogInterceptor[]{new LogInterceptor()});
            Constructor<Logger> constructor = c.getConstructor(String.class);
            Logger loggerProxy= constructor.newInstance(LogUtil.class.getName());
            LoggerRepository loggerRepository = LogManager.getLoggerRepository();
            LoggerFactory lf = ReflectionUtil.getFieldValue(loggerRepository, "defaultFactory");
            Object loggerFactoryProxy = Proxy.newProxyInstance(
                    LoggerFactory.class.getClassLoader(),
                    new Class[]{LoggerFactory.class},
                    new NewLoggerHandler(loggerProxy)
            );

            ReflectionUtil.setFieldValue(loggerRepository, "defaultFactory", loggerFactoryProxy);
            logger = org.slf4j.LoggerFactory.getLogger(Logger.class.getName());
            ReflectionUtil.setFieldValue(loggerRepository, "defaultFactory", lf);

        } catch (Exception e) {
            throw new RuntimeException("初始化Logger失败", e);
        }
    }

    private static class LogInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            // 只拦截log方法。
            if (objects.length != 4 || !method.getName().equals("log"))
                return methodProxy.invokeSuper(o, objects);
            // 替换传给log方法的第一个参数为我们自定义的FQCN
            objects[0] = FQCN;
            return methodProxy.invokeSuper(o, objects);
        }
    }
    private static class NewLoggerHandler implements InvocationHandler {
        private final Logger proxyLogger;

        public NewLoggerHandler(Logger proxyLogger) {
            this.proxyLogger = proxyLogger;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return proxyLogger;
        }
    }

    //对log方法的简单封装，有需求时再完善
    //TODO
    public static void debug(String message){
        logger.debug(message);
    }
    public static void info(String message){
        logger.info(message);
    }
    public static void error(String message){
        logger.error(message);
    }
    public static void warn(String message){
        logger.warn(message);
    }

}