package ssh.product.dao.impl;

import org.hibernate.FlushMode;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import ssh.product.dao.trends.CollectEntityDao;
import ssh.product.model.trends.CollectEntity;

import java.util.List;

@Transactional
public class CollectEntityDaoImpl extends HibernateDaoSupport implements CollectEntityDao {

    @Override
    public void collectTrends(CollectEntity collectEntity) {
        getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        this.getHibernateTemplate().save(collectEntity);
    }

    @Override
    public void deleteTcollect(Integer id, Integer user_id) {
        this.getHibernateTemplate().bulkUpdate("delete CollectEntity t where t.trendsId=? and t.userId=?",id,user_id);
    }

    @Override
    public List<CollectEntity> judge(Integer user_id, Integer trends_id) {
        List<CollectEntity> list = (List<CollectEntity>) this.getHibernateTemplate().find("from CollectEntity where userId=? and trendsId=?",user_id,trends_id);
        return list;
    }


}
