package com.saugat.bootcamp.controller;

import com.saugat.bootcamp.utils.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtTokenValidatorFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if(authHeader != null && authHeader.startsWith("Bearer ")){
            System.out.println("Auth Token: "+ authHeader);

            String subjectName = JwtUtils.extractSubject(authHeader.substring(7));
            List<String> roles = JwtUtils.extractRole(authHeader.substring(7));
            System.out.println(subjectName + "\n" + roles);

            filterChain.doFilter(request, response);
        }
    }
}
