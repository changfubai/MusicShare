package ssh.product.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ssh.product.model.circle.CircleEntity;
import ssh.product.model.circle.Circles;
import ssh.product.model.circle.JoincircleEntity;
import ssh.product.model.user.UserEntity;
import ssh.product.service.circle.CircleService;
import ssh.product.service.circle.JoinCircleService;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("baseAction")
@Scope("prototype")
public class BaseAction<T> extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ModelDriven<T> {

    protected  UserEntity userEntity = null;

    protected List<JoincircleEntity> joinCirclelist = null;
    protected List<CircleEntity> circlelist = null;
    protected List<CircleEntity> fCirclelist = null;
    //加入的圈子集合
    protected List<Circles> circleslist = null;

    protected String jsonStr = null;

    protected  Map<String, Object> map = new HashMap<String, Object>();

    @Resource
    protected CircleService circleService;

    @Resource
    protected JoinCircleService joinCircleService;

    protected Map<String, Object> request;
    protected Map<String, Object> session;
    protected Map<String, Object> application;
    protected T model;
    protected Class<T> clazz;
    protected SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public BaseAction(){
        super();
        ParameterizedType parameterizedType =  (ParameterizedType) getClass().getGenericSuperclass();
        Type[] types = parameterizedType.getActualTypeArguments();
        clazz = (Class<T>) types[0];
        try {
            model = clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T getModel() {
        return model;
    }
    public String getJsonStr() {
        return jsonStr;
    }

    public void setJsonStr(String jsonStr) {
        this.jsonStr = jsonStr;
    }

    @Override
    public void setApplication(Map<String, Object> application) {
        this.application = application;
    }
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    @Override
    public void setRequest(Map<String, Object> request) {
        this.request = request;
    }
}
