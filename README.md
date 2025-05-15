# 🏦 Banking Management System using Java, JDBC, and Oracle

This mini-project is a **Banking Management System** developed using **Java**, **Oracle Database**, and **JDBC (Java Database Connectivity)**. It allows basic banking operations through a menu-driven console application.

## 🚀 Project Overview

This is a console-based application that connects Java to an Oracle database to manage customer, account, and loan information for a fictional bank. The user interacts with a menu system to perform operations like:

- Creating and managing customers
- Viewing account and loan details
- Depositing and withdrawing money

---

## 📌 Features

1. **Show Customer Records**
2. **Add Customer with Account and Optional Loan**
3. **Delete Customer (Cascade: Account + Loan also deleted)**
4. **Update Customer Information**
5. **View Account Details of a Customer**
6. **View Loan Details of a Customer**
7. **Deposit Money into an Account**
8. **Withdraw Money from an Account**
9. **Exit Application**

---

## 🧰 Technologies Used

| Tech        | Description                       |
|-------------|-----------------------------------|
| Java        | Console-based application         |
| JDBC        | Connects Java to Oracle Database  |
| Oracle SQL  | For table creation and data ops   |
| Eclipse     | Java IDE used for development     |
| SQL*Plus    | Oracle command-line tool for DB   |

---

## 🗃️ Database Schema

### 🧑 Customer Table

| Column   | Type        |
|----------|-------------|
| cust_no  | VARCHAR2(10), PRIMARY KEY |
| name     | VARCHAR2(100) |
| phoneno  | VARCHAR2(15)  |
| city     | VARCHAR2(50)  |

### 🏦 Account Table

| Column       | Type          |
|--------------|---------------|
| account_no   | VARCHAR2(10), PRIMARY KEY |
| cust_no      | FK → Customer |
| type         | VARCHAR2(20)  |
| balance      | NUMBER        |
| branch_code  | VARCHAR2(10)  |
| branch_name  | VARCHAR2(100) |
| branch_city  | VARCHAR2(50)  |

### 💰 Loan Table

| Column       | Type          |
|--------------|---------------|
| loan_no      | VARCHAR2(10), PRIMARY KEY |
| cust_no      | FK → Customer |
| loan_amount  | NUMBER        |
| branch_code  | VARCHAR2(10)  |
| branch_name  | VARCHAR2(100) |
| branch_city  | VARCHAR2(50)  |

---

## ⚙️ How to Run the Project

1. Clone the repository.
2. Set up Oracle DB using SQL*Plus:
   - Create the 3 tables and insert sample data.
3. Update your DB credentials in the Java code (`BANKAPP1.java`).
4. Add `ojdbc8.jar` to your Eclipse project’s build path.
5. Compile and run the application.

---

## 📷 Sample Screenshots
-![image](https://github.com/user-attachments/assets/427b167b-0d1d-4064-bbb8-96efb15743a1)
![image](https://github.com/user-attachments/assets/24fd4acd-3af5-4144-bc87-045a4d4a5b91)
![image](https://github.com/user-attachments/assets/3ef4f286-67db-420e-bd57-57c1d1f766b3)
![image](https://github.com/user-attachments/assets/e0baf6a8-6cdf-43b9-a328-62cacb2af882)
![image](https://github.com/user-attachments/assets/a359397d-430a-4802-9eb5-b37ff55d6b88)
![image](https://github.com/user-attachments/assets/e3517550-c07f-42e2-9b21-a4a4de01e683)


---

## 👨‍💻 Author

- **Name:** Iswar Kumar Patra



---

## 🔮 Future Scope

This Banking Management System is currently console-based, but there are several opportunities to extend and enhance the project:

### 🖥️ GUI Interface with JavaFX or Swing
- Improve user interaction with a graphical desktop UI.

### 🌐 RESTful APIs with Spring Boot
- Expose banking operations via APIs for web or mobile integration.

### 📱 Web Interface using HTML/CSS + JavaScript
- Develop a full web-based frontend connected to the backend APIs.

### 🔐 Authentication & Authorization
- Add user login, roles (admin/customer), and secure access control.

## 📎 Notes

- This project was part of the **Introduction to Databases (IDB)** lab course.
- Designed to demonstrate practical use of Java, SQL, and JDBC.
- Handles **input validation**, **data persistence**, and **error management**.

---

## ⭐ Final Thoughts

This project reflects foundational skills in **Java programming**, **Oracle database design**, and **JDBC integration**—perfect for showcasing **real-world database interaction skills** in interviews and placements.

