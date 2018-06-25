package com.example;

public class Quote
{
    private Integer id;
    private String quote;
    private String author;

    public Quote(Integer id, String quote, String author) {
        this.id = id;
        this.quote = quote;
        this.author = author;
    }

    public Quote() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
