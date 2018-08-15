package com.wwx.spider.parse.context;

import org.apache.commons.collections.map.HashedMap;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Wyndem
 * @Description: 解析上下文
 * @Date: Created in  2018-08-15 14:03
 * @Modified By:
 */
public class ParseContext<T> {

    //爬虫的相关设置
    private Site site;

    //爬取的url
    private String url="";
    //爬虫的线程
    private  int threadNum=1;
    //爬虫的保存结果处理类
    private Pipeline pipeline;
    //返回的Page对象
    private Page page;
    //PageProcessor对象
    private PageProcessor pageProcessor;
    //使用List保存数据
    private List<T> dataList=new ArrayList<T>();
    //使用Map保存数据
    private Map<String,T> dataMap=new HashedMap();
    //保存一个数据
    private T data;
    //重试次数
    private int retryTimes=10;
    //间隔时间:单位毫秒
    private int sleepTimes=300;
    //循环重试次数
    private int cycleRetryTimes=3;
    //超时单位毫秒
    private int timeout=50000;

    public Html getHtml() {
        return getPage().getHtml();
    }


    public int getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
    }

    public int getSleepTimes() {
        return sleepTimes;
    }

    public void setSleepTimes(int sleepTimes) {
        this.sleepTimes = sleepTimes;
    }

    public int getCycleRetryTimes() {
        return cycleRetryTimes;
    }

    public void setCycleRetryTimes(int cycleRetryTimes) {
        this.cycleRetryTimes = cycleRetryTimes;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public PageProcessor getPageProcessor() {
        return pageProcessor;
    }

    public void setPageProcessor(PageProcessor pageProcessor) {
        this.pageProcessor = pageProcessor;
    }

    public Site getSite() {
        if (site==null){
            site=Site.me();
        }
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public Map<String, T> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, T> dataMap) {
        this.dataMap = dataMap;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(int threadNum) {
        this.threadNum = threadNum;
    }

    public Pipeline getPipeline() {
        if (pipeline==null){
            pipeline=new ConsolePipeline();
        }
        return pipeline;
    }

    public void setPipeline(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
