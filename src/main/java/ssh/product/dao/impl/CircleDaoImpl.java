package ssh.product.dao.impl;

import org.springframework.stereotype.Repository;
import ssh.product.dao.BaseDaoImpl;
import ssh.product.dao.circle.CircleDao;
import ssh.product.model.circle.CircleEntity;
import ssh.product.model.circle.JoincircleEntity;

import java.util.List;
@Repository("circleDao")
public class CircleDaoImpl extends BaseDaoImpl<CircleEntity> implements CircleDao{

    @Override
    public List<CircleEntity> findListByUid(Integer id) {
        return (List<CircleEntity>) getTemplate().find("from CircleEntity where userId = ?",id);

    }

    @Override
    public void deleteByCircleId(Integer id) {
        List<JoincircleEntity> list = (List<JoincircleEntity>) getTemplate().find("from JoincircleEntity where circleId = ?", id);
        if (list.size() > 0) {
            getTemplate().deleteAll(list);
        }
    }

    @Override
    public List<CircleEntity> findListByUidAndCname(Integer id, String name) {
        String hql = "from CircleEntity where id not in (select circleId from JoincircleEntity where userId = " + id + ") and name like ?";
        List<CircleEntity> list = (List<CircleEntity>) getTemplate().find(hql,"%"+name+"%");
        return list;
    }



    @Override
    public List<CircleEntity> findAvaListByUid(Integer id) {
        List<CircleEntity> list = (List<CircleEntity>) getTemplate().find("from CircleEntity where id not in (select circleId from JoincircleEntity where userId = ?)", id);
        return list;
    }

}
