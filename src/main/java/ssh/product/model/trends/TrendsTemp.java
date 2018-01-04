package ssh.product.model.trends;

import java.util.Date;

public class TrendsTemp {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrendsTemp that = (TrendsTemp) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (!name.equals(that.name)) return false;
        if (!photo.equals(that.photo)) return false;
        if (!content.equals(that.content)) return false;
        if (!updateTime.equals(that.updateTime)) return false;
        return star.equals(that.star);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + name.hashCode();
        result = 31 * result + photo.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + updateTime.hashCode();
        result = 31 * result + star.hashCode();
        return result;
    }

    private int id;
    private int userId;
    private String name;
    private String photo;
    private String content;
    private Date updateTime;
    private Integer star;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }
}
