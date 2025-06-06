package com.ladalee.ladalee.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println("🔵 ComponentFilter BEFORE: " + req.getRequestURI());

        chain.doFilter(request, response);

        System.out.println("🔵 ComponentFilter AFTER: " + req.getRequestURI());
    }
};