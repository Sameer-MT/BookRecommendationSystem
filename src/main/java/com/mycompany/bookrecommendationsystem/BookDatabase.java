
package com.mycompany.bookrecommendationsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDatabase {

    public void displayAllBooks() {

        String query = "SELECT * FROM books";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(query);
             ResultSet result = statement.executeQuery()) {

            System.out.println("\n===== AVAILABLE BOOKS =====");

            while (result.next()) {

                int id = result.getInt("book_id");
                String title = result.getString("title");
                String author = result.getString("author");
                String genre = result.getString("genre");
                double rating = result.getDouble("rating");

                Book book = new Book(id, title, author, genre, rating);

                book.displayBook();

                System.out.println("--------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Unable to retrieve books.");
            e.printStackTrace();
        }
    }
    
    
public void searchBookByTitle(String searchTitle) {

    String query = "SELECT * FROM books WHERE title LIKE ?";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement statement =
                 connection.prepareStatement(query)) {

        statement.setString(1, "%" + searchTitle + "%");

        ResultSet result = statement.executeQuery();

        boolean found = false;

        while (result.next()) {

            found = true;

            System.out.println("\nBook Found!");
            System.out.println("ID: " + result.getInt("book_id"));
            System.out.println("Title: " + result.getString("title"));
            System.out.println("Author: " + result.getString("author"));
            System.out.println("Genre: " + result.getString("genre"));
            System.out.println("Rating: " + result.getDouble("rating"));

        }

        if (!found) {
            System.out.println("Sorry! No matching book found.");
        }

    } catch (SQLException e) {
        System.out.println("Error while searching for books.");
        e.printStackTrace();
    }
}



public void browseBooksByGenre(String genre) {

    String query = "SELECT * FROM books WHERE genre LIKE ?";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement statement =
                 connection.prepareStatement(query)) {

        statement.setString(1, "%" + genre + "%");

        ResultSet result = statement.executeQuery();

        boolean found = false;

        System.out.println("\n===== BOOKS IN " + genre.toUpperCase() + " =====");

        while (result.next()) {

            found = true;

            System.out.println("\nBook ID: " + result.getInt("book_id"));
            System.out.println("Title: " + result.getString("title"));
            System.out.println("Author: " + result.getString("author"));
            System.out.println("Genre: " + result.getString("genre"));
            System.out.println("Rating: " + result.getDouble("rating"));

        }

        if (!found) {
            System.out.println("No books found in this genre.");
        }

    } catch (SQLException e) {
        System.out.println("Error while browsing genres.");
        e.printStackTrace();
    }
}



public void addBook(String title, String author, String genre, double rating) {

    String query = "INSERT INTO books (title, author, genre, rating) VALUES (?, ?, ?, ?)";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {

        statement.setString(1, title);
        statement.setString(2, author);
        statement.setString(3, genre);
        statement.setDouble(4, rating);

        int rowsInserted = statement.executeUpdate();

        if (rowsInserted > 0) {
            System.out.println("Book added successfully!");
        }

    } catch (SQLException e) {
        System.out.println("Error adding book.");
        e.printStackTrace();
    }
}



public void removeBook(int bookId) {

    String query = "DELETE FROM books WHERE book_id = ?";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {

        statement.setInt(1, bookId);

        int rowsDeleted = statement.executeUpdate();

        if (rowsDeleted > 0) {
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("No book found with that ID.");
        }

    } catch (SQLException e) {
        System.out.println("Error removing book.");
        e.printStackTrace();
    }
}


}
