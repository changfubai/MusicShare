package ssh.product.action.circle;

import net.sf.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ssh.product.action.BaseAction;
import ssh.product.model.circle.JoincircleEntity;
import ssh.product.model.user.UserEntity;

import java.sql.Timestamp;
import java.util.Date;

@Controller("joinCircleAction")
@Scope("prototype")
public class JoinCircleAction extends BaseAction<JoincircleEntity>{
    public String joinCircleList(){
        userEntity = (UserEntity)session.get("user");
        if (userEntity != null) {
            joinCirclelist = joinCircleService.findListByUid(userEntity.getId());
            //jsonStr = JSONObject.fromObject(list).toString();
        }
        session.put("joinCircleList", joinCirclelist);
        return "joinCircleList";
    }
    public String join(){
        userEntity = (UserEntity)session.get("user");
        if (userEntity != null) {
            model.setUserId(userEntity.getId());
            model.setJoinTime(Timestamp.valueOf(df.format(new Date())));
            joinCircleService.save(model);
            map.put("status",1);
            map.put("msg","加入成功~");
        }
        map.put("msg1","出了点故障，稍微等等吧~~");
        jsonStr = JSONObject.fromObject(map).toString();
        return "join";
    }
    public String quit(){
        joinCircleService.deleteById(model.getId());
        map.put("status",1);
        map.put("msg","我们会想你的~");
        map.put("msg1","出了点故障，再和大家待会吧~~");
        jsonStr = JSONObject.fromObject(map).toString();
        return "quit";
    }
}
