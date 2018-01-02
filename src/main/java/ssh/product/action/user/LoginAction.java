package ssh.product.action.user;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssh.product.dao.impl.UserEntityDaoImpl;
import ssh.product.dao.user.UserEntityDao;
import ssh.product.model.user.UserEntity;

public class LoginAction extends ActionSupport implements ModelDriven<UserEntity> {
    ClassPathXmlApplicationContext resource;   //获取applicationXml文件
    UserEntityDao dao;
    String result = null;
    private String error=null;


    /* 访问注册页面*/
    public String page() {
        return "loginPage";

    }

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


    /* 点击'登录'按钮后，验证用户名密码是否一致 */
    public String success() throws Exception {
        resource = new ClassPathXmlApplicationContext("applicationContext.xml");
        dao = (UserEntityDao) resource.getBean("userEntityDao");
//        System.out.println("!!!!!!!!!!!!!dao为:"+dao);
//        System.out.println("!!!!!!!user为:"+user );
        String account = user.getAccount();
        String password = user.getPassword();
 //       System.out.print("账户:"+account+" 密码："+password);
        UserEntity curuser = dao.login(user.getAccount(), user.getPassword());
        if (curuser == null) {   //登录失败
            System.out.print( "用户名或密码错误");
            result="loginPage";
        }else {
            System.out.print( "登录成功！");
            result = "loginSuccess";
        }
        return result;
    }
}
