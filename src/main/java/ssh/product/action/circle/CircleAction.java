package ssh.product.action.circle;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ssh.product.action.BaseAction;
import ssh.product.model.circle.CircleEntity;
import ssh.product.model.circle.Circles;
import ssh.product.model.circle.JoincircleEntity;
import ssh.product.model.user.UserEntity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller("circleAction")
@Scope("prototype")
public class CircleAction extends BaseAction<CircleEntity>{
    //获取
    public String create(){
        userEntity = (UserEntity)session.get("user");
        if (userEntity == null) {
            map.put("msgl", "圈子发布失败");
        } else {
            model.setUserId(userEntity.getId());
            model.setCreateTime(Timestamp.valueOf(df.format(new Date())));
            circleService.save(model);
            map.put("status",1);
            map.put("msg","圈子发布成功");
            JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
            jsonStr = json.toString();
        }
        return "create";
    }
    public String circle(){
        userEntity = (UserEntity)session.get("user");
        if (userEntity != null) {
            circleslist = new LinkedList<>();
            circlelist = circleService.findListByUid(userEntity.getId());
            joinCirclelist = joinCircleService.findListByUid(userEntity.getId());
            for (JoincircleEntity entity : joinCirclelist) {
                CircleEntity circleEntity = circleService.findById(entity.getCircleId());
                circleslist.add(new Circles(circleEntity, entity));
            }
            fCirclelist = circleService.findAvaListByUid(userEntity.getId());
            //jsonStr = JSONObject.fromObject(list).toString();
        }
        session.put("circleList", circlelist);
        session.put("circlesList", circleslist);
        session.put("fCirclesList", fCirclelist);
        return "circle";
    }
    public String form(){
        return "form";
    }
    public String dissolveCircle(){
        circleService.deleteById(model.getId());
        circleService.deleteByCircleId(model.getId());
        map.put("status",1);
        map.put("msg","来来来，伙伴们排队领便当。");
        map.put("msg1","出了点故障，伙伴们还不想离开你，再等等吧~");
        jsonStr = JSONObject.fromObject(map).toString();
        return "dissolve";
    }

    public String search(){
        userEntity = (UserEntity)session.get("user");
        if (userEntity != null) {
            circlelist = circleService.findListByUidAndCname(userEntity.getId(), model.getName());
            if (circlelist.size() == 0) {
                circlelist = circleService.findAvaListByUid(userEntity.getId());
            }
        }
        jsonStr = JSONArray.fromObject(circlelist).toString();
        return "search";
    }


}
