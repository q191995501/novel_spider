package com.wwx.spider.search;

import com.wwx.spider.model.Book;
import com.wwx.spider.parse.Crawl;

import java.util.List;

/**
 * 搜索引擎的基类
 *
 */
public abstract class AbSearch extends Crawl<Book> {



    public abstract String getUrl(String name);

    public  String getUrl(){

        return parseContext.getUrl();
    }

    public Book getBook(String name) {
        String url = getUrl(name);
        parseContext.setUrl(url);
        start();
        return parseContext.getData();
    }

    public List<Book> getBooks(String name){
        List<Book> dataList = parseContext.getDataList();
        dataList.add(0,getBook(name));
        return dataList;
    }




}
