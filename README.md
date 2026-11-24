
# 📚 Book Recommendation System

A Java-based Book Recommendation System developed using Java, MySQL, JDBC, and Apache Maven.

This project allows users to manage a collection of books, search for books by title, browse books by genre, and discover highly rated books.

## ✨ Features

- **Display Books:** View all available books.
- **Search Books:** Search for books using their titles.
- **Browse by Genre:** Explore books belonging to a particular genre.
- **Add Books:** Add new books to the database.
- **Remove Books:** Remove books using their unique ID.
- **Book Recommendations:** Find up to five highly rated books based on a selected genre.

## 🛠️ Technologies Used

- Java 21
- MySQL
- JDBC (Java Database Connectivity)
- Apache Maven
- MySQL Connector/J 9.5.0
- Apache NetBeans IDE
- Git and GitHub

## 📂 Project Structure

```text
BookRecommendationSystem/
│
├── database/
│   └── books.sql
│
├── src/
│   └── main/
│       └── java/
│           └── com/mycompany/bookrecommendationsystem/
│               ├── Book.java
│               ├── BookDatabase.java
│               ├── BookRecommendationSystem.java
│               ├── DBConnection.java
│               └── RecommendationEngine.java
│
├── pom.xml
├── README.md
├── .gitignore
└── db.properties.example
```

## ⚙️ Prerequisites

Before running this project, make sure you have:

- JDK 21 or later
- MySQL Server
- Apache Maven
- Apache NetBeans IDE (recommended)

## 🗄️ Database Setup

1. Open MySQL Workbench or MySQL Shell.
2. Execute the SQL script available in `database/books.sql`.
3. This will create the `book_recommendation` database and the `books` table.

## 🔐 Database Configuration

Create a `db.properties` file in the project root directory.

Add your own MySQL credentials:

```properties
db.url=jdbc:mysql://localhost:3306/book_recommendation
db.username=root
db.password=YOUR_PASSWORD
```

Replace `YOUR_PASSWORD` with your MySQL password.

**Note:** The actual `db.properties` file is excluded from GitHub to protect database credentials.

## 🚀 How to Run

1. Clone this repository.
2. Open the project in Apache NetBeans as a Maven project.
3. Make sure MySQL Server is running.
4. Configure your `db.properties` file.
5. Allow Maven to download the required dependencies.
6. Run `BookRecommendationSystem.java`.

## 🎯 Learning Outcomes

Through this project, I practised:

- Java programming and object-oriented concepts.
- Connecting Java applications with MySQL using JDBC.
- Performing CRUD operations.
- Writing SQL queries using PreparedStatement.
- Handling database exceptions.
- Managing project dependencies using Maven.
- Using Git and GitHub for version control.

## 🔮 Future Improvements

- Improve the recommendation algorithm.
- Introduce more advanced filtering options.
- Develop a graphical user interface.
- Add user accounts and personalised recommendations.

## 👨‍💻 Author

Developed as a Java mini-project to strengthen practical programming, database management, and software development skills.