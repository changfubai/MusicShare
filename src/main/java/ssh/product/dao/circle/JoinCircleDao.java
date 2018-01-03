package ssh.product.dao.circle;

import ssh.product.dao.BaseDao;
import ssh.product.model.circle.JoincircleEntity;

import java.util.List;

public interface JoinCircleDao extends BaseDao<JoincircleEntity>{
    public List<JoincircleEntity> findListByUid(Integer id);
}
