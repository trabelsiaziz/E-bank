# E-Bank Application

A Spring Boot-based banking application that provides RESTful APIs for managing customers and bank accounts (Current and Savings accounts).

## Features

- **Customer Management**: Create and manage customer profiles
- **Account Management**: Support for two types of accounts:
  - **Current Account**: With overdraft facility
  - **Savings Account**: With interest rate
- **Account Operations**: Perform banking operations (credit/debit)
- **API Documentation**: Interactive API documentation using Swagger/OpenAPI

## Tech Stack

- **Java 21**
- **Spring Boot 4.0.1**
- **Spring Data JPA**: For data persistence
- **H2 Database**: In-memory database for development
- **Lombok**: To reduce boilerplate code
- **SpringDoc OpenAPI**: For API documentation
- **Maven**: Build and dependency management

## Prerequisites

- Java 21 or higher
- Maven 3.6+

## Getting Started

### Clone the repository
```bash
git clone <repository-url>
cd e-bank
```

### Build the project
```bash
mvn clean install
```

### Run the application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Documentation

Once the application is running, you can access the interactive API documentation at:
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/v3/api-docs

## Database Console

Access the H2 database console at: http://localhost:8080/h2-console
- **JDBC URL**: `jdbc:h2:mem:e-bank-db`
- **Username**: `sa`
- **Password**: (leave empty)

## Project Structure

```
src/main/java/org/aziz/ebank/
├── controllers/       # REST API controllers
├── services/         # Business logic layer
├── repositories/     # Data access layer
├── entities/         # JPA entities
├── DTOs/            # Data Transfer Objects
├── mappers/         # Entity-DTO mappers
└── enums/           # Enumerations
```

## API Endpoints

### Customer APIs
- `GET /customers` - Get all customers
- `GET /customers/{id}` - Get customer by ID
- `POST /customers` - Create a new customer
- `DELETE /customers/{id}` - Delete a customer

### Bank Account APIs
- `POST /accounts` - Create a new bank account
- `GET /accounts/{id}` - Get account details
- `POST /accounts/{id}/operations` - Perform account operations

## License

This project is licensed under the MIT License.

