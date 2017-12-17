package ssh.product.service.impl;

import ssh.product.dao.trends.CollectEntityDao;
import ssh.product.model.trends.CollectEntity;
import ssh.product.service.trends.CollectEntityService;

import java.util.List;

public class CollectEntityServiceImpl implements CollectEntityService {
    private CollectEntityDao collectEntityDao;

    public CollectEntityDao getCollectEntityDao() {
        return collectEntityDao;
    }

    public void setCollectEntityDao(CollectEntityDao collectEntityDao) {
        this.collectEntityDao = collectEntityDao;
    }

    @Override
    public void collectTrends(CollectEntity collectEntity) {
        collectEntityDao.collectTrends(collectEntity);
    }

    @Override
    public List<CollectEntity> judge(Integer user_id, Integer trends_id) {
        return collectEntityDao.judge(user_id,trends_id);
    }

    @Override
    public void deleteCollect(Integer id, Integer user_id) {
        collectEntityDao.deleteTcollect(id,user_id);
    }
}
