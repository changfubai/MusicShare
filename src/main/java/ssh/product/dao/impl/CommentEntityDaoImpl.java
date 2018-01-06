package ssh.product.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
import ssh.product.dao.comment.CommentEntityDao;
import ssh.product.model.comment.CommentEntity;
import ssh.product.model.trends.TrendsEntity;

import java.util.Iterator;
import java.util.List;

@Transactional
public class CommentEntityDaoImpl extends HibernateDaoSupport implements CommentEntityDao {
    //根据主键id找到实体对象
    @Override
    public CommentEntity findById(int id) {
        CommentEntity commentEntity = this.getHibernateTemplate().get(CommentEntity.class,id);
        return commentEntity;
    }
    //删除评论
    @Override
    public void delComment(int id) {
        this.getHibernateTemplate().delete(this.getHibernateTemplate().get(CommentEntity.class,id));
    }
    //回复评论,向数据库添加评论时间、评论内容、评论人id、被回复人的id（parent）
    @Override
    public void setComment(CommentEntity commentEntity) {
        this.getHibernateTemplate().save(commentEntity);
    }

    @Override
    public List<CommentEntity> updateTrendComment(int trendId) {
        List<CommentEntity> theTrend =(List<CommentEntity>)this.getHibernateTemplate()
                .find("from CommentEntity where trends_id=?",trendId);
        //以下为测试输出于控制台的
        System.out.println("length:"+theTrend.size());
        Iterator it = theTrend.iterator();
        while(it.hasNext()){
            CommentEntity stu = (CommentEntity)it.next();
            String name = stu.getContent();//得到了里面的元素的属性了
            System.out.println("neirong:"+stu.getContent());
        }
        return theTrend;
    }

    @Override
    public CommentEntity findtIdBycId(int cid) {
        CommentEntity c=this.getHibernateTemplate().get(CommentEntity.class,cid);
        return c;
    }

    @Override
    public TrendsEntity finduserIdBytId(int tid) {
        return this.getHibernateTemplate().get(TrendsEntity.class,tid);
    }

    //判断评论是否是自己写的
//    @Override
//    public Boolean judgeCommentIsSelf(int user_id, int id) {
//        if((findById(id).getUser_id()) == user_id){
//            return true;
//        }
//        return false;
//    }
}
