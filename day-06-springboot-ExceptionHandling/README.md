# Day 06 - Spring Boot Exception Handling

## Aaj maine kya seekha?

- Abhi tak hum controller ke andar hi exception handle kar rahe the.
- Lekin agar har controller method me exception handle karenge to controller kaafi bulky ho jayega.
- Isliye exception ko ek common class me handle karna better hota hai.
- Is concept ko hum **Global Exception Handling** kehte hain.
- Spring Boot by default generic error response deta hai.
- Hum custom exception aur custom response bana kar error ko apne way me handle kar sakte hain.

## Exception Handling ka Flow

```text
Client/Postman
      |
      v
Controller
      |
      v
Service
      |
      v
Repository
      |
      v
Database
```

Agar kisi step par error aata hai:

```text
Error Found
     |
     v
Global Exception Handler
     |
     v
Error Response Client ko
```

## Controller ke andar problem

Agar hum controller me baar-baar aisa code likhenge:

```java
if (student == null) {
    return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("Student not found");
}
```

To har method me same type ka code repeat hoga.

Isse:

- Controller ka code bada ho jayega.
- Same code baar-baar likhna padega.
- Code maintain karna difficult hoga.

Isliye hum ek alag class banayenge:

```text
GlobalExceptionHandler
```

## Global Exception Handling kya hoti hai?

Global Exception Handling ka matlab hai ki poori application ki exceptions ko ek common class me handle karna.

Isse controller ka code clean rahega aur error response bhi same format me milega.

## Important Annotations

### `@RestControllerAdvice`

Ye annotation ek helper class banata hai jo sabhi controllers ki exceptions ko handle kar sakti hai.

```java
@RestControllerAdvice
public class GlobalExceptionHandler {
}
```

### `@ExceptionHandler`

Ye annotation batata hai ki kaunsa method kis exception ko handle karega.

```java
@ExceptionHandler(RuntimeException.class)
public ResponseEntity<String> handleException(
        RuntimeException exception) {

    return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(exception.getMessage());
}
```

## Important HTTP Status Codes

| Status Code | Meaning |
|---|---|
| `200 OK` | Request successfully complete hui |
| `201 Created` | Naya data create hua |
| `204 No Content` | Request successful hui, lekin response body nahi hai |
| `400 Bad Request` | Client ne galat request bheji |
| `404 Not Found` | Requested data nahi mila |
| `409 Conflict` | Data ke saath conflict hua |
| `500 Internal Server Error` | Server ke andar unexpected error aaya |

## ResponseEntity

`ResponseEntity` ke through hum response ka status aur body dono bhej sakte hain.

```text
ResponseEntity = Body + Status
```

Example:

```java
return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body("Student not found");
```

Isme:

```text
Status = 404 Not Found
Body   = Student not found
```

## Important Code

```java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException(
            RuntimeException exception) {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }
}
```

## Error Faced

### Error Message

```text
Student not found
```

### Error ka Reason

Jo student ID request me bheji gayi thi,
us ID ka student database me nahi mila.

### Pehle kaise handle kar rahe the?

Pehle controller ke andar hi check kar rahe the:

```java
if (student == null) {
    return ResponseEntity.notFound().build();
}
```

Lekin ye approach har method ke liye repeat karni padti thi.

### Ab kaise solve kiya?

- Ek `GlobalExceptionHandler` class banayi.
- Usme `@RestControllerAdvice` lagaya.
- Exception handle karne ke liye `@ExceptionHandler` use kiya.
- Ab controller me baar-baar exception handling likhne ki zaroorat nahi hai.

## Application ka Simple Flow

```text
Student nahi mila
        |
        v
Exception throw hogi
        |
        v
GlobalExceptionHandler
        |
        v
404 Not Found
        |
        v
Client ko error message
```

## API Testing

Request:

```text
GET http://localhost:8080/api/students?id=999
```

Expected response:

```text
404 Not Found
```

Response body:

```text
Student not found
```

## Important Commands

```bash
mvn spring-boot:run
```

Application run karne ke liye.

```bash
mvn test
```

Test run karne ke liye.

```bash
mvn clean install
```

Project ko clean karke build karne ke liye.

