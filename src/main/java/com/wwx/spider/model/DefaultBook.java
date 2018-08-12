package com.wwx.spider.model;

import com.wwx.spider.parse.NovelParse;
import com.wwx.spider.parse.ParseFactory;
import com.wwx.spider.parse.StyleParse;
import com.wwx.spider.search.Search;
import com.wwx.spider.utils.BaseUtil;

import java.util.List;

/**
 * @Author: Wyndem
 * @Description: 默认的小说类
 * @Date: Created in  2018-08-12 15:52
 * @Modified By:
 */
public class DefaultBook extends Book implements IBook{

    private Search search;
    private String bookName;
    private List<Chapter> chapters;

    public List<Chapter> getChapters() {
        StyleParse anEnum = StyleParse.getEnum(this.getPutoUrl());
        NovelParse parse = ParseFactory.getParse(anEnum);
        this.chapters=parse.getChapters(this.getPutoUrl());
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public DefaultBook(Search search, String name) {
        this.search=search;
        this.bookName=name;
    }


    @Override
    public DefaultBook getBook() {

        Book book = search.getBook(bookName);

        this.setAuto(book.getAuto());
        this.setSource(book.getSource());
        this.setSentiment(book.getSentiment());
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
    public String toString() {
        return super.toString()+this.getSource();
    }
}
