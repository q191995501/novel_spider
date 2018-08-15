package com.wwx;

import static org.junit.Assert.assertTrue;

import com.wwx.spider.model.Book;
import com.wwx.spider.parse.BookParse;
import com.wwx.spider.parse.biquge.BiqugeStyleParse;
import com.wwx.spider.search.SmBookSearch;
import org.junit.Test;

import java.util.List;

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
        SmBookSearch smBookSearch = new SmBookSearch();
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
//        DefaultBook defaultBook = new DefaultBook();
//        Book book = defaultBook.getBook("https://www.biquge5200.cc/98_98316/");
        BiqugeStyleParse biqugeStyleParse = new BiqugeStyleParse();
        biqugeStyleParse.isLoddingChapters=true;
        Book book = biqugeStyleParse.getBook("http://www.b5200.net/98_98310/");

        System.out.println(book);
        //2258
        System.out.println(book.getChapters().size());
    }


}
