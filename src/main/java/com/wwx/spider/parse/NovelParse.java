package com.wwx.spider.parse;

import com.wwx.spider.model.Chapter;
import com.wwx.spider.pipeline.ChaptePipeline;

import java.util.List;

/**
 * 小说接口
 */
public interface NovelParse {
    public ChaptePipeline chaptepipline= new ChaptePipeline();
    public List<Chapter> getChapters(String url);
}
