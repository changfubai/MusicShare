package ssh.product.service.circle;

import ssh.product.model.circle.CircleEntity;
import ssh.product.service.BaseService;

import java.util.List;

public interface CircleService  extends BaseService<CircleEntity>{
    public List<CircleEntity> findListByUid(Integer id);
    public List<CircleEntity> findListByUidAndCname(Integer id, String name);
    public List<CircleEntity> findAvaListByUid(Integer id);
    public void deleteByCircleId(Integer id);
}
