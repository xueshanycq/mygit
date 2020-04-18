package com.chuncan.service.impl;

import com.chuncan.mapper.system.RoleJoinPermissionMapper;
import com.chuncan.model.RoleJoinPermissionDO;
import com.chuncan.service.RoleJoinPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: xuesh
 * @Date: 2020/04/17 22:51
 */
@Service
public class RoleJoinPermissionServiceImpl implements RoleJoinPermissionService {

    @Autowired(required = false)
    private RoleJoinPermissionMapper roleJoinPermissionMapper;

    @Override
    public List<RoleJoinPermissionDO> selectRoleJoinPermission(RoleJoinPermissionDO roleJoinPermissionDO) {
        return roleJoinPermissionMapper.select(roleJoinPermissionDO);
    }

    @Override
    public Boolean deleteRoleJoinPermissionByRoleId(String roleId) {
        return roleJoinPermissionMapper.deleteRoleJoinPermissionByRoleId(roleId) > 0;
    }


}
