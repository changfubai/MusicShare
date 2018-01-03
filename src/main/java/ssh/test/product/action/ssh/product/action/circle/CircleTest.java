package ssh.test.product.action.ssh.product.action.circle;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssh.product.dao.user.UserDao;
import ssh.product.model.user.UserEntity;

import java.util.List;

public class CircleTest {

    private static UserDao userDao;
    @BeforeClass
    public static void init() {
        //ApplicationContext
        //        context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //userDao = (UserDao) context.getBean("userDao");
    }
    @Test
    public void testUser(){
        //List<UserEntity> users = userDao.getUser(1);
        //System.out.println(users.get(0).getName());
        //User user = new User();
        //user.setAccount("135620");
        //user.setName("xia");
        //SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //user.setRegisterTime(Timestamp.valueOf(df.format(new Date())));
        //userDao.save(user);
    }

}
