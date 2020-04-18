package com.chuncan.service;

import com.chuncan.model.PermissionDO;

import java.util.List;

/**
 * @description: 权限服务操作接口
 * @author: xuesh
 * @Date: 2020/04/17 3:08
 */

public interface PermissionService {
    /**
     * 根据权限id查询对应的权限信息
     * @param permissionId
     * @return
     */
    PermissionDO getPermissionById(String permissionId);

    /**
     * 查询所有权限的信息
     * @return
     */
    List<PermissionDO> listPermission();

    /**
     * 新增权限接口
     * @param permissionDO
     * @return
     */
    boolean insertPermission(PermissionDO permissionDO);

    /**
     * 删除权限接口
     * @param permissionId
     * @return
     */
    boolean deletePermission(String permissionId);

    /**
     * 修改权限接口
     * @param permissionDO
     * @return
     */
    boolean updatePermission(PermissionDO permissionDO);
}
