# Backend-Java-spring-boot-v1 

# code in branch master!!

## Requirement
Java 21
Spring Boot

## Project Requiremnet

These API should be written in Java language, with at least version 17 or higher.
Apply Spring Boot framework.
Create a RESTful API with the following endpoints:
GET /users: Retrieve a list of all users.
GET /users/{userId}: Retrieve details of a specific user.
POST /users: Create a new user.
PUT /users/{userId}: Update details of a specific user.
DELETE /users/{userId}: Delete a specific user.
Use the user data from here as the data model.
Validation: Ensure that all required fields are provided when crating or updating a user.
Response Format: Use JSON for request and response bodies, include appropriate HTTP status codes for success and errors scenarios.

## Clone the project
https://github.com/Geardevop/Backend-Java-spring-boot-v1.git

## application.properties
spring.application.name=demo
# Server configuration
server.port=8080

# H2 Database configuration
spring.datasource.url=jdbc:h2:mem:userdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=vorawee
spring.datasource.password=wilawan
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA configuration
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Initialize data from data.sql
spring.jpa.defer-datasource-initialization=true
spring.sql.init.mode=always
