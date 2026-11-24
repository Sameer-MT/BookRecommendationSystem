
package com.mycompany.bookrecommendationsystem;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private String genre;
    private double rating;

    public Book(int bookId, String title, String author,
                String genre, double rating) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public void displayBook() {
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Genre: " + genre);
        System.out.println("Rating: " + rating);
    }
}
