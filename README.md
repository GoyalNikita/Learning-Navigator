# Learning Navigator - Exam Enrollment Service

## Project Overview
The Learning Navigator Exam Enrollment Service is a simplified RESTful API designed to manage the exam enrollment process within a Learning Management System (LMS). This service handles CRUD operations for Students, Subjects, and Exams using Spring Boot and MySQL for data persistence. Additionally, the service includes a hidden Easter egg feature that provides random facts about numbers.

## Author
Nikita Goyal

## Features
- CRUD operations for Students, Subjects, and Exams.
- Students can only register for exams they are enrolled in.
- Foreign Key relationships between entities.
- Graceful error handling with appropriate HTTP status codes.
- Global Exception Handling using `@ControllerAdvice`.
- Basic unit tests with MockMvc and Mockito.
- Hidden Easter egg feature leveraging the Numbers API.

## Technologies Used
- Spring Boot
- Spring Data JPA
- MySQL
- MockMvc and Mockito (for unit testing)
- Numbers API (for Easter egg feature)

## Endpoints
### Students
- **GET /students** - Retrieve all students.
- **GET /students/{id}** - Retrieve a student by ID.
- **POST /students** - Create a new student.
- **PUT /students/{id}** - Update an existing student.
- **DELETE /students/{id}** - Delete a student by ID.

### Subjects
- **GET /subjects** - Retrieve all subjects.
- **GET /subjects/{id}** - Retrieve a subject by ID.
- **POST /subjects** - Create a new subject.
- **PUT /subjects/{id}** - Update an existing subject.
- **DELETE /subjects/{id}** - Delete a subject by ID.

### Exams
- **GET /exams** - Retrieve all exams.
- **GET /exams/{id}** - Retrieve an exam by ID.
- **POST /exams** - Create a new exam.
- **PUT /exams/{id}** - Update an existing exam.
- **DELETE /exams/{id}** - Delete an exam by ID.
- **POST /exams/{examId}** - Register a student for a specific exam.

### Easter Egg Feature
- **GET /hidden-feature/{number}** - Generate a random fact about the number passed as a path parameter.

## Error Handling
The service uses `@ControllerAdvice` for global exception handling. Common errors are handled gracefully and appropriate HTTP status codes are returned.

## Database Schema
The entities have the following relationships:
- Each Student can enroll in multiple Subjects.
- Each Subject can have multiple Students.
- Each Exam is associated with one Subject.
- Each Exam can have multiple Students.

## Getting Started

### Prerequisites
- Java 11 or higher
- Gradle
- MySQL

### Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/GoyalNikita/Learning-Navigator.git
    cd LearningNavigator
    ```

2. Install dependencies and build the project:
    ```bash
    ./gradlew build
    ```

3. Run the application:
    ```bash
    ./gradlew bootRun
    ```

4. The API will be available at `http://localhost:8080`.

### Configuration

- Update `application.properties` with your MySQL configurations if needed:
    ```properties
    spring.datasource.url = jdbc:mysql://localhost:3300/{database}
    ```

## Running the Tests

Run the following command to execute the tests:
```bash
./gradlew test
```

## Postman Collection

You can use the following Postman Collection to test the API:
[Learning Navigator API Postman Collection](https://red-firefly-736811.postman.co/workspace/New-Team-Workspace~446ac2dc-32b8-4882-b3de-4aba165c8ad5/collection/36335262-4d28656e-c465-47fb-84c3-803761410843?action=share&creator=36335262)
