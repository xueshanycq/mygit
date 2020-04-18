package com.chuncan.mapper.system;

import com.chuncan.mapper.base.BaseMapper;
import com.chuncan.model.RoleJoinPermissionDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 角色权限关联表数据库操作接口
 * @author: xuesh
 * @Date: 2020/04/17 22:32
 */
@Mapper
public interface RoleJoinPermissionMapper extends BaseMapper<RoleJoinPermissionDO> {
    /**
     * 根据角色Id删除角色权限关联表信息
     * @param roleId
     * @return
     */
    int deleteRoleJoinPermissionByRoleId(String roleId);
}
