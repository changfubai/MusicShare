package ssh.product.service.impl;


import org.springframework.transaction.annotation.Transactional;
import ssh.product.dao.trends.TrendsEntityDao;
import ssh.product.model.trends.TrendsEntity;
import ssh.product.model.trends.TrendsTemp;
import ssh.product.service.trends.TrendsEntityService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Transactional
public class TrendsEntityServiceImpl implements TrendsEntityService {
    private TrendsEntityDao trendsEntityDao;


    public TrendsEntityDao getTrendsEntityDao() {
        return trendsEntityDao;
    }

    public void setTrendsEntityDao(TrendsEntityDao trendsEntityDao) {
        this.trendsEntityDao = trendsEntityDao;
    }
    @Override
    public void updateTrends(TrendsEntity trendsEntity) {
        trendsEntityDao.updateTrends(trendsEntity);
    }

    @Override
    public void deleteTrends(Integer id) {
        trendsEntityDao.deleteTrends(id);
    }

    @Override
    public void thumbTrends(Integer id) {
        trendsEntityDao.thumbTrends(id);
    }

    @Override
    public List<TrendsEntity> findTrendsById(Integer id) {
        return trendsEntityDao.findTrendsById(id);
    }

    @Override
    public void pushTrends(TrendsEntity trendsEntity) {
        trendsEntityDao.pushTrends(trendsEntity);
    }

    @Override
    public List<TrendsTemp> MyCollect(Integer user_id) {
//        List<TrendsEntity> mycollect=new ArrayList<TrendsEntity>();
//        List list=trendsEntityDao.MyCollect(user_id);
//        for(int i=0;i<list.size();i++){
//            Object[] object= (Object[]) list.get(i);
//            String
//        }
        List stuList=trendsEntityDao.MyCollect(user_id);
        TrendsTemp tre4;
        List mylist=new ArrayList<>();
        for(int i = 0; i < stuList.size();i++){
            tre4= new TrendsTemp();
            Object[] object = (Object[])stuList.get(i);
            tre4.setName((String) object[0]);
            tre4.setPhoto((String) object[1]);
            tre4.setId((Integer) object[2]);
            tre4.setContent((String) object[3]);
            tre4.setStar((Integer) object[4]);
            tre4.setUpdateTime((Date) object[5]);
            mylist.add(tre4); // 最终封装在list中 传到前台。
        }
        return mylist;
    }

    public List<TrendsTemp> TrendsList() {
        List stuList=trendsEntityDao.TrendsList();
        TrendsTemp tre;
        List mylist=new ArrayList<>();
        for(int i = 0; i < stuList.size();i++){
            tre= new TrendsTemp();
            Object[] object = (Object[])stuList.get(i);
            tre.setName((String) object[0]);
            tre.setUserId((Integer) object[1]);
            tre.setPhoto((String) object[2]);
            tre.setId((Integer) object[3]);
            tre.setContent((String) object[4]);
            tre.setStar((Integer) object[5]);
            tre.setUpdateTime((Date) object[6]);
            mylist.add(tre); // 最终封装在list中 传到前台。
        }
        return mylist;
    }

    @Override
    public List GetAllTrendsList(Integer circleId) {
        List stuList=trendsEntityDao.GetAllTrendsList(circleId);
        TrendsTemp tre;
        List mylist=new ArrayList<>();
        for(int i = 0; i < stuList.size();i++){
            tre= new TrendsTemp();
            Object[] object = (Object[])stuList.get(i);
            tre.setName((String) object[0]);
            tre.setUserId((Integer) object[1]);
            tre.setPhoto((String) object[2]);
            tre.setId((Integer) object[3]);
            tre.setContent((String) object[4]);
            tre.setStar((Integer) object[5]);
            tre.setUpdateTime((Date) object[6]);
            mylist.add(tre); // 最终封装在list中 传到前台。
        }
        return mylist;
    }

    @Override
    public List<TrendsTemp> MyTrendsList(Integer user_id) {
        List stuList=trendsEntityDao.MyTrendsList(user_id);
        TrendsTemp tre2;
        List mylist=new ArrayList<>();
        for(int i = 0; i < stuList.size();i++){
            tre2= new TrendsTemp();
            Object[] object = (Object[])stuList.get(i);
            tre2.setName((String) object[0]);
            tre2.setPhoto((String) object[1]);
            tre2.setId((Integer) object[2]);
            tre2.setContent((String) object[3]);
            tre2.setStar((Integer) object[4]);
            tre2.setUpdateTime((Date) object[5]);
            mylist.add(tre2); // 最终封装在list中 传到前台。
        }
        return mylist;
    }
}
