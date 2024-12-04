package com.ei.security.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;
/**
 * @author yitiansong
 */
@Component
public class JWTAuthenticationFilter implements Filter {
    // 验证提供者 进行验证
    private final AuthenticationProvider authenticationProvider;
    //
    private final static String BEARER = "Bearer ";
    // dependency using constructor
    @Autowired
    public JWTAuthenticationFilter(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String token = httpRequest.getHeader("Authorization");

        if (token != null && token.startsWith(BEARER)) {
            token = token.substring(7);
            // 根据token生成authentication
            Authentication authentication = new UsernamePasswordAuthenticationToken(token, null);
            Authentication authenticate = authenticationProvider.authenticate(authentication);
            // 设置上下文
            SecurityContextHolder.getContext().setAuthentication(authenticate);
        }

        chain.doFilter(request, response);
    }
}
