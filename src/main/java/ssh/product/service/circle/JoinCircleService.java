package ssh.product.service.circle;

import ssh.product.model.circle.JoincircleEntity;
import ssh.product.service.BaseService;

import java.util.List;

public interface JoinCircleService extends BaseService<JoincircleEntity> {
    public List<JoincircleEntity> findListByUid(Integer id);
}
