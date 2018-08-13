package com.wwx.spider.model;

import com.wwx.spider.parse.NovelParse;
import com.wwx.spider.parse.ParseFactory;
import com.wwx.spider.parse.StyleParse;

/**
 * @Author: Wyndem
 * @Description: 小说类
 * @Date: Created in  2018-08-12 15:51
 * @Modified By:
 */
public class Book{

    //书名
    private String name;

    //类型
    private String type;

    //热度
    private String heat;

    //来源
    private String source;

    //作者
    private String auto;

    //小说目标也
    private String putoUrl;

    //封面图片地址
    private String cover;

    //简介
    private String introduce;

    //最后一章
    private String submitChapter;

    //最后更新时间
    private String submitTime;


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSubmitChapter() {
        return submitChapter;
    }

    public void setSubmitChapter(String submitChapter) {
        this.submitChapter = submitChapter;
    }

    public String getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(String submitTime) {
        this.submitTime = submitTime;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHeat() {
        return heat;
    }

    public void setHeat(String heat) {
        this.heat = heat;
    }

    public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public String getPutoUrl() {
        return putoUrl;
    }

    public void setPutoUrl(String putoUrl) {
        this.putoUrl = putoUrl;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public NovelParse getParse(StyleParse anEnum) {
        return ParseFactory.getParse(anEnum);
    }


    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", heat='" + heat + '\'' +
                ", source='" + source + '\'' +
                ", auto='" + auto + '\'' +
                ", putoUrl='" + putoUrl + '\'' +
                ", cover='" + cover + '\'' +
                ", introduce='" + introduce + '\'' +
                ", submitChapter='" + submitChapter + '\'' +
                ", submitTime='" + submitTime + '\'' +
                '}';
    }


}
