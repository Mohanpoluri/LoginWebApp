# LoginWebApp

A simple Java web application using **Servlets**, **JDBC**, and **MySQL** for user login and registration functionality.

## 🚀 Features

- User Login using Servlet + JDBC
- User Registration (inserts into MySQL DB)
- Frontend with HTML & CSS
- Image and resource loading
- MySQL database connection
- Deployed on Apache Tomcat (v9+)

## 🛠️ Technologies Used

- Java (Servlets)
- HTML / CSS
- JDBC (MySQL)
- MySQL 8.x
- Apache Tomcat 9.x
- Eclipse IDE

## 📁 Project Structure

LoginWebApp/
├── src/
│ └── main/
│ ├── java/
│ │ └── LoginServlet.java
│ └── webapp/
│ ├── index.html
│ ├── login.html
│ ├── images/
│ │ └── your-image.jpg
│ └── styles.css
├── .gitignore
├── pom.xml (if Maven project)
└── README.md



## 🖥️ Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/Mohanpoluri/LoginWebApp.git
Open in Eclipse (as a Dynamic Web Project)

Place the MySQL Connector JAR in lib/ or add via pom.xml

Create MySQL DB:
CREATE DATABASE mydb;
USE mydb;
CREATE TABLE user (
  userId VARCHAR(50),
  password VARCHAR(50)
);
Run on Tomcat Server

Open browser:http://localhost:8086/LoginWebApp/index.html
🔒 Security Note
This project uses simple SQL string concatenation — in real-world apps, use PreparedStatements to avoid SQL Injection.
## 📸 Screenshots

### 🔐 Login Page

![Login Page](screenshots/login.png)

### 📝 Register Page

![Register Page](screenshots/rigister.png)


