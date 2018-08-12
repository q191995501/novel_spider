package com.wwx.spider.parse;

import com.wwx.spider.model.Chapter;
import com.wwx.spider.search.SmBookSearch;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wyndem
 * @Description: 笔趣阁类似的站点
 * @Date: Created in  2018-08-12 16:08
 * @Modified By:
 */
public class BiqugeStyleParse implements NovelParse,PageProcessor {

    private Site site = Site.me();
    private String url="";

    public BiqugeStyleParse() {
        site.setRetryTimes(1);
        site.setSleepTime(100);
        site.setCycleRetryTimes(3);
        site.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36");

    }

    @Override
    public List<Chapter> getChapters(String url) {
        this.url=url;
        Spider.create(this).addUrl(url).addPipeline(chaptepipline).thread(5).run();
        return chaptepipline.getChapters();
    }

    @Override
    public void process(Page page) {

        page.addTargetRequests(page.getHtml().xpath("//dd/a/@href").all());

        Html html = page.getHtml();
        String title = html.xpath("//div[@class='bookname']/h1/text()").get();
        String content = html.xpath("//div[@id='content']/text()").get();
        if (title==null){
            page.setSkip(true);
            return;
        }

        Chapter chapter = new Chapter();
        chapter.setChapterName(title);
        chapter.setContent(content);
        try {
            page.putField(title,chapter);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public Site getSite() {
        return site;
    }
}
