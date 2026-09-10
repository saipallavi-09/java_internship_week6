# Student Management System

## Project Description

Student Management System is a console-based Java application used to manage student records.

The application allows the user to add, view, search, update and delete student records. Student information is also stored in a text file so that the records can be used again when the application is started.

The project was developed as the final project for the 6 Week Java Development Internship.

## Features

The application provides the following features:

- Add Student
- View All Students
- Search Student by ID
- Update Student Details
- Delete Student
- Save Student Records
- Load Student Records from File
- Backup Student Records
- Input Validation
- Exception Handling
- Menu-driven interface

## Student Information

The application stores:

- Student ID
- Student Name
- Course
- Age
- Marks

## Technologies Used

- Java
- Java Collections Framework
- File Handling
- Exception Handling
- Multithreading
- Git
- GitHub
- Visual Studio Code

## Java Concepts Used

This project demonstrates the following Java concepts:

### OOP Concepts

- Classes and Objects
- Constructors
- `this` keyword
- `static` keyword
- Inheritance
- Polymorphism
- Encapsulation
- Abstraction

### Interface

The `Manageable` interface is used to define the main student management operations.

### Collections

The project uses:

- `ArrayList` for storing student records
- `HashMap` for searching students using Student ID
- `HashSet` for storing unique courses

### Exception Handling

The application uses `try-catch` blocks to handle invalid input and file-related errors.

### File Handling

Student records are stored in `students.txt`.

The application can:

- Write student information to the file
- Read student information from the file
- Load records when the application starts

### Multithreading

A separate `BackupThread` is used to create a backup of the student records while the application is running.

## Project Structure

```text
Java_Week6_Final_Project
│
├── Main.java
├── Student.java
├── Person.java
├── Manageable.java
├── StudentManager.java
├── BackupThread.java
├── students.txt
├── students_backup.txt
├── README.md
└── screenshots
