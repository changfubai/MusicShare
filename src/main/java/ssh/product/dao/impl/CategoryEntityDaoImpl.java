package ssh.product.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import ssh.product.dao.song.CategoryEntityDao;
import ssh.product.model.song.CategoryEntity;

import java.util.List;

public class CategoryEntityDaoImpl extends HibernateDaoSupport implements CategoryEntityDao {
    public List<CategoryEntity> getCategory(){
        List<CategoryEntity> categoryList =( List<CategoryEntity> )this.getHibernateTemplate().find("from CategoryEntity");
//        if(categoryList.size()>0){
//          //  System.out.print("查询到类别的数目为："+categoryList.size());
//            return categoryList;
//        }else{
//            System.out.print("没有查询到类别！"+categoryList.size());
//
//        }
        return categoryList;
    }
}
