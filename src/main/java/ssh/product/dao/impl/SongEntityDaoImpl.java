package ssh.product.dao.impl;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import ssh.product.dao.song.SongEntityDao;
import ssh.product.model.song.SongEntity;

import java.util.List;

public class SongEntityDaoImpl extends HibernateDaoSupport implements SongEntityDao{
    public List<SongEntity> getSong(int categoryId){
        List<SongEntity> list=( List<SongEntity> )this.getHibernateTemplate().find("from SongEntity" +
                " u where u.category=? ",categoryId);
        return list;

    }

}
