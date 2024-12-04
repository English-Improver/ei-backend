package com.ei.service.user;

/**
 * @author yitiansong
 */
public interface LoginService {
    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 是否登录成功
     */
    boolean login(String username, String password);
}
