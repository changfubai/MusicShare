package ssh.product.action.trends;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONObject;
import ssh.product.model.trends.CollectEntity;
import ssh.product.service.trends.CollectEntityService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectAction extends ActionSupport implements ModelDriven<CollectEntity>{
    private CollectEntity collectEntity;
    private String result;
    private CollectEntityService collectEntityService;

    public CollectEntityService getCollectEntityService() {
        return collectEntityService;
    }

    public void setCollectEntityService(CollectEntityService collectEntityService) {
        this.collectEntityService = collectEntityService;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public CollectEntity getModel() {
        if(collectEntity==null){
            collectEntity=new CollectEntity();
        }
        return collectEntity;
    }
    //收藏
    public String collectTrends(){
//        Date untildate=new Date();
//        Date time=new Date(untildate.getTime());
//        collectEntity.setCollectTime(time);
//        trendsEntity.setUpdateTime(time);
        int user_id=collectEntity.getUserId();
        int trends_id=collectEntity.getTrendsId();
        List<CollectEntity> jutremds= collectEntityService.judge(user_id,trends_id);
        Map<String, Object> map = new HashMap<String, Object>();
        if(jutremds.size()==0){
            collectEntityService.collectTrends(collectEntity);
            map.put("status",1);
            map.put("msg","收藏成功");
        }else {
            map.put("status",2);
            map.put("msgl","该动态已被您收藏");
        }

        JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
        result = json.toString();
        return "collectTrends";
    }
    //取消收藏
    public String cutcollect(){
        int id=collectEntity.getTrendsId();
        int user_id=2;
        collectEntityService.deleteCollect(id,user_id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status",1);
        map.put("msg","取消收藏成功");
        JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
        result = json.toString();
        return "cutc";
    }
}
