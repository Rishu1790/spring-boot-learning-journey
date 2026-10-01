# Day 09- - Next Topic
## Date
01-10-2026
## Aaj ka Objective
Filters Ka use Karke Response Me ChherChhar
## Aaj maine kya seekha?
- zyaada tar to code hi kiya h!
- 
-
-
## Important Concepts
| Concept | Meaning |
|---|---|
|  |  |
|  |  |
## Important Code
```java
public class ResponseBodyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        ContentCachingResponseWrapper wrappedResp = new ContentCachingResponseWrapper(httpServletResponse);
        chain.doFilter(request,wrappedResp);

        byte[] responseBodyInByte = wrappedResp.getContentAsByteArray();
        String orignalBody = new String(responseBodyInByte);
        String modifiedBody =
                """
                        
                        {
                           "originalResponse" : %S,
                           "appName" : "Student Management System"
                        
                        }
                        """.formatted(orignalBody);

        wrappedResp.resetBuffer();

        wrappedResp.getWriter().write(modifiedBody);

        wrappedResp.copyBodyToResponse();


    }}
```
## Application Flow
```text
Client
  ↓
Filters
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