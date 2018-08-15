package com.wwx.spider.parse;

import com.wwx.spider.model.Book;
import com.wwx.spider.model.Chapter;
import com.wwx.spider.parse.context.ParseContext;
import us.codecraft.webmagic.Page;

import java.util.List;

/**
 * @Author: Wyndem
 * @Description: 抽象的解析类
 * @Date: Created in  2018-08-15 13:46
 * @Modified By:
 */
public abstract class AbstractBookParse extends Crawl implements NovelParse {

    public Boolean isLoddingChapters=false;


    public abstract void getChapters(Page page);
    public  List<Chapter> getChapters(Book book){
        return getChapters(book.getPutoUrl());
    }

    public  abstract Book parse(ParseContext parseContext);

    @Override
    public void process(ParseContext parseContext) {

        if (parseContext.getData()==null){
            parse(parseContext);
        }

        if (isLoddingChapters){
            getChapters(parseContext.getPage());

        }


    }

    @Override
    public List<Chapter> getChapters(String url) {
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