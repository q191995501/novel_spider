package com.wwx.spider.parse;

import com.wwx.spider.parse.context.ParseContext;
import com.wwx.spider.tool.UA;
import us.codecraft.webmagic.*;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.scheduler.BloomFilterDuplicateRemover;
import us.codecraft.webmagic.scheduler.QueueScheduler;

/**
 * @Author: Wyndem
 * @Description: 爬取抽象类
 * @Date: Created in  2018-08-15 13:59
 * @Modified By:
 */
public  abstract class Crawl<T> implements PageProcessor,Pipeline {

    protected ParseContext<T> parseContext;
    private Site site ;

    public Crawl() {
        parseContext=new ParseContext<T>();
        site=parseContext.getSite();
        parseContext.setPageProcessor(this);
        parseContext.setPipeline(this);
        site.setRetryTimes(parseContext.getRetryTimes());
        site.setSleepTime(parseContext.getSleepTimes());
        site.setCycleRetryTimes(parseContext.getCycleRetryTimes());
        site.setTimeOut(parseContext.getTimeout());
        site.setUserAgent(UA.getComputerUA());
    }


    public abstract String getUrl();

     /**
      * @title: 启动爬虫
      * @description: 启动爬虫
      * @author:  Wyndem
      * @date:  2018/8/15  14:32
      **/
    public void start(ParseContext parseContext){
//        BasicConfigurator.configure();
        parseContext.setUrl(getUrl());
        Spider.create(parseContext.getPageProcessor())
                .setScheduler(new QueueScheduler()
                .setDuplicateRemover(new BloomFilterDuplicateRemover(9000)))
                .addUrl(parseContext.getUrl())
                .addPipeline(parseContext.getPipeline())
                .thread(parseContext.getThreadNum()).run();
    }


    public void start(){
        start(parseContext);
    }


    public abstract void process(ParseContext parseContext);


    public void process(Page page){
        parseContext.setPage(page);
        process(getParseContext());
    };

    public void process(ResultItems resultItems, Task task){}

    public ParseContext getParseContext() {
        return parseContext;
    }

    @Override
    public Site getSite() {

        return site;
    }


}
