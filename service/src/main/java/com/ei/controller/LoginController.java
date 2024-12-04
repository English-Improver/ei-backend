package com.ei.controller;


import com.ei.service.redis.RedisServiceForString;
import com.ei.service.user.LoginService;
import com.ei.util.JWTUtils;
import com.ei.util.Operation;
import com.ei.util.Result;
import com.util.EILog;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pojo.dto.user.UserDto;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.ei.constant.RedisKey.TOKEN;

/**
 * @author yitiansong
 */
@RestController
@RequestMapping("/auth")
public class LoginController {
    private final LoginService loginService;

    private final RedisServiceForString redisServiceForString;
    // constructor
    public LoginController(LoginService loginService, RedisServiceForString redisServiceForString) {
        this.loginService = loginService;
        this.redisServiceForString = redisServiceForString;
    }

    /**
     * 登录
     * @param user 用户
     * @return result
     */
    @PostMapping("/login")
    public ResponseEntity<Result> login(@RequestBody UserDto user) {
        EILog.logger.info("输入参数:{}", user);

        String username = user.getUsername();
        String password = user.getPassword();

        // 调用loginService的login方法
        if (!loginService.login(username, password)) {
            // 登陆失败，返回认证失败
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Result.fail("账号或密码错误", Operation.QUERY));
        }
        String token = JWTUtils.generateToken(username);
        // 将token存入redis并设置过期时间3天
        String key = TOKEN.getV1() + username;
        redisServiceForString.setValueWithExpire(key, token,3, TimeUnit.DAYS);

        Map<String, Object> map = Map.of("token", token);
        ResponseEntity<Result> loginResult = ResponseEntity.ok(Result.success("登录成功", Operation.QUERY, map, null));
        EILog.logger.info("登录结果：{}", loginResult);
        return loginResult;
    }

    /**
     * 对token进行校验
     * @param userDto 校验token
     * @return result
     */
    @PostMapping("/token/validate")
    public ResponseEntity<Result> validateToken(@RequestBody UserDto userDto) {
        String username = userDto.getUsername();
        String token = userDto.getToken();
        String tokenInRedis = redisServiceForString.getValue(TOKEN.getV1() + username);
        if (JWTUtils.validateToken(token) && token.equals(tokenInRedis)) {
            return ResponseEntity.ok(Result.success("token有效", Operation.QUERY));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Result.fail("token无效", Operation.QUERY));

        }
    }

}
