package com.chuncan.service.impl;

import com.chuncan.mapper.system.UserJoinRoleMapper;
import com.chuncan.model.RoleDO;
import com.chuncan.model.UserDO;
import com.chuncan.model.UserJoinRoleDO;
import com.chuncan.service.RoleService;
import com.chuncan.service.UserJoinRoleService;
import com.chuncan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 用户关联角色服务接口实现类
 * @author: xuesh
 * @Date: 2020/04/17 11:41
 */
@Service
public class UserJoinRoleServiceImpl implements UserJoinRoleService {

    @Autowired(required = false)
    private UserJoinRoleMapper userJoinRoleMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    /**
     * 用户关联角色新增方法
     * @param userId
     * @param roleId
     * @return
     */
    @Override
    public boolean insertUserJoinRole(String userId, String roleId) {
        return userJoinRoleMapper.insertUserJoinRole(userId,roleId) > 0;
    }

    /**
     * 用户关联角色查询方法
     * @param userId
     * @return
     */
    @Override
    public UserDO selectUserJoinRole(String userId) {

       return null;
    }

    /**
     * 根据用户id删除用户关联角色表信息
     * @param userId
     * @return
     */

    @Override
    public Boolean deleteUserJoinRoleByUserId(String userId) {

        return  userJoinRoleMapper.deleteUserJoinRoleByUserId(userId)>0;

    }

    /**
     * 在userJoinRoleDO对象中设置了查询条件（userId）
     * @param userJoinRoleDO
     * @return
     */
    @Override
    public List<UserJoinRoleDO> selectUserJoinRoleDO(UserJoinRoleDO userJoinRoleDO) {
        return userJoinRoleMapper.select(userJoinRoleDO);
    }
}
