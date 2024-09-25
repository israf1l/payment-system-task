## Payment System

## About The Project
The Payment System Task is a microservice-based project that simulates a typical payment processing system. The project demonstrates a distributed architecture with microservices for handling account management, payments, and gateway authentication. Each service is designed to handle specific responsibilities, using Spring Boot and various technologies like OpenFeign, PostgreSQL, and Docker.

### Architecture

![image](https://github.com/user-attachments/assets/2add33a3-41cc-4b98-bd01-b3f6dca8054f)

The system is composed of the following microservices:

- auth-simulation: Handles authentication and token validation.
- gateway: Acts as an API gateway that routes requests to other services and handles security concerns.
- msAccount: Manages user accounts and their details.
- msPayments: Handles payment-related operations.

## Built with

Java 21
Spring Boot 3.3.4
Spring Cloud OpenFeign
Spring Data JPA
PostgreSQL
Liquibase
Docker
Gradle

### Getting started
To run the project, you need to have the following installed:

JDK 21
Docker (to run services in containers)

### Installation

1. Clone the Repository
  ```sh
  git clone https://github.com/israf1l/payment-system-task.git
  cd payment-system-task
  ```
2. Clone the Repository
  ```sh
  ./gradlew clean build
  ```
3. Clone the Repository
  ```sh
  docker-compose up --build
  ```    
