package com.wwx.spider.search;

import com.wwx.spider.model.Book;
import com.wwx.spider.pipeline.BookPipeline;
import com.wwx.spider.tool.UA;
import org.apache.log4j.BasicConfigurator;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * 搜索引擎的基类
 * @param <T>
 */
public abstract class AbSearch<T extends Book> implements PageProcessor  {

    public Site site = Site.me();
    private BookPipeline pipeline;


    public AbSearch(BookPipeline pipeline) {
        this.pipeline=pipeline;
        site.setRetryTimes(1);
        site.setSleepTime(100);
        site.setCycleRetryTimes(3);
        site.setUserAgent(UA.getComputerUA());
    }

    public abstract String getUrl(String name);

    public Book getBook(String name) {
        //开启login输出
//        BasicConfigurator.configure();
        String url = getUrl(name);
        Spider.create(this).addUrl(url).addPipeline(pipeline).thread(1).run();
        return pipeline.get();
    }

    public List<Book> getBooks(String name){
        getBook(name);
        return pipeline.getBooks();
    }


    @Override
    public Site getSite() {
        return site;
    }


}
