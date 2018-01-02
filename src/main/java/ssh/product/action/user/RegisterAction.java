package ssh.product.action.user;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssh.product.dao.user.UserEntityDao;
import ssh.product.model.user.UserEntity;

import java.util.Date;
import java.sql.Timestamp;

public class RegisterAction extends ActionSupport implements ModelDriven<UserEntity> {

    private UserEntityDao userEntityDao;
    //    UserEntity newUser;      //user实体类存放信息
    ClassPathXmlApplicationContext resource;   //获取applicationXml文件
    UserEntityDao dao;
    String result = null;
   private String error=null;


    /* 访问注册页面*/
    public String page() {
        return "registerPage";

    }

//    public UserEntityDao getUserEntityDao() {
//        return userEntityDao;
//    }
//
//    public void setUserEntityDao(UserEntityDao userEntityDao) {
//        this.userEntityDao = userEntityDao;
//    }

    /* 点击'注册'按钮之后，验证功能
        * 以电话号号码作为账号，新用户在注册的时候要验证用户使用的手机号是否被注册
        * */
    private UserEntity user = new UserEntity();

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public UserEntity getModel() {
        return user;
    }


    public String success() {

        resource = new ClassPathXmlApplicationContext("applicationContext.xml");
        dao = (UserEntityDao) resource.getBean("userEntityDao");

        if (dao.checkAccount(user.getAccount()) != null){
            error="该账号已被注册！";
            //如果该账号没有被注册
            System.out.print(user.getAccount()+error);

        }else{
            user.setSex(1);
            user.setEmail("null");
            user.setPhoto("null");
            user.setRegisterTime(new Timestamp(new Date().getTime()));
            result = dao.saveInfo(user);   //将注册信息存到数据库中
            error="";


        }


      //  result = dao.saveInfo(user);   //将注册信息存到数据库中
//        if (result.equals("registerFail")) {
//            System.out.print("注册失败！");
//            return "registerFail";
//        } else {
//            System.out.print("注册成功！");
//        }
        return result;
    }
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }



}