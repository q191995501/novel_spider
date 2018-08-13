package com.wwx.spider.parse;

import com.wwx.spider.model.Book;
import com.wwx.spider.model.Chapter;

import java.util.List;

/**
 * 小说接口
 */
public interface NovelParse<T extends Book> {
     /**
      * @title: 获取章节
      * @description: 通过小说url获取章节
      * @author:  Wyndem
      * @date:  2018/8/13  15:56
      **/
    public List<Chapter> getChapters(String url);

     /**
      * @title: 获取小说
      * @description: 通过小说url获取小说
      * @author:  Wyndem
      * @date:  2018/8/13  16:41
      **/
    public T getBook(String url);

}
