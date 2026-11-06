# Hospital API

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange" alt="Java 17" />
  <img src="https://img.shields.io/badge/Spring%20Boot-4.1.1-brightgreen" alt="Spring Boot" />
  <img src="https://img.shields.io/badge/MySQL-database-4479A1" alt="MySQL" />
  <img src="https://img.shields.io/badge/Spring%20Data%20JPA-Hibernate-6DB33F" alt="Hibernate" />
  <img src="https://img.shields.io/badge/Tests-13%20passing-success" alt="Tests" />
</p>

A Spring Boot REST API for managing hospital nurses. This project was developed as part of the **M0492 - Introduction to Back End** module.

The application uses Spring Data JPA and Hibernate to manage nurse records in a MySQL database. It provides CRUD operations, authentication and search functionality.

## Features

- Complete CRUD operations for nurses.
- MySQL database integration using Hibernate.
- REST API with HTTP status codes.
- Unit testing with JUnit 5 and Mockito.
- Continuous Integration with GitHub Actions.
- API testing using Postman.

## Technologies

- Java 17
- Spring Boot 4.1.1
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- JUnit 5 and Mockito
- GitHub Actions
- Postman

## Data model

The `Nurse` entity is mapped to the `nurse` table in MySQL.

| Field | Type | Description |
|---|---|---|
| `idNurse` | Integer | Auto-generated primary key |
| `username` | String | Unique username |
| `password` | String | Nurse password |
| `name` | String | First name |
| `surname` | String | Last name |
| `email` | String | Email address |

## Prerequisites

- JDK 17
- MySQL Server
- Git

## Installation

Clone the repository:

```bash
git clone https://github.com/Akashdeep-Kallon/M0492-BackEnd-Hospital.git
cd M0492-BackEnd-Hospital
```

Configure the database connection in `application.properties` or using environment variables:

```properties
spring.datasource.url=${SPRING_DATASOURCE_URL}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
```

Set the appropriate database credentials for your environment. Do not publish database passwords in the repository.

## Running the application

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

On Linux or macOS:

```bash
./mvnw spring-boot:run
```

The API will be available at:

`http://localhost:8080`

## API Endpoints

The following endpoints are available:

| Method | Endpoint | Description | Response |
|---|---|---|---|
| POST | `/nurse/login` | Nurse authentication | 200 / 401 |
| GET | `/nurse/index` | Get all nurses | 200 |
| GET | `/nurse/name/{name}` | Find a nurse by name | 200 / 404 |
| POST | `/nurse/create` | Create a new nurse | 201 / 400 |
| GET | `/nurse/{id}` | Find a nurse by ID | 200 / 404 |
| PUT | `/nurse/update/{id}` | Update a nurse | 200 / 400 / 404 |
| DELETE | `/nurse/delete/{id}` | Delete a nurse | 200 / 404 |

### Example requests

**Create a nurse – POST `/nurse/create`**

```json
{
    "username": "nurse01",
    "password": "password123",
    "name": "John",
    "surname": "Smith",
    "email": "john@example.com"
}
```

**Login – POST `/nurse/login`**

```json
{
    "username": "nurse01",
    "password": "password123"
}
```

**Update a nurse – PUT `/nurse/update/1`**

```json
{
    "username": "nurse01",
    "password": "newpassword",
    "name": "John",
    "surname": "Brown",
    "email": "john@example.com"
}
```

The API can be tested using Postman by sending HTTP requests and checking the returned status codes and JSON responses.

## Unit Tests

The project includes **13 tests** covering all methods in `NurseController`, as well as the Spring application context.

Tests are implemented using JUnit 5 and Mockito.

To execute the tests locally:

```bash
./mvnw test
```

On Windows:

```powershell
.\mvnw.cmd test
```

## Continuous Integration

GitHub Actions is configured to execute the unit tests automatically on every push and pull request to the `master` branch.

The pipeline uses JDK 17 and Maven to run the test suite. If a test fails, the workflow is marked as unsuccessful.

## Project Structure

```text
M0492-BackEnd-Hospital/
├── .github/
│   └── workflows/
│       └── ci.yml
├── src/
│   ├── main/
│   │   ├── java/com/hospital/hospital/
│   │   │   ├── HospitalApplication.java
│   │   │   ├── Nurse.java
│   │   │   ├── NurseController.java
│   │   │   └── NurseRepository.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/java/com/hospital/hospital/
│       ├── NurseControllerTest.java
│       └── HospitalApplicationTests.java
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## Project Version

Current documented release: **v0.4.0**

## License

Educational project developed as part of the M0492 Back End module.
