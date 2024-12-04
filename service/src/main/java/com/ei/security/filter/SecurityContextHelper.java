package com.ei.security.filter;

import com.ei.service.user.EIUserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * @author yitiansong
 * 2024/5/4
 * 获取用户id等信息
 */
@Component
public class SecurityContextHelper {

    private final EIUserService userService;

    public SecurityContextHelper(EIUserService userService) {
        this.userService = userService;
    }

    /**
     * Retrieves the ID of the current user.
     *
     * @return the ID of the current user
     * @throws IllegalStateException if the user principal is not an instance of UserDetails
     */
    public Integer getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            return userService.selectUserIdByUserName(username);
        } else {
            throw new IllegalStateException("User principal is not an instance of UserDetails");
        }
    }
}
