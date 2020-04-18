package com.chuncan.service;

import com.chuncan.model.RoleJoinPermissionDO;

import java.util.List;

/**
 * @description:
 * @author: xuesh
 * @Date: 2020/04/17 22:42
 */
public interface RoleJoinPermissionService {

    List<RoleJoinPermissionDO> selectRoleJoinPermission(RoleJoinPermissionDO roleJoinPermissionDO);

    Boolean deleteRoleJoinPermissionByRoleId(String roleId);

}
