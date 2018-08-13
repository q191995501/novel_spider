package com.wwx.spider.model;

public interface IBook<T extends Book> {

    public T getBook();

    public T getBook(String url);
}
