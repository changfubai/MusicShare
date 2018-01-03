package ssh.product.model.circle;

import java.sql.Timestamp;

public class Circles {
    private int id;
    private int circleId;
    private String name;
    private String desc;
    private int createrId;
    private int userId;
    private Timestamp createTime;
    private Timestamp joinTime;

    public Circles(CircleEntity circleEntity, JoincircleEntity joincircleEntity) {
        this.id = joincircleEntity.getId();
        this.name = circleEntity.getName();
        this.desc = circleEntity.getDescription();
        this.createrId = circleEntity.getUserId();
        this.userId = joincircleEntity.getUserId();
        this.createTime = circleEntity.getCreateTime();
        this.joinTime = joincircleEntity.getJoinTime();
        this.circleId = circleEntity.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getCreaterId() {
        return createrId;
    }

    public void setCreaterId(int createrId) {
        this.createrId = createrId;
    }

    public Timestamp getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Timestamp joinTime) {
        this.joinTime = joinTime;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circles that = (Circles) o;

        if (id != that.getId()) return false;
        if (userId != that.getUserId()) return false;
        if (name != null ? !name.equals(that.getName()) : that.getName() != null) return false;
        if (desc != null ? !desc.equals(that.getDesc()) : that.getDesc() != null) return false;
        if (createTime != null ? !createTime.equals(that.getCreateTime()) : that.getCreateTime() != null) return false;
        if (joinTime != null ? !joinTime.equals(that.getJoinTime()) : that.getJoinTime() != null) return false;
        if (createrId != that.getCreaterId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + userId;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }


    public int getCircleId() {
        return circleId;
    }

    public void setCircleId(int circleId) {
        this.circleId = circleId;
    }
}
