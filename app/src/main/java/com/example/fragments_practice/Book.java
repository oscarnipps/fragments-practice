package com.example.fragments_practice;

public class Book {

    private String title;
    private String summary;
    private String author;
    private String publishedDate;
    private double rating;
    private boolean isFavourite;

    public Book(String title, String summary, String author, String publishedDate, double rating, boolean isFavourite) {
        this.title = title;
        this.summary = summary;
        this.author = author;
        this.publishedDate = publishedDate;
        this.rating = rating;
        this.isFavourite = isFavourite;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }
}
