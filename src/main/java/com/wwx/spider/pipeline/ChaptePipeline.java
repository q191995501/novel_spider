package com.wwx.spider.pipeline;

import com.wwx.spider.model.Chapter;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Wyndem
 * @Description:  章节处理
 * @Date: Created in  2018-08-12 14:56
 * @Modified By:
 */
public abstract class ChaptePipeline implements Pipeline {
    protected List<Chapter> chapters;

    public ChaptePipeline() {
        this.chapters=new ArrayList<>(50);
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        Map<String, Object> all = resultItems.getAll();
        for (Map.Entry<String, Object> entry : all.entrySet()) {
            if (entry.getValue() instanceof Chapter){
                chapters.add((Chapter) entry.getValue());
            }
        }

    }

    public List<Chapter> getChapters() {
        return chapters;
    }

}
