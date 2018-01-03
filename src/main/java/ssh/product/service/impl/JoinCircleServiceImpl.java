package ssh.product.service.impl;

import org.springframework.stereotype.Service;
import ssh.product.model.circle.JoincircleEntity;
import ssh.product.service.BaseServiceImpl;
import ssh.product.service.circle.JoinCircleService;

import java.util.List;

@Service("joinCircleService")
public class JoinCircleServiceImpl extends BaseServiceImpl<JoincircleEntity> implements JoinCircleService {

    @Override
    public List<JoincircleEntity> findListByUid(Integer id) {
        return joinCircleDao.findListByUid(id);
    }

}
