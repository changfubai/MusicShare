package ssh.product.service.trends;

import ssh.product.model.trends.TrendsEntity;
import ssh.product.model.trends.TrendsTemp;

import java.util.List;

public interface TrendsEntityService {
    List<TrendsTemp> TrendsList();
    List<TrendsTemp> MyTrendsList(Integer user_id);
    void pushTrends(TrendsEntity trendsEntity);
    List<TrendsTemp> MyCollect(Integer user_id);
    List<TrendsEntity> findTrendsById(Integer id);
    void updateTrends(TrendsEntity trendsEntity);
    void deleteTrends(Integer id);
    void thumbTrends(Integer id);
}
