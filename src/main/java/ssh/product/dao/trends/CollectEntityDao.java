package ssh.product.dao.trends;

import ssh.product.model.trends.CollectEntity;

import java.util.List;

public interface CollectEntityDao {
    void  collectTrends(CollectEntity collectEntity);
    void deleteTcollect(Integer id,Integer user_id);
    List<CollectEntity> judge(Integer user_id,Integer trends_id);
}
