# REST API WITH JAVA/SPRING BOOT

This API allows the creation, updating, retrieval, and deletion of person records using Java and Spring Boot.

## Technologies Used

- **Java 17**
- **Spring Boot 3.3.4**
- **JPA/Hibernate**
- **MySQL**
- **Maven**

## Endpoints

### List all people

**GET** `/person`

- **Response**: Returns a list of all person records.
- **Status**: `200 OK`

### Get person by ID

**GET** `/person/{id}`

- **Parameter**: `id` (Long) - The ID of the person.
- **Response**: Returns the person data for the given ID.
- **Status**: `200 OK`
- **Error**: `404 Not Found` - If the ID is not found.

### Create a new person

**POST** `/person`

- **Request Body**:
  ```json
  {
    "firstName": "John",
    "lastName": "Doe",
    "address": "123 Street",
    "gender": "Male"
  }

### Update a person's data

**PUT** `/person`

- **Request Body**:
  ```json
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "address": "123 Updated Street",
    "gender": "Male"
  }

### Delete a Person

**DELETE** `/person/{id}`

- **Parameter**: `id` (Long) - The ID of the person.
- **Response**: `204 No Content` (No body in the response).
- **Error**: `404 Not Found` - If the ID is not found.