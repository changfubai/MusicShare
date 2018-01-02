package ssh.product.action.song;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ssh.product.dao.song.CategoryEntityDao;
import ssh.product.dao.song.SongEntityDao;
import ssh.product.model.song.CategoryEntity;
import ssh.product.model.song.SongEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class categoryAction  extends ActionSupport {
    ClassPathXmlApplicationContext resource;
    CategoryEntityDao categoryEntityDao;
    SongEntityDao songEntityDao;
    HttpSession session = ServletActionContext.getRequest().getSession();

    public CategoryEntity categoryEntity=new CategoryEntity();
    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }


    //得到商品分类的目录
    public String execute() throws Exception{
       String[] info=new String[500];
        String str="";
        /*
        先从categoryEntity中获取音乐的类别的id
         */
        System.out.println("调用到categoryAction!!!");
        resource=new ClassPathXmlApplicationContext("applicationContext.xml");
        categoryEntityDao=(CategoryEntityDao) resource.getBean("categoryEntityDao");
        songEntityDao=(SongEntityDao)resource.getBean("songEntityDao");

        List<CategoryEntity> categoryList=categoryEntityDao.getCategory();
        for (int i=0;i<categoryList.size();i++){
            /* 获取到类别id之后 到songEntity中获取对应的歌曲*/
            str=str+categoryList.get(i).getName()+'#';

            List<SongEntity> songList=songEntityDao.getSong(categoryList.get(i).getId());
            for (int j=0;j<songList.size();j++){

                str=str+songList.get(j).getId()+","+songList.get(j).getTitle()+","+songList.get(j).getPhoto()+";";

            }

            info[i]=str;
            str="";

        }

        session.setAttribute("info",info);

        return "success";

    }
}
