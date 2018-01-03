package ssh.product.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import ssh.product.dao.user.UserEntityDao;
import ssh.product.model.user.UserEntity;

import java.util.List;

@Transactional
public class UserEntityDaoImpl  extends HibernateDaoSupport  implements UserEntityDao{
    /*
    查询账户和密码对应的用户信息
     */
    public  UserEntity login(String account, String password){

            List<UserEntity> list=( List<UserEntity> )this.getHibernateTemplate().find("from UserEntity" +
                    " u where u.account=? and u.password=?",account,password);
            if(list != null && list.size()>0){
                return list.get(0);
            }
        return null;
    }   //登录验证


    //查询数据库中的账户是否被注册
    public UserEntity  checkAccount(String account){

        System.out.println("传来的参数account为："+account);
        System.out.println("this.getHibernateTemplate()的值为："+this.getHibernateTemplate());

        List<UserEntity> list=( List<UserEntity> )this.getHibernateTemplate().find("from UserEntity u where u.account=?",account);
        if(list !=null  && list.size()>0){
//            System.out.print("该账号："+account+"已经被注册");
            return list.get(0);

        }
        return null;    //该账户没有被注册！
    }

    //新注册用户的信息存放到数据库中
    public String  saveInfo(UserEntity newUser){
        try {
           // System.out.println("saveinfo::this.getHibernateTemplate()的值为："+this.getHibernateTemplate());

            this.getHibernateTemplate().save(newUser);
        }catch (Exception e){
            e.printStackTrace();
            return "registerFail";

        }
        return "registerSuccess";

    }
}
