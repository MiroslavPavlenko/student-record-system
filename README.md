# School Record System

## Overview

* is a Java-based desktop application for managing school records of two types: * and *. It provides a simple graphical user interface (GUI) using Java Swing’s `JOptionPane` dialogs to allow users to add new records, find existing records by ID, and remove records. The data for students and staff is stored in an * database (or any MySQL instance) on the backend, ensuring that records persist between runs. The application is structured with separate classes for students and staff and demonstrates good software practices such as object-oriented design, * to protect object integrity, and external configuration for sensitive information (so passwords and DB connection details are *). 

*Author: Miroslav Pavlenko (2025).* This project was created as a demonstration of a simple CRUD (Create, Read, Update, Delete) system with a focus on clean code, security, and cloud integration.

## Features

- ✅for students and staff
- ✅entries using GUI prompts
- ✅in Java for safe object management
- ✅with AWS RDS MySQL
- ✅using `JOptionPane`
- ✅to prevent SQL injection
- ✅via `config.properties`
- ✅(infrastructure as code)

## Technologies Used

- Java (JDK 8+)
- Java Swing (`JOptionPane`)
- MySQL (AWS RDS)
- JDBC (MySQL Connector/J)
- Terraform (for provisioning AWS RDS)

## Terraform Setup (AWS RDS)

Terraform scripts are included to automatically provision the MySQL database on AWS RDS.

### Setup:
1. Install [Terraform](https://www.terraform.io/downloads.html)
2. Navigate to the `terraform/` directory
3. Configure your `main.tf` with your desired AWS region, instance class, username, and password
4. Initialize and apply:
```bash
terraform init
terraform apply
```
5. Copy the endpoint of your RDS instance and update `config.properties`

* Be sure to destroy your instance if you're done to avoid AWS charges:
```bash
terraform destroy
```

## Getting Started

See full instructions for database setup, local configuration, and compiling Java code in the main README.

## Adding New Student
1. ![Database Selection](https://github.com/user-attachments/assets/eaf160fe-6ca3-48b7-bd68-8789ec4b9372)
   * First, select the database you want to manage in are case Student database
2. ![Student Database Options](https://github.com/user-attachments/assets/0e9dc1be-4ff4-457e-a37a-aa5a6ab67259)
   * Then select Add Student
3. ![Promp For New Student ID](https://github.com/user-attachments/assets/515fc462-6e2d-4ba6-afdb-ce070d8d2150)
   * Then, enter the student ID that you want to add
4. ![student id field](https://github.com/user-attachments/assets/7a0639be-4bd3-4287-9c4a-7c61e98a96eb)
   * In are case, we will enter 222222
5. ![Student First Name Promp](https://github.com/user-attachments/assets/b7e84db0-b62c-4e2a-8e26-bb26608a9634)
   * Then enter student's first name 
6. ![First name field](https://github.com/user-attachments/assets/5063a061-e02d-499b-addb-13a3eff918ac)
   * In my case, I will enter my first name 
7. ![Last name promp](https://github.com/user-attachments/assets/5aa044e5-b08d-4161-a205-380a96af7b9c)
   * Then enter student's last name
9. ![image](https://github.com/user-attachments/assets/e7f7b68b-a64f-4add-b063-173060adc33c)
   * In my case, I will enter my last name  
10. ![confirmation screen](https://github.com/user-attachments/assets/ea08773e-1eb8-48ae-b85f-17623e21a457)
    * Then we can check if the information we enter is correct, if it is, press yes, else no
11. ![Successful promp](https://github.com/user-attachments/assets/db21d921-b069-4d5e-89a3-fc35de4d4d12)
    * If everything is correct, you will get a success message, else the program will close

## Here Examle of what is happening to the database in the backstage
1. ![students_repository](https://github.com/user-attachments/assets/ab7555a0-9ab5-4c70-b265-addf5ca259f1)
   * Before
2. ![image](https://github.com/user-attachments/assets/c9178815-f011-4750-8229-82c5077fb93c)
    * After

## File Structure

```
SchoolRecordSystem/
│
│
├── db/
│   ├──main.tf
│   ├── StaffDB.java
│   └── StudentDB.java
├── model/
│   ├── Staff.java
│   ├── Student.java
├── src/
│   ├── SchoolRecordSystem.java
├── screenshots/
├── terraform/
│   ├── main.tf 
│   └── variables.tf 
├── ui/
│   ├── Interface.java
├── config.example.properties
├── .gitignore
└── README.md
```

## Future Improvements

- View all records in a table
- Edit/update support
- Improved UI with JavaFX or Swing tables
- RESTful API version using Spring Boot
- Role-based login system
- PDF/CSV export

---

* Miroslav Pavlenko  
* miroslavpavlenko@yahoo.com

