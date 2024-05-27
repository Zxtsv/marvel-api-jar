# Marvel API JAR

This project is part of the technical test for OpenPay. It is a Spring Boot project designed to consume the Marvel API and generate a JAR file for further use in another project.

## Table of Contents
- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)
- [Usage](#usage)
- [Building the JAR](#building-the-jar)
- [Running Tests](#running-tests)
- [License](#license)

## Project Overview
The Marvel API JAR project is a Spring Boot application that consumes the Marvel API to retrieve various data related to Marvel characters, comics, and more. This project is designed to demonstrate proficiency in creating a Spring Boot application, consuming external APIs, and generating a JAR file for use in other projects.

## Technologies Used
- **Java 17**
- **Spring Boot**
- **Spring Web**
- **Spring Boot Actuator**
- **Spring Boot DevTools**
- **Lombok**
- **JUnit 5**

## Setup Instructions
1. **Clone the repository:**
   ```bash
   https://github.com/Zxtsv/marvel-api-jar.git
    ```
2. **Build the project:**
   ```bash
   ./mvnw clean install
    ```

## Usage
1. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
    ```
2. **Access the application:**
The application will start on http://localhost:8080. You can use various endpoints to interact with the Marvel API.

## Building the JAR
To build the JAR file for this project, use the following command:
```bash
   ./mvnw clean package
```
The generated JAR file will be located in the target directory.

## Running Tests
```bash
   ./mvnw test
```

## License
This project is licensed under the MIT License. See the LICENSE file for details.