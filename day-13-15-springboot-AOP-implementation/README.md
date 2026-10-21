# Day 13-14- - AOP Implementation
## Date
10-10-2026
## Aaj ka Objective
AOP implement KArna seekhna 
Kaise internallly kaam karta h 
## Aaj maine kya seekha?
### AOP Uses
- WHEN
- 

### Types Of Advices
- @Before- method execute hone se pahle
- @After- humesa execute
- @AfterReturning- agar exception nhi aai
- @AfterThrowing- agar exception aai
- @Around- pure 

- JoinPoint Class--
-
## Important Concepts
| Concept | Meaning |
|---|---|
|  |  |
|  |  |
## Important Code
```java
@Around("execution(* com.example.service.*.*(..))")
public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
    // @Before logic
    beforeLogic();

    try {
        // Target method execution
        Object result = pjp.proceed();

        // @AfterReturning logic
        afterReturningLogic(result);
        return result;

    } catch (Throwable ex) {
        // @AfterThrowing logic
        afterThrowingLogic(ex);
        throw ex;

    } finally {
        // @After (finally) logic
        afterLogic();
    }
}

```
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
### Error
```text
[Exact error message]
```
### Reason
[Error kyu aaya]
### Solution
[Error kaise solve kiya]

## Day 08 Summary
Aaj maine filters seekha aur  implement kiya.
---