# Smart Banking Management System

A console-based banking management system developed using Java, MySQL, and JDBC.

## Features

- User Registration
- User Login
- Bank Account Creation
- Deposit Money
- Withdraw Money
- Check Account Balance
- Transaction History
- Money Transfer

## Technologies Used

- Java
- MySQL
- JDBC
- Object-Oriented Programming

## Project Structure

```text
smart-banking-management-system/
│
├── src/
│   ├── Main.java
│   ├── DatabaseConnection.java
│   ├── User.java
│   ├── UserService.java
│   ├── LoginService.java
│   ├── Account.java
│   ├── AccountService.java
│   ├── BankingService.java
│   ├── TransactionService.java
│   └── TransferService.java
│
├── database/
│   └── banking.sql
│
├── README.md
└── .gitignore

```

## How It Works

1. User registers with their name, email, and password.
2. User logs in using their registered email and password.
3. User creates a bank account.
4. User can deposit and withdraw money.
5. User can check the account balance.
6. User can view transaction history.
7. User can transfer money to another account.

## Database

MySQL is used to store:

- User details
- Bank account details
- Account balances
- Transaction records

JDBC is used to connect the Java application with the MySQL database.

## Learning Objectives

This project helped me practice:

- Java programming
- Object-Oriented Programming
- SQL and database concepts
- JDBC connectivity
- CRUD operations
- Exception handling

## Future Enhancements

- Add a graphical user interface
- Add password encryption
- Improve input validation
- Add email or SMS notifications
- Add an admin dashboard
