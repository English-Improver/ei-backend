package com.ei.service.user;

import pojo.model.user.*;

import java.util.List;

/**
 * 用户服务接口
 * @author yitiansong
 */
public interface EIUserService {
    /**
     * 根据用户名查找用户
     * @param username 用户名
     * @return {link EIUserDO}
     */
    EIUserDO selectUserByUserName(String username);

    /**
     * 根据用户id查找角色id
     * @param uid 用户id
     * @return 角色id
     */
    List<EIUserRole> selectUserRolesByUserId(Integer uid);

    /**
     * 根据角色id查找权限
     * @param roleIds 角色ids
     * @return 权限id
     */
    List<EIRoleRight> selectRoleRightByRoleIds(List<Integer> roleIds);

    /**
     * 根据权限ids查找对应的权限
     * @param rightIds 权限ids
     * @return 权限列表
     */
    List<EIRight> selectRightByIds(List<Integer> rightIds);

    /**
     * 根据username查找用户权限
     */
    List<EIRight> selectUserRightsByUserName(String username);

    /**
     * 根据username查找用户角色
     */
    List<EIRole> selectRolesByUserName(String username);

    /**
     * 根据角色id查找角色
     * @param ids   角色ids
     * @return 角色列表
     */
    List<EIRole> selectRoleByIds(Integer[] ids);

    /**
     * 根据用户名查找用户id
     * @param username 用户名
     * @return 用户id
     */
    Integer selectUserIdByUserName(String username);
}
