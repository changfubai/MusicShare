package ssh.product.service.trends;

import ssh.product.model.trends.TrendsEntity;

import java.util.List;

public interface TrendsEntityService {
    List<TrendsEntity> TrendsList();
    List<TrendsEntity> MyTrendsList(Integer user_id);
    void pushTrends(TrendsEntity trendsEntity);
    List<TrendsEntity> MyCollect(Integer user_id);
    List<TrendsEntity> findTrendsById(Integer id);
    void updateTrends(TrendsEntity trendsEntity);
    void deleteTrends(Integer id);
    void thumbTrends(Integer id);
}
