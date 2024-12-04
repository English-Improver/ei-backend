package com.ei.config;

import com.ei.security.filter.JWTAuthenticationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author yitiansong
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final String[] roles = {"ADMIN", "USER"};
    private static final String[] SWAGGER_WHITELIST = {
            "/swagger-ui/**",
            "/swagger-resources/**",
            "/v3/api-docs/**",
            "/swagger-resources"
    };

    private static final String[] NO_AUTH_WHITELIST = {
            "/auth/login",
            "/auth/token/validate"
    };
    /**
     * 登录控制
     */
    @Value("${login.auth}")
    private boolean loginAuth;

    private final JWTAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JWTAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
        // 这个方法配置应用程序的安全过滤链。
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 禁用 CSRF（跨站请求伪造）。在无状态的 API 中，我们不需要 CSRF 保护。
                .csrf(AbstractHttpConfigurer::disable)
                // 将会话管理策略设置为无状态，这意味着 Spring Security 不会创建或使用会话。
                .sessionManagement((sessionManagement) ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        if (loginAuth) {
            // 配置应用程序的授权规则。
            http.authorizeHttpRequests(authorizeRequests ->
                            // 允许对 "/login" 和 "/logout" 端点的所有请求,允许swagger相关资源的访问。
                            authorizeRequests.requestMatchers(NO_AUTH_WHITELIST).permitAll()
                                    .requestMatchers(SWAGGER_WHITELIST).permitAll()
                                    // 只允许具有 "NORMAL" 角色的用户请求 "/main/**" 端点。
                                    // 根据登录控制开关，如果为false，则不需要进行身份验证
                                    .requestMatchers("/main/**").hasRole("NORMAL")
                                    // 所有其他请求都需要进行身份验证。
                                    .anyRequest().authenticated())
                    // 在过滤器链中，将 JWTAuthenticationFilter 添加到 UsernamePasswordAuthenticationFilter 之前。
                    .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        } else {
            http.authorizeHttpRequests(authorizeRequests ->
                    authorizeRequests.anyRequest().permitAll());
        }
        // 构建并返回 SecurityFilterChain。
        return http.build();
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public boolean isLoginAuth() {
        return loginAuth;
    }

    public void setLoginAuth(boolean loginAuth) {
        this.loginAuth = loginAuth;
    }
}




