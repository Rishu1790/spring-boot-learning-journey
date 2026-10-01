package in.strikes.filterDemo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

//@Component
public class ResponseBodyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpRes = (HttpServletResponse) response;

        ContentCachingResponseWrapper wrapper = new ContentCachingResponseWrapper(httpRes);

        chain.doFilter(request, response);

        byte[] originalRespInRes = wrapper.getContentAsByteArray();

        String originalRes = new String(originalRespInRes);

        String modifyResp =
                """ 
                {
                   "originalResponse" : %S,
                   "appName" : "Student Management System"
                   
                }
                """.formatted(originalRes);


        wrapper.resetBuffer();
        wrapper.getWriter().write(modifyResp
        );

        wrapper.copyBodyToResponse();







    }
}
