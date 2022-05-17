package com.database;

public class ReviewModal {

    private  String name;
    private String title;
    private String comment;
    private int id;

    // Creating getter and setter method

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //constructor
    public  ReviewModal(String name, String title, String comment) {
        this.name = name;
        this.title = title;
        this.comment = comment;
    }
}
