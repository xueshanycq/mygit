package com.chuncan.service;

import com.chuncan.model.UserDO;
import com.chuncan.model.UserJoinRoleDO;

import java.util.List;
import java.util.Map;

/**
 * @description: 用户关联角色服务接口
 * @author: xuesh
 * @Date: 2020/04/17 11:18
 */
public interface UserJoinRoleService {

    /**
     * 用户关联角色新增方法
     * @param userId
     * @param roleId
     * @return
     */
    boolean insertUserJoinRole(String userId,String roleId);

    /**
     * 用户关联角色查询方法
     * @param userId
     * @return
     */
    UserDO selectUserJoinRole(String userId);



    /**
     * 用户角色关联表删除信息方法
     * @param userId
     * @return
     */
    Boolean deleteUserJoinRoleByUserId(String userId);

    List<UserJoinRoleDO> selectUserJoinRoleDO(UserJoinRoleDO userJoinRoleDO);
}
