# Day 07 - Spring Boot (Exception Handling Continuation)

Day 6 me global exception handling ka basic structure start hua tha. Day 7 me
usi handler ko Day 5 ke existing CRUD flow se wire kiya gaya hai; naya copied
CRUD project nahi banaya gaya.

## Aaj maine kya seekha?

- `@RestControllerAdvice` ko controller se alag global exception boundary ke
  roop me use karna.
- Resource na milne par custom `ResourceNotFoundException` throw karna.
- Exception ko reusable `ErrorResponse` body aur HTTP status me convert karna.
- Generic exception response me internal details expose nahi karni.
- Existing Day 5 ke controller/service/repository flow ko reuse karna; classes
  ko Day 7 folder me copy nahi karna.

## Day 6 se Day 7 ka exact next implementation

Day 7 implementation Day 5 ke service/controller aur Day 6 ke handler package
ko directly connect karti hai:

1. `day-06...globalexceptionhandler.ResourceNotFoundException`
   `RuntimeException` extend karti hai aur message constructor leti hai.
2. Day 5 ke service me missing/soft-deleted student par
   `ResourceNotFoundException` throw hoti hai.
3. `GlobalExceptionHandler`:
   - `ResourceNotFoundException` ke liye `404 NOT_FOUND` response do.
   - `RuntimeException` ke liye `500 INTERNAL_SERVER_ERROR` response do.
   - Generic handler ka parameter `Exception` rakhta hai, `RuntimeException`
     nahi.
4. `ErrorResponse` me `status`, `message`, aur `timestamp` fields hain.
5. Get, update, soft delete, aur hard delete ke missing-ID branches advice tak
   exception propagate karte hain.

## Important Annotation

`@RestControllerAdvice` :- sabhi controllers ke exceptions handle karta hai.

`@ExceptionHandler(ResourceNotFoundException.class)` :- resource missing hone
par specific handler chalata hai.

`@ExceptionHandler(Exception.class)` :- unexpected exception ke liye final
fallback handler.

## Important Commands

```bash
mvn spring-boot:run
mvn test
```

## Expected HTTP Status

- `200 OK` - successful read/update
- `201 CREATED` - successful create
- `404 NOT_FOUND` - requested resource nahi mila
- `500 INTERNAL_SERVER_ERROR` - unexpected server error

## Error Faced

### Error 1: Day 6 project me Maven build file nahi hai

#### Error ka Meaning

`day-06-springboot-ExceptionHandling` me abhi `pom.xml` aur complete Spring
Boot application structure nahi hai, isliye Maven validation run nahi ho sakti.

#### Error ka Solution

Day 7 ne Maven configuration ya classes copy nahi ki. Existing Day 5 CRUD
classes aur Day 6 handler package ko source of truth rakha gaya hai. Maven
configuration add karna alag project setup task hoga.

## Configuration File

Day 6/Day 7 folder me configuration file abhi nahi hai. `mvnw.cmd` bhi
available nahi hai.

## Important Learning

- Daily folder me notes rakho, classes ki duplicate copies nahi.
- Exception handling ko service flow ke saath wire kiye bina sirf handler class
  banana incomplete implementation hai; Day 7 me service flow wired hai.
- Specific exceptions ko generic fallback se pehle handle karo.
