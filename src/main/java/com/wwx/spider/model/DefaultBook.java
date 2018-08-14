package com.wwx.spider.model;

import com.wwx.spider.parse.NovelParse;
import com.wwx.spider.parse.StyleParse;
import com.wwx.spider.search.AbSearch;

import java.util.List;

/**
 * @Author: Wyndem
 * @Description: 默认的小说类
 * @Date: Created in  2018-08-12 15:52
 * @Modified By:
 */
public class DefaultBook extends Book implements IBook{

    private AbSearch search;
    private String bookName;
    private List<Chapter> chapters;

    public List<Chapter> getChapters() {

        this.chapters=getParse(StyleParse.getEnum(this.getPutoUrl())).getChapters(this.getPutoUrl());
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public DefaultBook() {
        super();
    }

    public DefaultBook(AbSearch search, String name) {
        this.search=search;
        this.bookName=name;
    }


    @Override
    public DefaultBook getBook() {

        Book book = search.getBook(bookName);

        this.setAuto(book.getAuto());
        this.setSource(book.getSource());
        this.setHeat(book.getHeat());
        this.setType(book.getType());
        this.setPutoUrl(book.getPutoUrl());
        this.setCover(book.getCover());
        this.setName(book.getName());
        this.setIntroduce(book.getIntroduce());
        this.setSubmitChapter(book.getSubmitChapter());
        this.setSubmitTime(book.getSubmitTime());

        return this;
    }

    @Override
    public DefaultBook getBook(String url) {
        NovelParse parse = getParse(StyleParse.getEnum(url));
        parse.getBook(url);
        return null;
    }

    @Override
    public String toString() {
        return super.toString()+this.getSource();
    }
}
