package com.ladalee.ladalee.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Order(2)  // Lower runs earlier; this runs after AppConfig filter
@Component
public class ComponentLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("🔵 ComponentFilter BEFORE: " + req.getRequestURI());

        chain.doFilter(request, response);

        System.out.println("🔵 ComponentFilter AFTER: " + req.getRequestURI());
    }
}
