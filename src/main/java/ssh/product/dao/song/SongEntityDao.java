package ssh.product.dao.song;

import ssh.product.model.song.SongEntity;

import java.util.List;

public interface SongEntityDao {
    public List<SongEntity> getSong(int categoryId);
}
