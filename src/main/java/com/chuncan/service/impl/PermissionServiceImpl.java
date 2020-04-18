package com.chuncan.service.impl;

import com.chuncan.mapper.system.PermissionMapper;
import com.chuncan.model.PermissionDO;
import com.chuncan.service.PermissionService;
import com.chuncan.utils.ModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: xuesh
 * @Date: 2020/04/17 9:01
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired(required = false)
    private PermissionMapper permissionMapper;

    /**
     * 根据权限id查询对应的权限信息
     *
     * @param permissionId
     * @return
     */
    @Override
    public PermissionDO getPermissionById(String permissionId) {
        return permissionMapper.selectByPrimaryKey(permissionId);
    }

    /**
     * 查询所有权限的信息
     *
     * @return
     */
    @Override
    public List<PermissionDO> listPermission() {
        return permissionMapper.selectAll();
    }

    /**
     * 新增权限接口
     *
     * @param permissionDO
     * @return
     */
    @Override
    public boolean insertPermission(PermissionDO permissionDO) {

        ModelUtils.makeupSaveParam(permissionDO);
        return permissionMapper.insertSelective(permissionDO) > 0;
    }

    /**
     * 删除权限接口
     *
     * @param permissionId
     * @return
     */
    @Override
    public boolean deletePermission(String permissionId) {
        return permissionMapper.deleteByPrimaryKey(permissionId) > 0;
    }

    /**
     * 修改权限接口
     *
     * @param permissionDO
     * @return
     */
    @Override
    public boolean updatePermission(PermissionDO permissionDO) {

        ModelUtils.makeupUpdateParam(permissionDO);

        return permissionMapper.updateByPrimaryKeySelective(permissionDO) > 0;
    }
}
