

-- Book Recommendation System
-- Database setup script

CREATE DATABASE IF NOT EXISTS book_recommendation;

USE book_recommendation;

-- Create books table

CREATE TABLE IF NOT EXISTS books (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    rating DECIMAL(3,2) NOT NULL
);
