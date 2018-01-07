package ssh.product.action.trends;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import ssh.product.model.trends.TrendsEntity;
import ssh.product.model.trends.TrendsTemp;
import ssh.product.model.user.UserEntity;
import ssh.product.service.trends.TrendsEntityService;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class TrendsAction extends ActionSupport implements SessionAware,ModelDriven<TrendsEntity>{
    private TrendsEntity trendsEntity;
    private String result;
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }

    public TrendsEntity getModel(){
        if(trendsEntity==null){
            trendsEntity=new TrendsEntity();
        }
        return trendsEntity;
    }
    private  TrendsEntityService trendsEntityService;

    public TrendsEntityService getTrendsEntityService() {
        return trendsEntityService;
    }

    public void setTrendsEntityService(TrendsEntityService trendsEntityService) {
        this.trendsEntityService = trendsEntityService;
    }
    //修改动态
    public String editTrends(){
        Date untildate=new Date();
        Date time=new Date(untildate.getTime());
        trendsEntity.setUpdateTime(time);
        trendsEntityService.updateTrends(trendsEntity);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status",1);
        map.put("msg","动态修改成功");
        JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
        result = json.toString();//给result赋值，传递给页面
        return "editTrendz";
    }
    //获取要修改的动态
    public String findTrendsById(){
        int id=trendsEntity.getId();
//        System.out.println(id);
        List<TrendsEntity> edTrends= trendsEntityService.findTrendsById(id);
//        edTrends.setImage("nskjasjk");
//        TrendsEntity edTrends2=edTrends.;
//        request.setAttribute("selectempinfo", selectempinfo);
        ActionContext.getContext().getValueStack().set("edTrends",edTrends);
        return "TrendsById";
    }
    public String editshow(){
        return "editlist";
    }
    //发表动态
    public String pushTrends(){
        UserEntity user = (UserEntity) session.get("user");
        Map<String, Object> map = new HashMap<String, Object>();
        if (user != null) {
            Date untildate=new Date();
            Date time=new Date(untildate.getTime());
            trendsEntity.setUpdateTime(time);
            trendsEntity.setUserId(user.getId());
            trendsEntity.setStar(1);
            trendsEntityService.pushTrends(trendsEntity);

            map.put("status",1);
            map.put("msg","动态发布成功");

        }
        map.put("msgl","动态发布失败");
        JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
        result = json.toString();//给result赋值，传递给页面
        return "pushAll";
    }
    public String pushshow(){
        return "pushlist";
    }
    //展示所有的动态
    public String trendsList(){
        List<TrendsTemp> list= trendsEntityService.TrendsList();
//
        ActionContext.getContext().getValueStack().set("list", list);
        return "trendslist";
    }
    //展示自己发布的动态
    public String mytrendsList(){
        //根据session获取登陆人的id
        UserEntity user = (UserEntity) session.get("user");

        int user_id= user.getId();
        System.out.println(user_id);
//        int user_id=1;
//        System.out.println(user_id);
        List<TrendsTemp> myList=trendsEntityService.MyTrendsList(user_id);
        ActionContext.getContext().getValueStack().set("mylist", myList);
        return "mytrendslist";
    }
    //删除动态
    public String deleteTrends(){
        int id=trendsEntity.getId();
        trendsEntityService.deleteTrends(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status",1);
        map.put("msg","动态删除成功");
        JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
        result = json.toString();//给result赋值，传递给页面
        return "deletTrends";
    }
    //点赞
    public String thumbTrends(){
        int id=trendsEntity.getId();
        trendsEntityService.thumbTrends(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status",1);
        map.put("msg","点赞成功");
        JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
        result = json.toString();//给result赋值，传递给页面
        return "thumbTrends";
    }
    //收藏的动态
    public String collectTrends(){
        UserEntity user = (UserEntity) session.get("user");
            int user_id = user.getId();
//            System.out.println(user_id);
        List<TrendsTemp> mycollect=trendsEntityService.MyCollect(user_id);
//        System.out.println(mycollect.toArray());
        ActionContext.getContext().getValueStack().set("mycollect", mycollect);
        return "collect";
    }
    //获取指定圈子的动态
    public String getAll(){
        int circle_id = trendsEntity.getId();
        List<TrendsTemp> myList=trendsEntityService.GetAllTrendsList(circle_id);
        ActionContext.getContext().getValueStack().set("list", myList);
        return "trendslist";
    }
    //上传图片

    /**
     * 图片对象
     */
    private File imgFile;

    /**
     * 图片宽度
     */
    private String imgWidth;

    /**
     * 图片高度
     */
    private String imgHeight;

    /**
     * 图片对齐方式
     */
    private String align;

    /**
     * 图片标题
     */
    private String imgTitle;

    public File getImgFile() {
        return imgFile;
    }

    public void setImgFile(File imgFile) {
        this.imgFile = imgFile;
    }

    public String getImgWidth() {
        return imgWidth;
    }

    public void setImgWidth(String imgWidth) {
        this.imgWidth = imgWidth;
    }

    public String getImgHeight() {
        return imgHeight;
    }

    public void setImgHeight(String imgHeight) {
        this.imgHeight = imgHeight;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getImgTitle() {
        return imgTitle;
    }

    public void setImgTitle(String imgTitle) {
        this.imgTitle = imgTitle;
    }

    /**
     * 上传图片
     * @return
     */
    public String uploadImage(){
        String imageName = "topic_"+new Date().getTime()+Math.random()*10000+".jpg";
        System.out.println(ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/"));
        File dirPath =new File(ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/")+"\\upload\\articleimage\\");
        //如果文件夹不存在，创建它
        if(!dirPath.exists()){
            dirPath.mkdirs();
        }
        //文件存放路径
        String newPath = dirPath+"\\"+imageName;
        //上传文件
        try {
            copy(imgFile, newPath);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        String id = "content";
        String url = "http://" + org.apache.struts2.ServletActionContext.getRequest()
                .getLocalAddr() + ":"+ org.apache.struts2.ServletActionContext.getRequest()
                .getServerPort()   + org.apache.struts2.ServletActionContext.getRequest()
                .getContextPath()
                +"/upload/articleimage/" + imageName;

        String border = "0";
        String result =
                "<script type=\"text/javaScript\">parent.KE.plugin[\"image\"].insert(\""
                        + id
                        + "\",\""
                        + url
                        + "\",\""
                        + imgTitle
                        + "\",\""
                        + imgWidth
                        + "\",\""
                        + imgHeight
                        + "\",\""
                        + border + "\""
                        +");</script>";
        PrintWriter out = null;
        try {
            out = encodehead(ServletActionContext.getRequest(), ServletActionContext.getResponse());
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.write(result);
        out.close();
        return null;
    }

    /**
     * 拷贝文件
     *
     * @throws Exception
     */
    private void copy(File upload, String newPath) throws Exception {
        FileOutputStream fos = new FileOutputStream(newPath);
        FileInputStream fis = new FileInputStream(upload);
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = fis.read(buffer)) > 0) {
            fos.write(buffer, 0, len);
        }
        fos.close();
        fis.close();
    }

    /**
     * Ajax辅助方法 获取 PrintWriter
     * @return
     * @throws IOException
     * @throws IOException
     * request.setCharacterEncoding("utf-8");
    response.setContentType("text/html; charset=utf-8");
     */
    private PrintWriter encodehead(HttpServletRequest request,HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        return response.getWriter();
    }
    protected Map<String, Object> session;
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
