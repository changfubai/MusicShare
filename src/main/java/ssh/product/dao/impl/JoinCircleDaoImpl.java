package ssh.product.dao.impl;

import org.springframework.stereotype.Repository;
import ssh.product.dao.BaseDaoImpl;
import ssh.product.dao.circle.JoinCircleDao;
import ssh.product.model.circle.JoincircleEntity;

import java.util.List;
@Repository("joinCircleDao")
public class JoinCircleDaoImpl extends BaseDaoImpl<JoincircleEntity> implements JoinCircleDao {

    @Override
    public List<JoincircleEntity> findListByUid(Integer id) {
        return (List<JoincircleEntity>) getTemplate().find("from JoincircleEntity where userId = ?",id);

    }
}
