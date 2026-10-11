# Hospital API

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange" alt="Java 17" />
  <img src="https://img.shields.io/badge/Spring%20Boot-4.1.1-brightgreen" alt="Spring Boot 4.1.1" />
  <img src="https://img.shields.io/badge/REST-API-5A67D8" alt="REST API" />
</p>

A Spring Boot REST API for managing nurse data in a hospital environment. This project was developed as part of the M0492 - Introduction to Back End module and focuses on backend fundamentals such as controllers, data access, and request handling.

## Overview

The application exposes endpoints to:

- list all nurses
- validate a nurse login
- search a nurse by name
- load initial nurse data from a JSON file

## Features

- Nurse authentication through a login endpoint
- Listing of all nurses registered in the system
- Search by nurse name
- JSON-based initialization of sample data
- Clean project structure using Spring Boot

## Team and responsibilities

| Issue | Responsible person |
| --- | --- |
| getAll method | Eric Huang |
| Nurse login validation | Joel del Río |
| Search for nurses by name | Sergi Ye |
| Migrating from a Java project to a Spring Boot project | Akashdeep Singh |

## Technologies used

- Java 17
- Spring Boot 4.1.1
- Maven
- RESTful controllers

## Project structure

```text
M0492-Introducci-al-Back-End/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/hospital/hospital/
│   │   │       ├── HospitalApplication.java
│   │   │       ├── Nurse.java
│   │   │       └── NurseController.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── nurses.json
│   └── test/
│       └── java/com/hospital/hospital/
│           └── HospitalApplicationTests.java
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## Getting started

### Prerequisites

- Java 17 or later
- Maven
- Git

### Run the application

1. Clone the repository:

```bash
git clone https://github.com/Akashdeep-Kallon/M0492-Introducci-al-Back-End.git
cd M0492-Introducci-al-Back-End
```

2. Run the project with Maven:

```bash
./mvnw spring-boot:run
```

3. Open the application in your browser or API client at:

```text
http://localhost:8080
```

## API endpoints

| Method | Endpoint | Description |
| --- | --- | --- |
| GET | `/nurse/index` | Returns the full list of nurses |
| POST | `/nurse/login` | Validates nurse credentials |
| GET | `/nurse/name/{name}` | Searches for a nurse by name |

### Example login request

```json
{
  "user": "nurse01",
  "pw": "password123"
}
```

### Example response

```json
true
```

## Notes

- The initial list of nurses is loaded from `src/main/resources/nurses.json`.
- This project is a backend-focused example and demonstrates basic Spring Boot API development.

## License

This project is for educational purposes as part of the backend course assignment.

---

Developed with Spring Boot and Java for the hospital management API exercise.
