package ssh.product.model.circle;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "joincircle", schema = "fxweb")
public class JoincircleEntity {
    private int circleId;
    private int userId;
    private Timestamp joinTime;
    private int id;

    @Basic
    @Column(name = "circle_id")
    public int getCircleId() {
        return circleId;
    }

    public void setCircleId(int circleId) {
        this.circleId = circleId;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "join_time")
    public Timestamp getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Timestamp joinTime) {
        this.joinTime = joinTime;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JoincircleEntity that = (JoincircleEntity) o;

        if (circleId != that.circleId) return false;
        if (userId != that.userId) return false;
        if (id != that.id) return false;
        if (joinTime != null ? !joinTime.equals(that.joinTime) : that.joinTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = circleId;
        result = 31 * result + userId;
        result = 31 * result + (joinTime != null ? joinTime.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
