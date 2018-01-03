package ssh.product.dao.circle;

import ssh.product.dao.BaseDao;
import ssh.product.model.circle.CircleEntity;

import java.util.List;

public interface CircleDao extends BaseDao<CircleEntity>{
    public List<CircleEntity> findListByUid(Integer id);
    public void deleteByCircleId(Integer id);
    public List<CircleEntity> findListByUidAndCname(Integer id, String name);
    public List<CircleEntity> findAvaListByUid(Integer id);
}
