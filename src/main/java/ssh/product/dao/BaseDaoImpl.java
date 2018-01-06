package ssh.product.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;
@Transactional
@SuppressWarnings("unchecked")
@Repository("baseDao")
@Lazy(true)
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{
    private Class clazz = null;
    private HibernateTemplate template;

    public BaseDaoImpl() {
        //System.out.println("当前类：" + this);
        //System.out.println("父类：" + this.getClass().getSuperclass());
        //System.out.println("当前实例：" + this.getClass().getGenericSuperclass());
        if (this.equals(BaseDaoImpl.this)) {
            //this.getClass().
            //System.out.println("=====");

        }else{
            ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
            clazz = (Class<T>)type.getActualTypeArguments()[0];
        }
    }




    protected HibernateTemplate getTemplate() {
        if (template == null) {
            template = this.getHibernateTemplate();
        }
        return template;
    }

    @Override
    public void save(T t) {
        getTemplate().save(t);
    }

    @Override
    public void deleteById(Integer id) {
        Object object = getTemplate().load(clazz, id);
        getTemplate().delete(object);
    }

    @Override
    public void setClazz1(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public void update(T t) {
        getTemplate().update(t);
    }

    @Override
    public T findById(Integer id) {
        return (T) getTemplate().get(clazz, id);
    }


    @Resource
    public final void setMySessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
}
