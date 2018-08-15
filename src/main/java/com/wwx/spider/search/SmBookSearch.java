package com.wwx.spider.search;

import com.wwx.spider.model.Book;
import com.wwx.spider.parse.BookParse;
import com.wwx.spider.parse.context.ParseContext;
import com.wwx.spider.tool.UA;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Html;

import java.util.List;

/**
 * @Author: Wyndem
 * @Description: 神马搜索引擎
 * @Date: Created in  2018-08-12 15:44
 * @Modified By:
 */
public class SmBookSearch extends AbSearch{



    public SmBookSearch(){
        getSite().setUserAgent(UA.getPhoneUA());
    }



    public void process(ParseContext parseContext){
        Page page = parseContext.getPage();
        Html html = page.getHtml();
        Book veryBook = getVeryBook(html);
        parseContext.setData(veryBook);

        List<Book> dataList = parseContext.getDataList();
        List<String> all = html.xpath("//a[@class='c-header-inner c-flex-1']").links().all();
        Document document = html.getDocument();

        for (String link : all){
            try {
                BookParse.getEnum(link);
                Book book = getBook(document, link);
                dataList.add(book);
            } catch (Exception e) {
            }
        }


    }


    /**
     * 这是一个不是很好支持的小说识别
     * @param doc
     * @param link
     * @return
     */
    public Book getBook(Document doc,String link){
        Book book = new Book();
        System.out.println(link);
        Elements select = doc.select("a[href=" + link + "]");
        String title = select.select("div[data-recotxt].c-header-title").text();

        Html html = Html.create(select.html());
        List<String> info = html.xpath("//span/text()").all();
        book.setAuto(info.get(1));
        book.setSource(BookParse.getEnum(link).toString());
        Html html1 = Html.create(doc.html());
        String submitChapter = html1.xpath("//a[@data-recoorgi="+link+"]/text()").regex("\\W+\\d+\\W+").get();
        switch (info.size()){
            case 7:
                book.setSubmitTime(info.get(3));
                book.setType(info.get(5));
                book.setIntroduce(info.get(6));
                break;
            case 6:
                book.setSubmitTime(info.get(2));
                book.setType(info.get(4));
                book.setIntroduce(info.get(5));
                break;
            case 5:
                book.setSubmitTime(info.get(2));
                book.setType(info.get(3));
                book.setIntroduce(info.get(4));
                break;

        }

        book.setPutoUrl(link);
        book.setName(title);
        book.setSubmitChapter(submitChapter);

        return book;
    }

    /**
     * 这是一个有极好支持的小说
     * @param html
     * @return
     */
    public Book getVeryBook(Html html){
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
        book.setHeat(type.get(2));
        book.setType(type.get(1));
        book.setPutoUrl(url);
        book.setCover(img);
        book.setName(bookname);
        book.setIntroduce(introduce);
        book.setSubmitChapter(submitChapter);
        book.setSubmitTime(submitTime);

        return book;
    }

    @Override
    public String getUrl(String name) {
        return "https://m.sm.cn/s?q="+name;
    }
}