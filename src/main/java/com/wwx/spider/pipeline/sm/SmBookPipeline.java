package com.wwx.spider.pipeline.sm;

import com.wwx.spider.model.Book;
import com.wwx.spider.pipeline.BookPipeline;
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
public class SmBookPipeline extends BookPipeline {

    private List<Book> books;

    public SmBookPipeline() {
        this.books = super.getBooks();
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
