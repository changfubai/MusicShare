package ssh.product.action.song;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import ssh.product.model.song.SongEntity;

/*
2017/12/29 16:02 @Fangzq
主页展示中“热门推荐” “新品上架”模块 音乐展示
想法：先从category表中获取类别id,在从song表中找出对应类别下的歌曲，然后把他们展示粗来。
 */

public class songAction extends ActionSupport implements ModelDriven<SongEntity>{
    private SongEntity song=new SongEntity();

    @Override
    public SongEntity getModel() {
        return song;
    }
}
