# Day 02 - Spring Boot CRUD(EXception HAndling)



## Aaj maine kya seekha?

- Abhi controller hi Exception Handle karr raha jo hume nhi karna h 
  iss controoller bulky ho jata h.
- Flow Exceptoion Handler
  |Client| --> |Controller| --> |Service| --> |Repository|
                                    |
                                    | Error Found
                                    |
                              |Exception Handler|







- SpringBoot Exception handle bhot generic karta h 
- to hum customizably handle kare taaki or ache se error handle karenge 
 
- 
- {HTTPS STATUS CODE}
1xx :Informational
2xx :Successful(201,200,204 etc)
3xx :Redirection(301,302etc)
4xx :Client Side Error(400,404,409 etc)
5xx :Server Side (500)

**Most Used**
200 ok
201 created
204 No content
400 Bad request
404 Response not Found
409 conflict
500 Internal Server Error

ResponseEntity = body+status
               = body+status+headers
               = status









## Important Annotation
@RestControllerAdvice :- COntroller ki helper classes
@ControllerAdvice  
@ExceptionHandler(RuntimeException.class) --> btata h ki koi method exception handler h






## Important Commands


## Default Port

```

## Error Faced


#### Error Message



#### Error ka Meaning



#### Error ka Possible Reason



## Error ka Solution


```

## Configuration File


## Important Learning

