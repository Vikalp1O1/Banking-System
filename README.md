
# Online Banking System

## Overview
The **Online Banking System** is a web-based banking application built with **Spring Boot** for the backend and **React** for the frontend. The project enables users to create accounts, log in, check account details, and perform transactions like deposits and withdrawals.

## Features
- User Registration and Login
- View Account Details
- Deposit and Withdrawal Functionality
- Responsive Navigation Bar
- Frontend Styling with CSS

## Technologies Used
- **Backend**: Spring Boot, Hibernate, MySQL
- **Frontend**: React, JavaScript, HTML, CSS
- **Database**: MySQL
- **Tools**: Spring Tool Suite 4 (for Spring Boot), npm (for React)

## Project Structure

### Backend
- **Spring Boot** manages the RESTful API that handles user authentication, account management, and transaction processing.
- **Hibernate** is used for ORM, mapping Java objects to MySQL database tables.
- **MySQL** stores user and account information.

### Frontend
- **React** creates a dynamic and responsive user interface.
- **Axios** manages HTTP requests to the Spring Boot backend.

## Setup Instructions

### Prerequisites
- Java 17 or above
- Node.js and npm
- MySQL
- Maven

### Running the Backend
1. Clone the repository:
    ```bash
    git clone https://github.com/yourusername/online-banking-system.git
    cd online-banking-system/backend
    ```
2. Configure the database in `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/banking_db
    spring.datasource.username=root
    spring.datasource.password=yourpassword
    spring.jpa.hibernate.ddl-auto=update
    ```
3. Build and run the Spring Boot application:
    ```bash
    mvn clean install
    mvn spring-boot:run
    ```
   
### Running the Frontend
1. Navigate to the `frontend` directory:
    ```bash
    cd ../frontend
    ```
2. Install dependencies:
    ```bash
    npm install
    ```
3. Start the React development server:
    ```bash
    npm start
    ```
4. Access the frontend at `http://localhost:3000`.

## Usage
- Register a new account.
- Log in with the registered username and password.
- Access account details, including the account number and balance.
- Use the deposit and withdrawal functionality to manage the account balance.

## Future Enhancements
- Implement transaction history tracking.
- Add secure password encryption.
- Improve UI with more advanced styling.


