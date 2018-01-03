package ssh.product.service.impl;

import org.springframework.stereotype.Service;
import ssh.product.model.circle.CircleEntity;
import ssh.product.service.BaseServiceImpl;
import ssh.product.service.circle.CircleService;

import java.util.List;

@Service("circleService")
public class CircleServiceImp extends BaseServiceImpl<CircleEntity> implements CircleService{
    @Override
    public List<CircleEntity> findListByUid(Integer id) {
        return circleDao.findListByUid(id);
    }

    @Override
    public List<CircleEntity> findListByUidAndCname(Integer id, String name) {
        return circleDao.findListByUidAndCname(id, name);
    }

    @Override
    public List<CircleEntity> findAvaListByUid(Integer id) {
        return circleDao.findAvaListByUid(id);
    }

    @Override
    public void deleteByCircleId(Integer id) {
        circleDao.deleteByCircleId(id);
    }
}
