package ssh.product.service.trends;

import ssh.product.model.trends.CollectEntity;

import java.util.List;

public interface CollectEntityService {
    void  collectTrends(CollectEntity collectEntity);
    List<CollectEntity> judge(Integer user_id, Integer trends_id);
    void deleteCollect(Integer id,Integer user_id);
}
