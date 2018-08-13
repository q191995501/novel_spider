package com.wwx.spider.pipeline;

import com.wwx.spider.model.Book;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wyndem
 * @Description: 小说处理的抽象类
 * @Date: Created in  2018-08-13 16:06
 * @Modified By:
 */
public abstract class BookPipeline implements Pipeline {
    private List<Book> books;

    public BookPipeline() {
        this.books = new ArrayList<>(5);;
    }

    public Book get() {
        return books.get(0);
    }

    public List<Book> getBooks() {
        return books;
    }




}
