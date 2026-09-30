# Day 08 - Filter Chain
## Date
28-09-2026
## Aaj ka Objective
- Filters In spring boot
## Aaj maine kya seekha?
- ### Why Filter? ###
- iski jarurat cross-cutting concerns(aise common kaam jo lagbhag harr incoming req or
- outgoing response me ) ko centralise karne ke liye
- BASICALLY :- Application Gateway!
- ### Uses of Filters ###
1. Logging Req/ Response
2. Security Check(Authentication)
3. Req/Response modify
4.  Encoding(UTF-8)
## Filters Mainly Servelet se aaye h unka kaam wahi sambhalta h parrr spring boot use karta h aache se ; ##
## Important Concepts
1. Logging Purposes
2. Authentication
3. RequestId (new ReqId --> ReqId response)
4. Request time
5. Error Response to Client

## Important Code
```java
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain)
            throws IOException, ServletException {

        System.out.println("Request entered in Logging filter");

        filterChain.doFilter(request,response);
    }
}
```
## Filter Flow
```text
Client
  ↓
filters(Filter1,Filter2,Filter3)
  |
  v
Controller
  ↓
Service
  ↓
Repository
  ↓
Database
```
## Important Annotaion ##
1. @Order(n) -> To Tell Spring boot which of the filter chain executated when;




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
Aaj maine Filter ke baare  seekha aur implement kiya.
___  
