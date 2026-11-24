
package com.mycompany.bookrecommendationsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBConnection {

    public static Connection getConnection() {

        Properties properties = new Properties();

        try (FileInputStream file =
                new FileInputStream("db.properties")) {

            properties.load(file);

            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            Connection connection =
                    DriverManager.getConnection(url, user, password);

            System.out.println("Database connected successfully!");

            return connection;

        } catch (IOException | SQLException e) {

            System.out.println("Database connection failed!");
            e.printStackTrace();

            return null;
        }
    }
}
