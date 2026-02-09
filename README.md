# Enrollment System 

A Spring Boot application for managing students, courses, professors, course offerings and enrollments.
This project is designed as a training project with focus on clean architecture, best practices, and maintainability

## Features
- Manage Students

- Manage Courses

- Manage Professors

- Define Course Offerings (Course + Professor + Semester + Capacity)

- Student Enrollment (Course selection with capacity control)

- Centralized Exception Handling

- Request validation with meaningful error responses

- documented APIs using Swagger

## Tech Stack
Java 17 (Java 11+ compatible)

Spring Boot 3.5.10

Spring Data JPA


H2 In-Memory Database

Maven

Swagger

## Architecture
3-layer architecture:
- Controller  →  Service  →  Repository

## Package Structure
com.example.university

├── controller         ----> REST controllers

├── service           ----> Business logic (interfaces + implementations)

├── repository        ----> Spring Data JPA repositories

├── dto               ----> Request / Response DTOs

├── entity   ----> JPA entities

├── enums

├── exception         ----> Custom exceptions & global exception handler

├── mapper            ----> Entity to DTO mapping




## Getting Started

Clone the Repository

```bash
git clone https://github.com/MohamadHasanMasdar/university.git
cd university

```

Run the Application

```bash
mvn clean spring-boot:run

```
The application will start on: 
- http://localhost:8080

## API Documentation (Swagger)

All APIs are documented using Swagger.

Once the application is running, access Swagger UI at:

- http://localhost:8080/swagger-ui.html
