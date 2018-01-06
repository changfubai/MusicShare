package ssh.product.dao.comment;

import ssh.product.model.comment.CommentEntity;
import ssh.product.model.trends.TrendsEntity;

import java.util.List;

public interface CommentEntityDao {
    CommentEntity findById(int id);    //根据主键id找到实体对象
    void delComment(int id);     //根据主键id删除评论
    void setComment(CommentEntity commentEntity);  //回复评论
    //找出所有属于特定动态下的所有评论
    List<CommentEntity> updateTrendComment(int trendId);//trendId为动态表主键
    CommentEntity findtIdBycId(int cid);//根据评论id找到动态id
    TrendsEntity finduserIdBytId(int tid);//根据动态id获得动态实体
//    Boolean judgeCommentIsSelf(int user_id,int id);  //判断评论是否是自己写的
}
