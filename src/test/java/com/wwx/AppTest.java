package com.wwx;

import com.wwx.spider.model.Book;
import com.wwx.spider.model.Chapter;
import com.wwx.spider.parse.AbstractBookParse;
import com.wwx.spider.parse.BookParse;
import com.wwx.spider.parse.NovelParse;
import com.wwx.spider.parse.ParseFactory;
import com.wwx.spider.parse.biquge.Biquge5200Parse;
import com.wwx.spider.parse.biquge.BiqugeStyleParse;
import com.wwx.spider.search.AbSearch;
import com.wwx.spider.search.SmBookSearch;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue(false );
    }


    @Test
    public void smTest(){
        AbSearch smBookSearch = new SmBookSearch();
        List<Book> list = smBookSearch.getBooks("斗破苍穹");
        for (Book b:list)   {
            System.out.println(b.getName());
        }
//        Book s = smBookSearch.getBook("斗破苍穹");
//        System.out.println(s);

//        DefaultBook defaultBook = new DefaultBook(new SmBookSearch(), "斗罗大陆");
//        System.out.println(defaultBook.getBook());
//        System.out.println(defaultBook.getChapters().size());

    }




    @Test
    public void enTest(){
        BookParse anEnum = BookParse.getEnum("https://www.siluke.tw/ny10487/");
        System.out.println(anEnum);
    }

    @Test
    public  void  DefatTest(){

        AbstractBookParse biqugeStyleParse = ParseFactory.getParse(BookParse.BIQUGE);
        Book book = biqugeStyleParse.getBook("http://www.b5200.net/98_98310/");

        System.out.println(book);
        System.out.println(book.getChapters().size());
        List<Chapter> chapters = biqugeStyleParse.getChapters(book);
        System.out.println(chapters.size());
    }


}
