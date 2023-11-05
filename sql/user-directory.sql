-- Create the User Tracker database
CREATE DATABASE IF NOT EXISTS user_tracker;

-- Use the User Tracker database
USE user_tracker;

-- Create the User table
CREATE TABLE IF NOT EXISTS user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    age INT,
    job VARCHAR(255)
);

-- Insert an example record
INSERT INTO user (first_name, last_name, age, job)
VALUES ('John', 'Doe', 30, 'Software Developer');
