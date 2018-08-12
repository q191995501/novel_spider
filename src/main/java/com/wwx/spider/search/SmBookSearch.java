package com.wwx.spider.search;

import com.wwx.spider.model.Book;
import com.wwx.spider.pipeline.BookPipeline;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.List;

/**
 * @Author: Wyndem
 * @Description: 神马搜索引擎
 * @Date: Created in  2018-08-12 15:44
 * @Modified By:
 */
public class SmBookSearch implements Search,PageProcessor {


    private Site site = Site.me();

    public SmBookSearch(){
        site.setRetryTimes(1);
        site.setSleepTime(100);
        site.setCycleRetryTimes(3);
        site.setUserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 10_3 like Mac OS X) AppleWebKit/602.1.50 (KHTML, like Gecko) CriOS/56.0.2924.75 Mobile/14E5239e Safari/602.1");

    }

    @Override
    public Book getBook(String name) {
        BookPipeline bookPipeline = new BookPipeline();
//        BasicConfigurator.configure();
        Spider.create(this).addUrl("https://m.sm.cn/s?q="+name).addPipeline(bookPipeline).thread(1).run();
        return bookPipeline.get();
    }


    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        String xpath="//span[@class='js-c-property-text']";

        String introduce=html.xpath("//span[@class='js-c-paragraph-text']/text()").get();
        List<String> types = html.xpath(xpath + "/a/text()").all();
        String author = types.get(0);
        String sourcs=types.get(1);
        String url = html.xpath(xpath + "/a/@href").all().get(1);
        List<String> type =html.xpath(xpath+"/text()").all();
        String img = html.xpath("//div[@class='c-pic-wrapper']/@data-image").get();
        String bookname = html.xpath("//div[@class='c-header-title c-line-clamp-1 icon-right c-margin-right-l']/span/em/text()").get();
        String submitChapter = html.xpath("//a[@class='c-line-clamp-1 c-margin-bottom-m']/text()").get();
        String submitTime = html.xpath("//div[@class='c-chapter-extra c-text-s c-margin-left-l']/text()").get();



        Book book = new Book();
        book.setAuto(author);
        book.setSource(sourcs);
        book.setSentiment(type.get(2));
        book.setType(type.get(1));
        book.setPutoUrl(url);
        book.setCover(img);
        book.setName(bookname);
        book.setIntroduce(introduce);
        book.setSubmitChapter(submitChapter);
        book.setSubmitTime(submitTime);

        page.putField("book",book);
    }

    @Override
    public Site getSite() {
        return site;
    }
}