package com.wwx.spider.search;


import com.wwx.spider.model.Book;

public interface Search<T extends Book>  {

    public T getBook(String name);



}
