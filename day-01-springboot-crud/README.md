# Day 01 - Spring Boot CRUD

## Aaj maine kya seekha?

- Spring Boot CRUD ka workflow
- `/api/students` endpoint
- Controller, Service aur Repository layer
- Student Entity ka use
- Postman se request bhejna
- `ResponseEntity`
- JPA ke basic methods
- Database se connection
- `Optional` class

## Application Workflow

```text
Postman / Client
      |
      | HTTP Request
      v
Student Controller
      |
      | Business Logic ke liye call
      v
Student Service
      |
      | Database interaction
      v
Student Repository
      |
      v
Database

Student Entity
      |
      v
Database table ke structure ko represent karti hai
```

## Controller

| Operation | HTTP Method | Endpoint |
|---|---|---|
| Create | `POST` | `/api/students/create` |
| Read One | `GET` | `/api/students/{id}` |
| Read All | `GET` | `/api/students` |
| Update | `PUT` | `/api/students/{id}` |
| Delete | `DELETE` | `/api/students/{id}` |

## ResponseEntity

Agar hume khud se response create karna ho,
to `ResponseEntity` ka use karte hain.

```java
ResponseEntity<Student>
```

`ResponseEntity<Student>` ka matlab hai ki response me
`Student` type ka data bhejna hai.

Example:

```java
ResponseEntity
        .status(HttpStatus.CREATED)
        .body(createdStudent);
```

### `status()`

`status()` method ke through HTTP status set karte hain.

HTTP status codes enum me stored hote hain:

```java
HttpStatus.CREATED
HttpStatus.OK
HttpStatus.NOT_FOUND
```

### `body()`

`body()` method ke through response ka data bhejte hain.

Example:

```java
.body(createdStudent)
```

## JPA

JPA ka full form:

```text
Jakarta Persistence API
```

JPA database ke common methods khud handle karta hai.
In methods ko manually override nahi karna hota.

## JPA ke Basic Methods

| Operation | JPA Method | Query ka Meaning |
|---|---|---|
| Create | `save()` | Student insert karna |
| Read All | `findAll()` | Saare students select karna |
| Read One | `findById()` | ID ke through student select karna |
| Update | `save()` | Existing student update karna |
| Delete | `deleteById()` | ID ke through student delete karna |
| Check | `existsById()` | Student exist karta hai ya nahi |

### `save()`

```java
save()
```

Create ke time:

```text
INSERT INTO student
```

Update ke time:

```text
UPDATE student
```

### `findAll()`

```java
findAll()
```

Iska meaning hai:

```sql
SELECT * FROM student;
```

### `findById()`

```java
findById()
```

Iska use ek student ko ID ke through read karne ke liye hota hai.

### `deleteById()`

```java
deleteById()
```

Iska use ID ke through student delete karne ke liye hota hai.

### `existsById()`

```java
existsById()
```

Ye boolean return karta hai:

```text
true  -> Student exist karta hai
false -> Student exist nahi karta
```

## Database se Connection

Database connection ke liye `application.properties` file me configuration likhte hain:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_crud_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

> **Note:** Actual database password ko GitHub par upload nahi karna hai.

## JPA Configuration

JPA ko database table automatically handle karne ke liye:

```properties
spring.jpa.hibernate.ddl-auto=update
```

Agar SQL query dekhni ho:

```properties
spring.jpa.show-sql=true
```

SQL query ko readable format me dekhne ke liye:

```properties
spring.jpa.properties.hibernate.format_sql=true
```

## Optional Class

`Optional` ka use tab hota hai jab value exist bhi kar sakti hai
aur `null` bhi ho sakti hai.

Isliye value optional hoti hai.

Example:

```java
Optional<Student>
```

## CRUD Operation Finally Performed

```text
Create
  ↓
Read One
  ↓
Read All
  ↓
Update
  ↓
Delete
```

## Important Concept

Spring Boot Java application develop karne ke liye use hota hai.

Isme:

- Configuration easy hoti hai.
- Server setup easy hota hai.
- Database connection JPA ke through handle kar sakte hain.
- CRUD operations ke liye JPA ke ready-made methods milte hain.

## Important Annotations

```java
@PathVariable
@RequestBody
```

### `@PathVariable`

URL ke andar se value receive karne ke liye use hota hai.

Example:

```text
/api/students/1
```

### `@RequestBody`

Client se request body ke andar data receive karne ke liye use hota hai.

## Error Faced

### Error 1: Failed to Configure a DataSource

#### Error Message

```text
Failed to configure a DataSource
```

#### Error ka Reason

SQL driver dependency add ki gayi thi,
lekin database ki required configuration available nahi thi.

#### Error ka Solution

Database configuration add karne ki koshish ki:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_crud_db
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

> `DataSourceAutoConfiguration` ko exclude karna database CRUD project ke liye proper solution nahi hai, kyunki isse database auto-configuration disable ho jaati hai.

### Error 2: Unrecognized `hibernate.hbm2ddl.auto` Setting

#### Error Message

```text
org.springframework.beans.factory.BeanCreationException:
Error creating bean with name 'entityManagerFactory'
```

```text
Unrecognized 'hibernate.hbm2ddl.auto' setting: 'true'
```

#### Error ka Reason

`hibernate.hbm2ddl.auto` property me value `true` di gayi thi,
lekin is property ko `true` ya `false` nahi,
balki valid value chahiye hoti hai.

#### Configuration

```properties
spring.jpa.hibernate.ddl-auto=update
```



## Important Command

Application run karne ke liye:

```bash
mvn spring-boot:run
```