package com.ei.config;


import com.ei.service.user.EIUserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pojo.model.user.EIRight;
import pojo.model.user.EIRole;
import pojo.model.user.EIUserDO;

import java.util.List;

/**
 * @author yitiansong
 */
@Service
public class EIUserDetailService implements UserDetailsService {
    private final EIUserService userService;

    public EIUserDetailService(EIUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EIUserDO user = userService.selectUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        List<EIRight> eiRights = userService.selectUserRightsByUserName(username);
        List<EIRole> eiRoles = userService.selectRolesByUserName(username);
        // 遍历eiRole，根据eiRole的name属性封装到eiRight的permission属性中
        List<EIRight> list = eiRoles.stream().map(e -> {
            EIRight eiRight = new EIRight();
            eiRight.setPermission(e.getName());
            return eiRight;
        }).toList();
        eiRights.addAll(list);
        // 将eiRole的name转为EIRight的permission
        return User.withUsername(user.getUsername()).password(user.getPassword()).authorities(eiRights.stream().map(EIRight::getPermission).toArray(String[]::new)).build();
    }

}
