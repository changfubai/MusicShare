package ssh.product.dao.trends;

import ssh.product.model.trends.TrendsEntity;

import java.util.List;

public interface TrendsEntityDao {
    List TrendsList();
    List MyTrendsList(Integer user_id);
    void  pushTrends(TrendsEntity trendsEntity);
    List<TrendsEntity> findTrendsById(Integer id);
    void updateTrends(TrendsEntity trendsEntity);
    void deleteTrends(Integer id);
    void thumbTrends(Integer id);
    List MyCollect(Integer user_id);
}
