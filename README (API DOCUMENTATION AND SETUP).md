# Library System

## Overview

This project is a Library System built using **Java 17**, **Spring Boot 3.3.4**, and **PostgreSQL**. The system enables users to manage library operations such as registering borrowers, adding books, borrowing and returning books, and viewing the list of available books.

### Features

- Register new borrowers with a name and email.
- Register new books with unique ISBN numbers.
- Retrieve a list of all available books.
- Borrow a book by its ID.
- Return a borrowed book.

---

## Setup Instructions

### Prerequisites:

- Java 17
- Spring Boot 3.3.4
- PostgreSQL
- Gradle
- Docker (for containerization)
- GitLab (for CI/CD)

### Database Configuration (PostgreSQL):

Configure the PostgreSQL database in the `application.properties` file:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/assessment
spring.datasource.username=postgres
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Modifying `book_id` for Auto Increment in PostgreSQL:

If your `book_id` is not auto-incrementing, run the following SQL command to set it up:

```sql
ALTER TABLE book
ALTER COLUMN book_id SET DEFAULT nextval('book_id_seq');
```

### Build and Run the Application:

1. Clone the repository and navigate to the project root.
2. Build the project using Gradle:
   ```bash
   ./gradlew clean build
   ```
3. Run the application:
   ```bash
   java -jar build/libs/library-system-0.0.1-SNAPSHOT.jar
   ```

---

## API Endpoints

### 1. Register a new borrower:

**POST** `http://localhost:8080/api/borrowers/registerBorrower`

```json
{
  "name": "John Doe",
  "email": "john.doe@example.com"
}
```

### 2. Register a new book:

**POST** `http://localhost:8080/api/books/addBook`

```json
{
  "title": "Sample Book",
  "author": "John Doe",
  "isbn": "978-3-16-148410-0"
}
```

### 3. Get all books:

**GET** `http://localhost:8080/api/books/getAllBooks`

### 4. Borrow a book:

**POST** `http://localhost:8080/api/borrowers/{borrowerId}/borrow`

```json
{
  "bookId": 1
}
```

### 5. Return a borrowed book:

**POST** `http://localhost:8080/api/borrowers/{borrowerId}/return`

```json
{
  "bookId": 1
}
```

---

## Containerization with Docker

### Docker Setup:

To containerize the application using Docker, follow these steps:

1. Create a `Dockerfile`:

```dockerfile
# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY build/libs/librarySystem-0.0.1-SNAPSHOT.jar librarySystem.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "librarySystem.jar"]
```

2. Build and run the Docker container:

```bash
docker build -t librarySystem .
docker run -d -p 8080:8080 librarySystem
```

### Docker Compose:

To manage the PostgreSQL database and Spring Boot application, use **Docker Compose**:

1. Create a `docker-compose.yml` file:

```yaml
version: "3"
services:
  db:
    image: postgres:16
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: root
      POSTGRES_DB: assessment
    ports:
      - "5432:5432"

  app:
    build: .
    ports:
      - "8080:8080"
    depends_on:
      - db
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/assessment
      SPRING_DATASOURCE_USERNAME: postgres
      SPRING_DATASOURCE_PASSWORD: root
```

2. Run the containers:

```bash
docker-compose up --build
```

---

## CI/CD with GitLab

### GitLab CI/CD Pipeline:

Create a `.gitlab-ci.yml` file for the CI/CD pipeline:

```yaml
image: openjdk:17

stages:
  - build
  - test
  - deploy

build:
  stage: build
  script:
    - ./gradlew clean build
  artifacts:
    paths:
      - build/libs/*.jar

test:
  stage: test
  script:
    - ./gradlew test

deploy:
  stage: deploy
  script:
    - docker build -t librarySystem .
    - docker run -d -p 8080:8080 librarySystem
  only:
    - main
```

This pipeline will:

1. Build the project using Gradle.
2. Run unit tests.
3. Deploy the Docker container when code is pushed to the `main` branch.

---

## Why PostgreSQL?

PostgreSQL was chosen for its robustness, performance, and scalability. It's well-suited for handling complex queries, supports advanced data types such as JSON, and ensures ACID compliance. For this library system, PostgreSQL ensures that data integrity is maintained when managing borrowers and books, and offers flexibility for future scaling.

---

### Author

**Muhammad Farid Bin Nazmi**  
Java Software Developer  
2024

---
