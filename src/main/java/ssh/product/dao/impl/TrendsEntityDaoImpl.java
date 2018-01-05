package ssh.product.dao.impl;


import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import ssh.product.dao.trends.TrendsEntityDao;
import ssh.product.model.trends.CollectEntity;
import ssh.product.model.trends.TrendsEntity;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Transactional
public class TrendsEntityDaoImpl extends HibernateDaoSupport implements TrendsEntityDao{
    //修改动态
    @Resource
    private SessionFactory sessionFactory;
    public void updateTrends(TrendsEntity trendsEntity) {
//        getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
//        trendsEntity.getContent(trendsEntity.getContent());
//        TrendsEntity trendsEntity2= trendsEntity.setContent();
        int id=trendsEntity.getId();
        String content=trendsEntity.getContent();
        String hql ="update TrendsEntity t set t.content='"+content+"' where t.id="+id;
        this.getHibernateTemplate().bulkUpdate(hql);
    }
    //删除动态
    @Override
    public void deleteTrends(Integer id) {
//        int id=trendsEntity.getId();
        String hql ="delete TrendsEntity t where t.id="+id;
        this.getHibernateTemplate().bulkUpdate(hql);
    }

    //根据id查询出要修改的动态
    @Override
   public List<TrendsEntity> findTrendsById(Integer id) {
        List<TrendsEntity> editTrends=(List<TrendsEntity>) this.getHibernateTemplate().find("from TrendsEntity where id=?",id);
        return editTrends;
    }

    //发表动态
    @Override
    public void  pushTrends(TrendsEntity trendsEntity) {
        getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        this.getHibernateTemplate().save(trendsEntity);
    }
    //展示全部动态
    public  List TrendsList() {
        Session session= sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("select user.name,trends.user_id,user.photo,trends .id,trends.content,trends .star,trends.update_time from trends,user  where trends.user_id=user .id ");
        List list=query.list();
//        List<TrendsEntity> list = (List<TrendsEntity>) this.getHibernateTemplate().find("from TrendsEntity ");
        return list;
    }
    //点赞功能
    @Override
    public void thumbTrends(Integer id) {
        int m=0;
        List<TrendsEntity> editTrends=(List<TrendsEntity>) this.getHibernateTemplate().find("from TrendsEntity where id=?",id);
        //遍历list然后给m赋值
        for(TrendsEntity tre : editTrends) {
            m=tre.getStar();
        }
        m=m+1;
        String hql ="update TrendsEntity t set t.star='"+m+"' where t.id="+id;
        this.getHibernateTemplate().bulkUpdate(hql);
    }

    @Override
    public List MyCollect(Integer user_id) {
//        List<TrendsEntity> mycollect=new ArrayList<>();
        Session session= sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("select user.name,user.photo,trends .id,trends.content,trends .star,trends.update_time from trends,collect,user  where trends.id=collect .trends_id and trends.user_id=user.id  and collect.user_id="+user_id);
        List myList=query.list();
//        List myList=  this.getHibernateTemplate().find("from TrendsEntity trends,CollectEntity collect where trends.id=collect.trendsId and collect.userId=?",user_id);

//        System.out.println(myList);
        return myList;
    }

    @Override
    //展示自己发布的动态
    public List MyTrendsList(Integer user_id) {
        Session session= sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("select user.name,user.photo,trends .id,trends.content,trends .star,trends.update_time from trends,user  where trends.user_id=user.id and trends.user_id= "+user_id);
        List list=query.list();
//        List<TrendsEntity> list = (List<TrendsEntity>) this.getHibernateTemplate().find("from TrendsEntity ");
        return list;
    }
}
