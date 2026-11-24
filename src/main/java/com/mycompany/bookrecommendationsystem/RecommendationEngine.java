
package com.mycompany.bookrecommendationsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecommendationEngine {

    public void recommendBooks(String genre) {

        String query = "SELECT * FROM books WHERE genre LIKE ? "
                     + "ORDER BY rating DESC LIMIT 5";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(query)) {

            statement.setString(1, "%" + genre + "%");

            ResultSet result = statement.executeQuery();

            boolean found = false;

            System.out.println("\n===== BOOK RECOMMENDATIONS =====");

            while (result.next()) {

                found = true;

                System.out.println("\nTitle: " + result.getString("title"));
                System.out.println("Author: " + result.getString("author"));
                System.out.println("Genre: " + result.getString("genre"));
                System.out.println("Rating: " + result.getDouble("rating"));

                System.out.println("-----------------------------");
            }

            if (!found) {
                System.out.println("No recommendations found for this genre.");
            }

        } catch (SQLException e) {

            System.out.println("Error generating recommendations.");
            e.printStackTrace();
        }
    }
}
