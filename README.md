# Spring RESTful Application

## Overview
This project is a Spring-based RESTful application built using Java 17, Spring Framework version 3.4.1, and SQL Server 19 as the database. It demonstrates clean architecture principles, efficient data management, and REST API design.

## Features
- RESTful endpoints for managing resources
- Integration with SQL Server 19
- Java 17 features for enhanced performance and readability
- Dependency Injection using Spring
- Layered architecture (Controller, Repository)


## Prerequisites
- **Java 17**: Ensure Java Development Kit (JDK) 17 or higher is installed.
- **Maven 3.8+**: Build and dependency management.
- **SQL Server 19**: Set up an instance of SQL Server with the necessary configurations.
- **Postman/Swagger**: For testing RESTful endpoints.

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/thiagpastore/spring-restful
cd spring-restful
```

### 2. Configure the Database
Ensure that SQL Server 19 is running and create a database for the application. Update the `application.yml` or `application.properties` file with your database connection details:

```yaml
spring:
  datasource:
    url: jdbc:sqlserver://localhost:1433;databaseName=your_database
    username: your_username
    password: your_password
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate.dialect: org.hibernate.dialect.SQLServerDialect
```

### 3. Build and Run the Application

#### Using Maven
1. Build the application:
    ```bash
    mvn clean install
    ```
2. Run the application:
    ```bash
    mvn spring-boot:run
    ```

#### Using Executable JAR
1. Build the JAR file:
    ```bash
    mvn package
    ```
2. Run the JAR file:
    ```bash
    java -jar target/spring-restful-1.0.jar
    ```

### 4. Access the Application
- The application will run on `http://localhost:8080` by default.

## Project Structure
```
src/
|-- main/
|   |-- java/
|   |   |-- com.example.restful/
|   |       |-- controller/   # REST controllers
|   |       |-- repository/   # Database operations
|   |       |-- model/        # Entity classes
|   |-- resources/
|       |-- application.properties   # Configuration file
```

## Endpoints
| HTTP Method | Endpoint       | Description              |
|-------------|----------------|--------------------------|
| GET         | `/driver` | Fetch all resources      |
| GET         | `/driver/{id}` | Fetch a single resource |
| POST        | `/driver` | Create a new resource    |
| PUT         | `/driver/{id}` | Update a resource       |
| DELETE      | `/driver/{id}` | Delete a resource       |

## Dependencies
- **Spring Boot 3.4.1**
  - Spring Web
  - Spring Data JPA
- **SQL Server JDBC Driver**: For database connection

## Testing
Use Postman or Swagger to test the endpoints.

### Example POST Request
**URL**: `/driver

**Request Body**:
```json
{
  "name": "Sample Name",
  "birth": "Birth",
  "age":"18"
}
```

## Future Enhancements
- Add JWT-based authentication and authorization.
- Improve error responses for a more user-friendly experience.
- Add support for containerization using Docker.

## Contribution
Feel free to fork this repository and submit pull requests. Feedback and suggestions are welcome!

## License
This project is licensed under the MIT License. See the LICENSE file for details.