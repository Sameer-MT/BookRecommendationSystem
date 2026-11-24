
package com.mycompany.bookrecommendationsystem;

import java.util.Scanner;

public class BookRecommendationSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BookDatabase database = new BookDatabase();

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("     BOOK RECOMMENDATION SYSTEM");
            System.out.println("=================================");

            System.out.println("1. View All Books");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Browse Books by Genre");
            System.out.println("4. Get Book Recommendations");
            System.out.println("5. Add a New Book");
            System.out.println("6. Remove a Book");
            System.out.println("7. Exit");

            System.out.print("\nEnter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    database.displayAllBooks();
                    break;

                case 2:
                    scanner.nextLine();

                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();

                    database.searchBookByTitle(title);
                    break;

                case 3:
                    scanner.nextLine();

                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();

                    database.browseBooksByGenre(genre);
                    break;

                case 4:
                    scanner.nextLine();

                    System.out.print("Enter your favourite genre: ");
                    String preferredGenre = scanner.nextLine();

                    RecommendationEngine engine = new RecommendationEngine();

                    engine.recommendBooks(preferredGenre);
                    break;

                case 5:
                    scanner.nextLine();

                    System.out.print("Enter book title: ");
                    String newTitle = scanner.nextLine();

                    System.out.print("Enter author: ");
                    String newAuthor = scanner.nextLine();

                    System.out.print("Enter genre: ");
                    String newGenre = scanner.nextLine();

                    System.out.print("Enter rating: ");
                    double newRating = scanner.nextDouble();

                    database.addBook(newTitle, newAuthor, newGenre, newRating);
                    break;

                case 6:
                    System.out.print("Enter the Book ID to remove: ");
                    int bookId = scanner.nextInt();

                    database.removeBook(bookId);
                    break;

                case 7:
                    System.out.println("Thank you for using our system!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again!");
            }

        } while (choice != 7);

        scanner.close();
    }
}
