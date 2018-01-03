package ssh.product.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssh.product.dao.user.UserDao;
import ssh.product.model.user.UserEntity;
import ssh.product.service.BaseServiceImpl;
import ssh.product.service.user.UserService;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<UserEntity> implements UserService {


}
