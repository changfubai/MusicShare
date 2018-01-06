package ssh.product.model.comment;

import ssh.product.model.user.UserEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comment", schema = "fxweb")
public class CommentEntity {

        private int id;
        private int trends_id;
        private String content;
        private int user_id;
        private Timestamp comment_time;
        private int parent;
        private UserEntity user;
        private UserEntity uparent;

        public CommentEntity(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

        @Basic
    public int  getTrends_id() {
        return trends_id;
    }

    public void setTrends_id(int trends_id) {
        this.trends_id = trends_id;
    }

    @Basic
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Basic
    public Timestamp  getComment_time() {
        return comment_time;
    }

    public void setComment_time(Timestamp  comment_time) {
        this.comment_time = comment_time;
    }

    @Basic
    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = UserEntity.class)
    @JoinColumn(name = "user_id",insertable = false, updatable = false)
    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = UserEntity.class)
    @JoinColumn(name = "parent",insertable = false,updatable = false)
    public UserEntity getUparent(){
            return uparent;
    }
    public void setUparent(UserEntity uparent){
        this.uparent=uparent;
    }
}
