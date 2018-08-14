package com.wwx;

import static org.junit.Assert.assertTrue;

import com.wwx.spider.model.Book;
import com.wwx.spider.model.DefaultBook;
import com.wwx.spider.parse.StyleParse;
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
        assertTrue(true );
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
        StyleParse anEnum = StyleParse.getEnum("https://www.siluke.tw/ny10487/");
        System.out.println(anEnum);
    }

    @Test
    public  void  DefatTest(){
        DefaultBook defaultBook = new DefaultBook();
        defaultBook.getBook("http://www.x23su.com/book/49/49648/");
    }


}
