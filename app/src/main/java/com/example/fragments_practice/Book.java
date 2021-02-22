package com.example.fragments_practice;

public class Book {

    private String title;
    private String summary;
    private String publishedDate;
    private boolean isFavourite;

    public Book(String title, String summary, String publishedDate, boolean isFavourite) {
        this.title = title;
        this.summary = summary;
        this.publishedDate = publishedDate;
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

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }
}
