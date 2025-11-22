📝 Task Manager API

This is a simple Task Manager REST API, developed as a personal study project.
It includes basic operations for managing tasks and updating their status.

🚀 Technologies Used
Java 17+
Spring Boot
Spring Web
Spring Data JPA
H2 Database
Maven

📦 Features
Create, update, list and delete tasks
Change task status (pending / completed)
DTO usage for cleaner communication
Global exception handling
Simple and clean REST architecture

📁 Project Structure
controller/ — REST endpoints
service/ — business logic
repository/ — data persistence
dto/ — request & response objects
exceptions/ — custom exception handling

▶️ Running the Project

Clone the repository: git clone https://github.com/wCarvalhoDev/task-manager-api
Navigate to the folder: cd task-manager-api
Run with Maven: mvn spring-boot:run
Access the H2 console: http://localhost:8080/h2-console
