# Property Manager

A Spring Boot application for managing tenants, properties, and owners. This project uses PostgreSQL as the database and supports deployment with Docker and Docker Compose.

---

## Features

- Manage tenants, owners, and properties
- RESTful API endpoints
- Swagger UI for API documentation and testing
- Secure password handling for owners
- PostgreSQL database integration
- Dockerized for easy deployment

---

## Getting Started

### Prerequisites

- Java 17+
- Maven
- Docker & Docker Compose

---

### Build the Application

```sh
./mvnw clean package
```
or
```sh
mvn clean package
```

The JAR file will be generated in the `target/` directory.

---

### Running with Docker Compose

1. **Build and start the containers:**
   ```sh
   docker-compose up -d --build
   ```

2. **Access the application:**
   - API: [http://localhost:8080](http://localhost:8080)
   - Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

### Configuration

- Database settings are managed in `src/main/resources/application.properties`.
- Environment variables for database connection can be overridden in `docker-compose.yml`.

---

### API Documentation

After starting the app, visit [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) for interactive API docs.

---

### Example API Request

**Register Owner**
```json
POST /api/owners
{
  "fullName": "Jane Doe",
  "email": "jane@example.com",
  "phone": "1234567890",
  "password": "yourPassword"
}
```

**Add Property**
```json
POST /api/properties
{
  "propertyNo": 101,
  "type": "Apartment",
  "location": "Downtown",
  "size": "120sqm",
  "monthlyRate": "1000",
  "status": "Available",
  "additionalDetails": "Near park",
  "block": "A",
  "ownerId": 1
}
```

---

## Notes

- The `role` for owners is set automatically to `OWNER` when registering.
- Passwords are never returned in API responses.
- For production, update environment variables and security settings as needed.

---

## License

This project is for educational and internal use.