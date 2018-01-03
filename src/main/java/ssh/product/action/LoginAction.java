package ssh.product.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ssh.product.model.user.UserEntity;
import ssh.product.service.user.UserService;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction  extends BaseAction<UserEntity>{

    public String login(){
        //User user = new User();
        //user.setId(1);
        //List<UserEntity> list = userService.Login(2);
        //if (list.size() > 0) {
        //    UserEntity user = list.get(0);
        //    System.out.println(user.getName());
        //    session.put("user", user);
        //}

        return "loginview";
    }
    public String register(){
        return "regestview";
    }
    public String index(){
        UserEntity userEntity = userService.findById(2);
        if (userEntity != null) {
            System.out.println(userEntity.getName());
            if (session.get("user") == null) {
                session.put("user", userEntity);
            }
        }
        return "index";
    }
}
