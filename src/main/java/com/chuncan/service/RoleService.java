package com.chuncan.service;

import com.chuncan.model.RoleDO;

import java.util.List;

/**
 * @description: 角色服务操作接口
 * @author: xuesh
 * @Date: 2020/04/17 2:32
 */
public interface RoleService {

    /**
     * 根据角色id查询对应的角色信息
     * @param id
     * @return
     */
    RoleDO getRoleById(String id);

    /**
     * 查询所有角色的信息
     * @return
     */
    List<RoleDO> listRole();

    /**
     * 新增角色接口
     * @param roleDO
     * @return
     */
    boolean insertRole(RoleDO roleDO);

    /**
     * 删除角色接口
     * @param id
     * @return
     */
    boolean deleteRole(String id);

    /**
     * 修改角色接口
     * @param roleDO
     * @return
     */
    boolean updateRole(RoleDO roleDO);
}
