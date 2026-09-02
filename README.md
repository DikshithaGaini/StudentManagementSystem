# 🎓 Student Management System

A Java-based Student Management System designed to manage student records efficiently using **Java, JDBC, and MySQL**.

The project started with file-based storage and was later migrated to a **MySQL database using the DAO architecture**.

---

## 🚀 Features

- ➕ Add Student
- 📋 Display All Students
- 🔍 Search Student
- ✏️ Update Student
- 🗑️ Delete Student
- 🔢 Count Total Students
- 📊 Sort Students by CGPA
- 🏢 Filter Students by Department
- 📑 Generate Student Report
- ✅ Input Validation
- 🗄️ MySQL Database Integration
- 🔐 Secure Database Credentials using Environment Variables

---

## 🛠️ Tech Stack

- **Programming Language:** Java
- **Database:** MySQL
- **Database Connectivity:** JDBC
- **Architecture:** DAO + Service Layer
- **IDE:** Visual Studio Code
- **Version Control:** Git & GitHub
- **Database Driver:** MySQL Connector/J

---

## 🏗️ Project Architecture

```text
StudentManagementSystem
│
├── src
│   │
│   ├── app
│   │   └── Main.java
│   │
│   ├── dao
│   │   └── StudentDAO.java
│   │
│   ├── model
│   │   └── Student.java
│   │
│   ├── service
│   │   └── StudentService.java
│   │
│   └── util
│       └── DatabaseUtil.java
│
├── lib
│   └── MySQL Connector/J
│
├── .gitignore
└── README.md
```

### Architecture Flow

```text
User
  ↓
Main.java
  ↓
StudentService
  ↓
StudentDAO
  ↓
DatabaseUtil
  ↓
MySQL Database
```

---

## 🗄️ Database

### Database Name

```text
student_management
```

### Table Name

```text
students
```

### Student Table

| Column | Type | Description |
|---|---|---|
| student_id | INT | Unique Student ID |
| student_name | VARCHAR | Student Name |
| department | VARCHAR | Department |
| year | INT | Academic Year |
| cgpa | DOUBLE | Student CGPA |

---

## 🔐 Database Configuration

The MySQL password is **not stored inside the Java source code**.

The application reads the database password using the environment variable:

```text
DB_PASSWORD
```

### Set Environment Variable in PowerShell

```powershell
$env:DB_PASSWORD="YOUR_MYSQL_PASSWORD"
```

After setting the environment variable, run the application from VS Code.

> **Note:** Replace `YOUR_MYSQL_PASSWORD` with your own MySQL password. Never commit your actual password to GitHub.

---

## ▶️ How to Run

### 1. Install Java

Install the Java JDK and verify:

```powershell
java -version
```

### 2. Install MySQL

Make sure MySQL Server is installed and running.

### 3. Create the Database

```sql
CREATE DATABASE student_management;
```

### 4. Select the Database

```sql
USE student_management;
```

### 5. Create the Students Table

```sql
CREATE TABLE students (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(100) NOT NULL,
    department VARCHAR(100) NOT NULL,
    year INT NOT NULL,
    cgpa DOUBLE NOT NULL
);
```

### 6. Configure Database Password

Set the environment variable:

```powershell
$env:DB_PASSWORD="YOUR_MYSQL_PASSWORD"
```

### 7. Run the Application

Open the project in VS Code and run:

```text
src/app/Main.java
```

---

## 📌 Current Status

The project currently supports complete **CRUD operations with MySQL**.

### ✅ Completed

- [x] Student Model
- [x] Student Service
- [x] MySQL Database
- [x] JDBC Connection
- [x] DAO Implementation
- [x] Add Student
- [x] Display Students
- [x] Search Student
- [x] Update Student
- [x] Delete Student
- [x] Student Count
- [x] Sort Students by CGPA
- [x] Filter Students by Department
- [x] Generate Student Report
- [x] Input Validation
- [x] Secure Database Credentials
- [x] GitHub Repository
- [x] Removed File-Based Storage

---

## 📅 Daily Progress

### Day 1 — Project Setup

- Created Student Management System
- Created Student model
- Implemented basic student operations
- Added menu-driven console application

### Day 2 — Database Migration

- Migrated student storage from file to MySQL
- Implemented JDBC connection
- Created `StudentDAO`
- Implemented database CRUD operations

### Day 3 — Additional Features

- Added sorting students by CGPA
- Added department filtering
- Added student report generation
- Added input validation

### Day 4 — Security & Cleanup

- Secured database credentials using environment variables
- Removed unused file-based storage
- Removed temporary DAO testing files
- Tested complete application
- Pushed project to GitHub

---

## 🔮 Future Improvements

- [ ] GUI using Java Swing or JavaFX
- [ ] Login Authentication
- [ ] Role-based access
- [ ] Better exception handling
- [ ] Unit Testing
- [ ] Maven integration
- [ ] Search by name or department
- [ ] Pagination for large datasets
- [ ] Export reports to PDF/CSV
- [ ] Deploy application and database

---

## 🎯 Learning Outcomes

Through this project, I practiced:

- Core Java
- Object-Oriented Programming
- Collections
- Exception Handling
- JDBC
- SQL and MySQL
- DAO Design Pattern
- Service Layer Architecture
- Input Validation
- Environment Variables
- Git and GitHub
- Project Structure and Code Organization

---

## 👩‍💻 Author

**Dikshitha Gaini**

Java | MySQL | JDBC | Git & GitHub

---

⭐ **This project is part of my Java Placement Journey.**