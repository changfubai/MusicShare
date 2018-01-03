package ssh.product.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssh.product.dao.BaseDao;
import ssh.product.dao.circle.CircleDao;
import ssh.product.dao.circle.JoinCircleDao;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

@Transactional
@SuppressWarnings("unchecked")
@Service("baseService")
@Lazy(true)
public class BaseServiceImpl<T> implements BaseService<T> {
    @Resource
    protected BaseDao baseDao;

    @Resource
    protected CircleDao circleDao;

    @Resource
    protected JoinCircleDao joinCircleDao;

    private Class clazz;


    public BaseServiceImpl() {
        System.out.println("当前服务类" + this);
        System.out.println("超类：" + this.getClass().getSuperclass());
        System.out.println("当前实例：" + this.getClass().getGenericSuperclass());
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class)type.getActualTypeArguments()[0];

    }



    @Override
    public void save(T t) {
        baseDao.setClazz1(clazz);
        baseDao.save(t);
    }

    @Override
    public void update(T t) {
        baseDao.setClazz1(clazz);
        baseDao.update(t);

    }

    @Override
    public T findById(Integer id) {
        baseDao.setClazz1(clazz);
        return (T)baseDao.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        baseDao.setClazz1(clazz);
        baseDao.deleteById(id);
    }
}
