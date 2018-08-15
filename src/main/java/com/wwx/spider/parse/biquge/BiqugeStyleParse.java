package com.wwx.spider.parse.biquge;

import com.wwx.spider.model.Book;
import com.wwx.spider.model.Chapter;
import com.wwx.spider.parse.AbstractBookParse;
import com.wwx.spider.parse.BookParse;
import com.wwx.spider.parse.context.ParseContext;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Html;

import java.util.List;

/**
 * @Author: Wyndem
 * @Description: 笔趣阁类似的站点
 * @Date: Created in  2018-08-12 16:08
 * @Modified By:
 */
public  abstract class  BiqugeStyleParse extends AbstractBookParse {


    private Html html;


    @Override
    public String getUrl() {
        return parseContext.getUrl();
    }



    public void getChapters(Page page) {
        System.out.println(page.getUrl());
        List<String> all = page.getHtml().xpath("//dd/a/@href").all();
        page.addTargetRequests(all);

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
        parseContext.getDataList().add(chapter);
    }

    @Override
    public Book parse(ParseContext parseContext) {
        html=parseContext.getPage().getHtml();

        String author = getAuto();
        String sourcs = getSource();
        String heat = getHeat();
        String type = getType();
        String putoUrl = getPutoUrl();
        String img = getCover();
        String bookname = getName();
        String introduce = getIntroduce();
        String submitChapter = getSubmitChapter();
        String submitTime = getSubmitTime();

        Book book = new Book();
        book.setAuto(author);
        book.setSource(sourcs);
        book.setHeat(heat);
        book.setType(type);
        book.setPutoUrl(putoUrl);
        book.setCover(img);
        book.setName(bookname);
        book.setIntroduce(introduce);
        book.setSubmitChapter(submitChapter);
        book.setSubmitTime(submitTime);

        parseContext.setData(book);
        return book;
    }

    @Override
    public String getSource() {
        return BookParse.BIQUGE.toString();
    }

    @Override
    public String getSubmitChapter() {
        return  html.xpath("//div[@id='list']/dl/dd/a/text()").get();
    }

    @Override
    public String getSubmitTime() {
        List<String> info = html.xpath("//div[@id='info']/p/text()").all();
        String submitTime=info.get(2).split("：")[1].trim();
        return submitTime;
    }

    @Override
    public String getIntroduce() {
        return html.xpath("//div[@id='intro']/p/text()").get();
    }

    @Override
    public String getName() {
        return html.xpath("//div[@id='info']/h1/text()").get();
    }

    @Override
    public String getType() {
        return html.xpath("//div[@class='con_top']/a/text()").all().get(1);
    }

    @Override
    public String getHeat() {
        return "";
    }

    @Override
    public String getAuto() {
        List<String> info = html.xpath("//div[@id='info']/p/text()").all();
        String author=info.get(0).split("：")[1].trim();
        return author;
    }

    @Override
    public String getPutoUrl() {
        return getUrl();
    }

    @Override
    public String getCover() {
        return html.xpath("//div[@id='fmimg']/img/@src").get();
    }


}
