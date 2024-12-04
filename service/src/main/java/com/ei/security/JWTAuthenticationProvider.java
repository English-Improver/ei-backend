package com.ei.security;

import com.ei.service.redis.RedisServiceForString;
import com.ei.util.JWTUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import static com.ei.constant.RedisKey.TOKEN;

/**
 * @author yitiansong
 */
@Component
public class JWTAuthenticationProvider implements AuthenticationProvider {


    private final UserDetailsService userDetailsService;

    private final RedisServiceForString redisServiceForString;

    private final Logger logger = LoggerFactory.getLogger(JWTAuthenticationProvider.class);

    public JWTAuthenticationProvider(UserDetailsService userDetailsService, RedisServiceForString redisServiceForString) {
        this.userDetailsService = userDetailsService;
        this.redisServiceForString = redisServiceForString;
    }

    /**
     * Authenticates the given authentication object.
     *
     * @param authentication the authentication object to be authenticated
     * @return a fully authenticated Authentication object if the given credentials are valid; otherwise null
     * @throws AuthenticationException if authentication fails
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = (String) authentication.getPrincipal();
        // 对token进行校验
        boolean b = JWTUtils.validateToken(token);
        if (!b) {
            return null;
        }
        String username = JWTUtils.getUsernameFromToken(token);
        // 从redis中获取token，检查是否过期
        String cachedToken = redisServiceForString.getValue(TOKEN.getV1() + username);
        if (username != null  && token.equals(cachedToken)) {
            boolean valid = JWTUtils.validateToken(token, username);
            if (valid) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                return new UsernamePasswordAuthenticationToken(username, null, userDetails.getAuthorities());
            }
            logger.error("token校验失败");

        }
        logger.info("用户{}token已过期", username);
        return null;
    }

    /**
     * Checks if the authentication object is supported by this authentication provider.
     * The authentication object is considered supported if it is of type String or a subclass of String.
     *
     * @param authentication the authentication object to be checked
     * @return true if the authentication object is supported, false otherwise
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return String.class.isAssignableFrom(authentication);
    }
}
