package com.giannini.jdk8;

/**
 * @author jiangningyu
 * @date 2017/11/30
 */
public class Book {

    private Long id;

    private String name;

    private String publisher;

    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Book() {
    }

    public Book(Long id, String name, String publisher, Double price) {
        this.id = id;
        this.name = name;
        this.publisher = publisher;
        this.price = price;
    }
}
