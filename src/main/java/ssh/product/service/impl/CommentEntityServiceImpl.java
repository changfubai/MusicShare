package ssh.product.service.impl;

import ssh.product.dao.comment.CommentEntityDao;
import ssh.product.model.comment.CommentEntity;
import ssh.product.model.trends.TrendsEntity;
import ssh.product.service.comment.CommentEntityService;

import java.util.List;

public class CommentEntityServiceImpl implements CommentEntityService {
    private CommentEntityDao commentEntityDao;
//提供commentEntityDao对象的注入通道
    public void setCommentEntityDao(CommentEntityDao commentEntityDao) {
        this.commentEntityDao = commentEntityDao;
    }

    @Override
    public Boolean judgeCommentIsSelf(int user_id, int id) {
        if( commentEntityDao.findById(id).getUser_id() == user_id){
            return true;
        }
        return false;
    }

    @Override
    public CommentEntity findById(int id) {
        if(commentEntityDao.findById(id) != null)
        return commentEntityDao.findById(id);
        return null;
    }

    @Override
    public void delComment(int id) {
        if (commentEntityDao.findById(id) != null)
        commentEntityDao.delComment(id);
    }

    @Override
    public void setComment(CommentEntity commentEntity) {
        if (commentEntity != null){
            commentEntityDao.setComment(commentEntity);
        }
    }

    @Override
    public List<CommentEntity> updateTrendComment(int trendId) {
        return commentEntityDao.updateTrendComment(trendId);
    }
    @Override
    public CommentEntity findtIdBycId(int cid) {
        return commentEntityDao.findtIdBycId(cid);
    }

    @Override
    public TrendsEntity finduserIdBytId(int tid) {
        return commentEntityDao.finduserIdBytId(tid);
    }
}