## Default Port

Spring Boot ka default port:

```text
8080
```

Application URL:

```text
http://localhost:8080
```

## Important Learning

- Har controller me exception handle karna sahi approach nahi hai.
- Isse controller bulky ho jata hai.
- Global Exception Handler exception ko ek hi place par handle karta hai.
- `@RestControllerAdvice` global handler banane ke liye use hota hai.
- `@ExceptionHandler` specific exception handle karta hai.
- `ResponseEntity` status aur body return karne ke liye use hota hai.
- `404` tab return hota hai jab requested student nahi milta.
- `500` server ke unexpected error ke liye hota hai.
- Controller me request handling honi chahiye.
- Service me business logic honi chahiye.
- Exception handling ke liye separate global handler hona chahiye.

## Revision Questions

1. Controller ke andar exception handle karne se kya problem hoti hai?
2. Global Exception Handling kya hoti hai?
3. `@RestControllerAdvice` ka use kyu karte hain?
4. `@ExceptionHandler` kya karta hai?
5. `ResponseEntity` ka use kya hai?
6. `404 Not Found` kab aata hai?
7. `500 Internal Server Error` kab aata hai?
8. Exception handling ko separate class me rakhna better kyu hai?

## Day 06 ka Summary

Aaj maine samjha ki agar hum controller ke andar hi exception handle karte rahenge,
to controller ka code bulky ho jayega.

Is problem ko solve karne ke liye humne Global Exception Handling ka concept seekha.
`@RestControllerAdvice` aur `@ExceptionHandler` ki help se exceptions ko ek common
class me handle kar sakte hain.

Aaj maine HTTP status codes aur `ResponseEntity` ka use bhi samjha.

## Next Topic

- `ResourceNotFoundException`
- Custom exception banana
- Student nahi milne par exception throw karna
- Global handler se `404 Not Found` response dena


# Day 07 - Spring Boot Exception HAndling Continue...
## Date

## Aaj ka Objective
- Aaj acche se implement karna h exception handling ko run karna h proper 
- 
- 
## Aaj maine kya seekha?
- ek Resource Not found Exception class bnaya phirr extend kiya run time exception se
- super :- Immediate Parent class ko call karna 
- this :- jis class me h use call karn a
- 
- 
-
## Building Error Message Format
-    timeStamp;
-   statusCode;
-   error;
-  message;
- path;

### Using ExeptionDto

-to hum global Exception me Class String Na rakh ke Exception Dto rakhenge taake siple String Output na bhejna pade;


## Important Concepts
Format Of Error given by Global Exception Handing flow
|Error  | Meaning |
|---|---|
|  |  |
|  |  |
## Important Code
```java
package in.bean.day06springbootexceptionhandling.globalexceptionhandler;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message){
        super(message);
    }
}
```
```java



````
## Application Flow
```text
Client
  ↓
Controller
  ↓
Service
  ↓
Repository
  ↓
Database
```
## Error Faced
### Error-1
```text
Postman Showing this When I Run Application

{
    "id": null,
    "name": null,
    "subject": null,
    "age": 0,
    "rollNo": 0,
    "email": null,
    "createdAt": null,
    "updatedAt": null,
    "message": "Saved Successfully"
}
```
### Reason
```java
public static ResponseDto toDto(Student student,String message){

       ResponseDto dto = toDto(student);
       // ResponseDto dto = new Responsedto(); -> error

       dto.setMessage(message);
       return dto;

    }
```

### Solution
- bass line replace kiya new Response entity create nhi karni h bass inputted student ko dto me convert karenge

### Error2
- Response Message Harr bArr null aa raha tha jab Get call kare tbb noramlly;
- fix:- ToDto method me Error message ko by default set karr diya;
- isse update or create ke samay wale messages me koi problem nhi hogi



## Testing
```text
[API URL ya command]
```
## Revision Questions
1.
2.
3.
## Important Annotation
- @RestControllerAdvice :- Yeh ek helper class h controller ki
- @ExceptionHandler(---.class):- konsi class handle karna h  
-
-
## Day 08 Summary
Aaj maine [topic] seekha aur [feature] implement kiya.
---
