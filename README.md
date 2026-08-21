# 🎓 Student Management System

A console-based **Student Management System** developed using **Java** and Object-Oriented Programming principles.

The application allows users to manage student records efficiently through a menu-driven console interface. It supports CRUD operations, validation, exception handling, sorting, filtering, report generation, and persistent storage using Java serialization.

---

## 📌 Project Overview

The Student Management System is designed to simplify the management of student information.

The application allows users to:

- Add new students
- View all students
- Search for students
- Update student details
- Delete students
- Validate student information
- Prevent duplicate student records
- Sort students based on CGPA
- Filter students by department
- Generate student reports
- Count total students
- Save student data to a file
- Load previously saved student data

This project was developed as part of my **Java placement preparation journey** to strengthen my understanding of Java, OOP, collections, exception handling, file handling, and project structure.

---

## 🚀 Features

### 1. Add Student

Users can add a new student by entering:

- Student ID
- Student name
- Age
- Gender
- Department
- Year
- CGPA

The system validates the entered information before adding the student.

---

### 2. View All Students

Displays all registered students in the system.

The information includes:

- Student ID
- Name
- Age
- Gender
- Department
- Year
- CGPA

---

### 3. Search Student

Students can be searched using their unique Student ID.

---

### 4. Update Student

Existing student information can be updated using the Student ID.

---

### 5. Delete Student

A student record can be removed using the Student ID.

---

### 6. Duplicate Student ID Validation

The system does not allow two students to have the same Student ID.

Example:

```text
Student ID already exists!
## 🔮 Next Phase — Version 2

The Core Java version of the Student Management System is complete.

The next phase will upgrade the application from file-based storage to a database-driven architecture.

### 🗄️ MySQL + JDBC

Planned tasks:

- [ ] Set up MySQL
- [ ] Create `student_management` database
- [ ] Design `students` table
- [ ] Configure JDBC
- [ ] Create database connection utility
- [ ] Create DAO layer
- [ ] Implement database-based CRUD operations
- [ ] Test MySQL integration
- [ ] Update project architecture

### 🎯 Goal

Move from:

```text
Java Application
       ↓
ArrayList
       ↓
students.dat