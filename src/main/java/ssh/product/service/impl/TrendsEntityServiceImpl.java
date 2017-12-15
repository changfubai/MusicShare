package ssh.product.service.impl;


import org.springframework.transaction.annotation.Transactional;
import ssh.product.dao.trends.TrendsEntityDao;
import ssh.product.model.trends.TrendsEntity;
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
    public List<TrendsEntity> MyCollect(Integer user_id) {
//        List<TrendsEntity> mycollect=new ArrayList<TrendsEntity>();
//        List list=trendsEntityDao.MyCollect(user_id);
//        for(int i=0;i<list.size();i++){
//            Object[] object= (Object[]) list.get(i);
//            String
//        }
        List stuList=trendsEntityDao.MyCollect(user_id);
        TrendsEntity tre;
        List mylist=new ArrayList<>();
        for(int i = 0; i < stuList.size();i++){
             tre= new TrendsEntity();
            Object[] object = (Object[])stuList.get(i);
            tre.setId((Integer) object[0]);
            tre.setContent((String) object[1]);
            tre.setStar((Integer) object[2]);
            tre.setUpdateTime((Date) object[3]);
            mylist.add(tre); // 最终封装在list中 传到前台。
        }
        return mylist;
    }

    public List<TrendsEntity> TrendsList() {
        return trendsEntityDao.TrendsList();
    }

    @Override
    public List<TrendsEntity> MyTrendsList(Integer user_id) {
        return trendsEntityDao.MyTrendsList(user_id);
    }
}
