package com.wwx.spider.parse;

import com.wwx.spider.model.Book;
import com.wwx.spider.model.Chapter;
import com.wwx.spider.parse.context.ParseContext;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Html;

import java.util.List;

/**
 * @Author: Wyndem
 * @Description: 抽象的解析类
 * @Date: Created in  2018-08-15 13:46
 * @Modified By:
 */
public abstract class AbstractBookParse extends Crawl implements NovelParse {

    public Boolean isLoddingChapters=false;

    protected Html html;

    public abstract void getChapters(Page page);
    public  List<Chapter> getChapters(Book book){
        return getChapters(book.getPutoUrl());
    }


    @Override
    public void process(ParseContext parseContext) {
        html=parseContext.getHtml();
        if (parseContext.getData()==null){
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
        }

        if (isLoddingChapters){
            getChapters(parseContext.getPage());

        }


    }

    @Override
    public List<Chapter> getChapters(String url) {
        parseContext.setThreadNum(1);
        isLoddingChapters=true;
        Book book = getBook(url);
        isLoddingChapters=false;
        return book.getChapters();
    }

    @Override
    public Book getBook(String url) {
        parseContext.setUrl(url);
        start();
        Book data =(Book)parseContext.getData();
        data.setChapters(parseContext.getDataList());
        return data;
    }
}