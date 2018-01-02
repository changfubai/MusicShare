package ssh.product.dao.user;

import ssh.product.model.user.UserEntity;


/*
 2017/12/18 15:42 定义userEnityDao层 用于登录注册

 */
public interface UserEntityDao {
    public UserEntity login(String username, String password);   //登录验证
    public  UserEntity  checkAccount(String account);   //注册检验账户是否被注册
    public  String saveInfo(UserEntity newUser) ; //注册好的信息放入数据库中
}
