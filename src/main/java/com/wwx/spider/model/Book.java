package com.wwx.spider.model;

/**
 * @Author: Wyndem
 * @Description: 小说类
 * @Date: Created in  2018-08-12 15:51
 * @Modified By:
 */
public class Book{


    private String name;

    private String type;

    private String sentiment;

    private String source;

    private String auto;

    private String putoUrl;

    private String cover;

    private String introduce;

    private String submitChapter;

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

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
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

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", sentiment='" + sentiment + '\'' +
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
