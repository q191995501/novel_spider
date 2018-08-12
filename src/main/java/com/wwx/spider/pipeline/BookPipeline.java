package com.wwx.spider.pipeline;

import com.wwx.spider.model.Book;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Wyndem
 * @Description: 小说处理
 * @Date: Created in  2018-08-12 14:56
 * @Modified By:
 */
public class BookPipeline implements Pipeline {
    private List<Book> books;

    public Book get() {
        return books.get(0);
    }

    public List<Book> getBooks() {
        return books;
    }

    public BookPipeline() {
        this.books=new ArrayList<>(5);
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        Map<String, Object> all = resultItems.getAll();
        for (Map.Entry<String, Object> entry : all.entrySet()) {
            if (entry.getValue() instanceof Book){
                books.add((Book) entry.getValue());
            }
        }

    }
}
