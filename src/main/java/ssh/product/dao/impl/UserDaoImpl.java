package ssh.product.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ssh.product.dao.BaseDao;
import ssh.product.dao.BaseDaoImpl;
import ssh.product.dao.user.UserDao;
import ssh.product.model.user.UserEntity;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<UserEntity> implements UserDao{



    //@Override
    //public List<UserEntity> getUser(Integer id) {
    //    return (List<UserEntity>)this.getHibernateTemplate().find("from UserEntity where id=?", id);
    //}
    //
    //@Override
    //public List<UserEntity> getUser() {
    //    return (List<UserEntity>)this.getHibernateTemplate().find("from UserEntity ");
    //}
}
