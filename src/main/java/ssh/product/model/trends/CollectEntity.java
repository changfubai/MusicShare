package ssh.product.model.trends;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "collect", schema = "fxweb")
public class CollectEntity {
    private int trendsId;
    private int userId;
    private Time collectTime;

    @Basic
    @Column(name = "trends_id")
    public int getTrendsId() {
        return trendsId;
    }

    public void setTrendsId(int trendsId) {
        this.trendsId = trendsId;
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
    @Column(name = "collect_time")
    public Time getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Time collectTime) {
        this.collectTime = collectTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CollectEntity that = (CollectEntity) o;

        if (trendsId != that.trendsId) return false;
        if (userId != that.userId) return false;
        if (collectTime != null ? !collectTime.equals(that.collectTime) : that.collectTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = trendsId;
        result = 31 * result + userId;
        result = 31 * result + (collectTime != null ? collectTime.hashCode() : 0);
        return result;
    }

    private int id;

    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
