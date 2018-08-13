package com.wwx.spider.parse;

import com.wwx.spider.model.Book;
import com.wwx.spider.model.Chapter;
import com.wwx.spider.pipeline.ChaptePipeline;
import com.wwx.spider.pipeline.sm.SmChaptePipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

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
    private ChaptePipeline biqugePipeline;



    public BiqugeStyleParse() {
        this.setBiqugePipeline(new SmChaptePipeline());
        site.setRetryTimes(1);
        site.setSleepTime(100);
        site.setCycleRetryTimes(3);
        site.setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.181 Safari/537.36");

    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Pipeline getBiqugePipeline() {
        return biqugePipeline;
    }

    public void setBiqugePipeline(ChaptePipeline biqugePipeline) {
        this.biqugePipeline = biqugePipeline;
    }

    @Override
    public List<Chapter> getChapters(String url) {
        this.url=url;
        Spider.create(this).addUrl(url).addPipeline(this.getBiqugePipeline()).thread(5).run();
        return biqugePipeline.getChapters();
    }

    @Override
    public Book getBook(String url) {

        Spider.create(new PageProcessor() {

            @Override
            public void process(Page page) {
                Html html = page.getHtml();

                String title = html.xpath("//div[@id='info']/h1/text()").get();
                List<String> info = html.xpath("//div[@id='info']/p/text()").all();
                String author=info.get(0).split("：")[1].trim();
                String submitTime="未知";
                try {
                    submitTime=info.get(2).split("：")[1].trim();
                } catch (Exception e) {

                }
                String submitChapter = html.xpath("//div[@id='info']/p/a/text()").all().get(3);
                String source=StyleParse.BIQUGE.toString();
                String type = html.xpath("//div[@class='con_top'])").get().split(" > ")[1];
                String img = html.xpath("//div[@id='fmimg']/img/@src").get();
                String introduce = html.xpath("//div[@id='intro']/p/text()").get();


                System.out.println(title);
//                book.setAuto(author);
//                book.setSource(sourcs);
//                book.setHeat(type.get(2));
//                book.setType(type.get(1));
//                book.setPutoUrl(url);
//                book.setCover(img);
//                book.setName(bookname);
//                book.setIntroduce(introduce);
//                book.setSubmitChapter(submitChapter);
//                book.setSubmitTime(submitTime);



            }

            @Override
            public Site getSite() {
                return site;
            }
        }).addUrl(url).thread(5).run();

        return null;
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
