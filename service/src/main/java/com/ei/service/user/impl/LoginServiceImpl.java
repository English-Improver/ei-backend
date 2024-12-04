package com.ei.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ei.mapper.user.EIUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pojo.model.user.EIUserDO;

/**
 * @author yitiansong
 * 登录服务
 */
@Service
public class LoginServiceImpl implements com.ei.service.user.LoginService{
    private final EIUserMapper eiUserMapper;
    private final PasswordEncoder passwordEncoder;
    // 构造其注入eiUserMapper
    @Autowired
    public LoginServiceImpl(EIUserMapper eiUserMapper, PasswordEncoder passwordEncoder) {
        this.eiUserMapper = eiUserMapper;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 通过username查询数据库，将password加密后与数据库中的password比较
     * @param username 用户输入的用户名
     * @param tryPassword 用户输入的密码
     * @return 账号密码是否匹配
     */
    @Override
    public boolean login(String username, String tryPassword) {
        // 通过username查询数据库
        QueryWrapper<EIUserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        EIUserDO eiUserDO = eiUserMapper.selectOne(queryWrapper);
        // 如果查询结果为空，返回false
        if (eiUserDO == null) {
            return false;
        }
        // 获取数据库中的password
        String password = eiUserDO.getPassword();
        // 将password加密后与数据库中的password比较
        return passwordEncoder.matches(tryPassword, password);
    }
}
