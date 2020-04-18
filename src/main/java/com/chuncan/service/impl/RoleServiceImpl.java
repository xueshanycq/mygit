package com.chuncan.service.impl;

import com.chuncan.mapper.system.RoleMapper;
import com.chuncan.model.PermissionDO;
import com.chuncan.model.RoleDO;
import com.chuncan.model.RoleJoinPermissionDO;
import com.chuncan.service.PermissionService;
import com.chuncan.service.RoleJoinPermissionService;
import com.chuncan.service.RoleService;
import com.chuncan.utils.ModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 角色服务操作接口实现类
 * @author: xuesh
 * @Date: 2020/04/17 2:38
 */

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired(required = false)
    private RoleMapper roleMapper;

    @Autowired
    private RoleJoinPermissionService roleJoinPermissionService;

    @Autowired
    private PermissionService permissionService;


    /**
     * 根据角色id查询对应的角色信息
     *
     * @param roleId
     * @return
     */
    @Override
    public RoleDO getRoleById(String roleId) {

        //根据角色id查询角色信息
       RoleDO roleDO = roleMapper.selectByPrimaryKey(roleId);

       roleDO.setPermissions(new ArrayList<>());

        //2.如果该角色存在，就继续查该角色关联的权限信息
        if (roleDO != null) {
            //创建角色关联权限的实体对象用于存放查询条件
            RoleJoinPermissionDO roleJoinPermissionDO = new RoleJoinPermissionDO();
            //放入角色id
            roleJoinPermissionDO.setRoleId(roleId);
            //3.先根据roleId查到角色权限关联对象
            List<RoleJoinPermissionDO> roleJoinPermissionDOList =
                    roleJoinPermissionService.selectRoleJoinPermission(roleJoinPermissionDO);

            //4.遍历查询到的角色权限关联对象,取得permissionId查到权限对象并添加到角色对象的permissions中
            for (RoleJoinPermissionDO joinPermissionDO : roleJoinPermissionDOList) {
                String permissionId = joinPermissionDO.getPermissionId();
                PermissionDO permissionDO = permissionService.getPermissionById(permissionId);
                roleDO.getPermissions().add(permissionDO);
            }

        }
        return roleDO;
    }

    /**
     * 查询所有角色的信息
     *
     * @return
     */
    @Override
    public List<RoleDO> listRole() {
        return roleMapper.selectAll();
    }

    /**
     * 新增角色接口
     *
     * @param roleDO
     * @return
     */
    @Override
    public boolean insertRole(RoleDO roleDO) {

        ModelUtils.makeupSaveParam(roleDO);
        return roleMapper.insertSelective(roleDO) > 0;
    }

    /**
     * 删除角色接口
     *
     * @param roleId
     * @return
     */
    @Override
    @Transactional
    public boolean deleteRole(String roleId) {

        Boolean result = roleJoinPermissionService.deleteRoleJoinPermissionByRoleId(roleId);

        if (result){
            return roleMapper.deleteByPrimaryKey(roleId) > 0;
        }
        return false;
    }

    /**
     * 修改角色接口
     *
     * @param roleDO
     * @return
     */
    @Override
    public boolean updateRole(RoleDO roleDO) {

        ModelUtils.makeupUpdateParam(roleDO);

        return roleMapper.updateByPrimaryKeySelective(roleDO) > 0;
    }
}
