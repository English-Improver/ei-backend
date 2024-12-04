package com.ei.service.user.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ei.mapper.user.*;
import com.ei.service.user.EIUserService;
import org.springframework.stereotype.Service;
import pojo.model.user.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yitiansong
 * 用户搜索服务
 */
@Service
public class EIUserServiceImpl implements EIUserService {
    private final EIUserMapper eiUserMapper;
    private final EIUserRoleMapper eiUserRoleMapper;
    private final EIRoleMapper eiRoleMapper;
    private final EIRoleRightMapper eiRoleRightMapper;
    private final EIRightMapper eiRightMapper;

    public EIUserServiceImpl(EIUserMapper eiUserMapper, EIUserRoleMapper eiUserRoleMapper, EIRoleMapper eiRoleMapper, EIRoleRightMapper eiRoleRightMapper, EIRightMapper eiRightMapper) {
        this.eiUserMapper = eiUserMapper;
        this.eiUserRoleMapper = eiUserRoleMapper;
        this.eiRoleMapper = eiRoleMapper;
        this.eiRoleRightMapper = eiRoleRightMapper;
        this.eiRightMapper = eiRightMapper;
    }
    @Override
    public EIUserDO selectUserByUserName(String username) {
        QueryWrapper<EIUserDO> query = new QueryWrapper<>();
        // 设置查询参数username
        query.eq("username", username);
        return eiUserMapper.selectOne(query);
    }

    @Override
    public List<EIUserRole> selectUserRolesByUserId(Integer uid) {
        // 创建实体类EIUserRole的queryWrapper对象，范型为EIUserRole，设置查询条件==uid
        QueryWrapper<EIUserRole> query = new QueryWrapper<>();
        query.eq("id", uid);
        return eiUserRoleMapper.selectList(query);
    }

    @Override
    public List<EIRoleRight> selectRoleRightByRoleIds(List<Integer> roleIds) {
        // 创建实体类EIRoleRight的queryWrapper对象，范型为EIRoleRight，设置查询条件roleIds
        QueryWrapper<EIRoleRight> query = new QueryWrapper<>();
        query.in("role_id", roleIds);
        return eiRoleRightMapper.selectList(query);
    }

    @Override
    public List<EIRight> selectRightByIds(List<Integer> rightIds) {
        // 创建实体类EIRight的queryWrapper对象，范型为EIRight，设置查询条件rightIds
        QueryWrapper<EIRight> query = new QueryWrapper<>();
        query.in("id", rightIds);
        return eiRightMapper.selectList(query);
    }

    @Override
    public List<EIRight> selectUserRightsByUserName(String username) {
        // 根据username查找用户
        EIUserDO user = selectUserByUserName(username);
        if (user != null) {
            // 根据用户id查找角色id
            List<EIUserRole> userRoles = selectUserRolesByUserId(user.getId());
            if (userRoles != null && !userRoles.isEmpty()) {
                // 获取角色id
                List<Integer> roleIds = userRoles.stream().map(EIUserRole::getRoleId).collect(Collectors.toList());
                // 根据角色id查找权限
                List<EIRoleRight> roleRights = selectRoleRightByRoleIds(roleIds);
                if (roleRights != null && !roleRights.isEmpty()) {
                    // 获取权限id
                    List<Integer> rightIds = roleRights.stream().map(EIRoleRight::getRightId).collect(Collectors.toList());
                    // 根据权限ids查找对应的权限
                    return selectRightByIds(rightIds);
                }
            }
        }
        return null;
    }

    @Override
    public List<EIRole> selectRolesByUserName(String username) {
        EIUserDO eiUserDO = selectUserByUserName(username);
        List<EIUserRole> eiUserRoles = selectUserRolesByUserId(eiUserDO.getId());
        List<Integer> roleIds = eiUserRoles.stream().map(EIUserRole::getRoleId).toList();
        return selectRoleByIds(roleIds.toArray(new Integer[0]));
    }

    @Override
    public List<EIRole> selectRoleByIds(Integer[] ids) {
        // 创建实体类EIRole的queryWrapper对象，范型为EIRole，设置查询条件ids
        QueryWrapper<EIRole> query = new QueryWrapper<>();
        query.in("id", (Object) ids);
        return eiRoleMapper.selectList(query);
    }

    @Override
    public Integer selectUserIdByUserName(String username) {
        EIUserDO eiUserDO = selectUserByUserName(username);
        return eiUserDO.getId();
    }
}
