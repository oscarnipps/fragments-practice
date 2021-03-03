package com.example.fragments_practice;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    private String title;
    private String summary;
    private String author;
    private String publishedDate;
    private float rating;
    private boolean isFavourite;

    public Book(String title, String summary, String author, String publishedDate, float rating, boolean isFavourite) {
        this.title = title;
        this.summary = summary;
        this.author = author;
        this.publishedDate = publishedDate;
        this.rating = rating;
        this.isFavourite = isFavourite;
    }

    protected Book(Parcel in) {
        title = in.readString();
        summary = in.readString();
        author = in.readString();
        publishedDate = in.readString();
        rating = in.readFloat();
        isFavourite = in.readByte() != 0;
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

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

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(summary);
        parcel.writeString(author);
        parcel.writeString(publishedDate);
        parcel.writeFloat(rating);
        parcel.writeByte((byte) (isFavourite ? 1 : 0));
    }
}
