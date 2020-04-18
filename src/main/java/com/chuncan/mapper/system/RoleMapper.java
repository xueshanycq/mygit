package com.chuncan.mapper.system;

import com.chuncan.mapper.base.BaseMapper;
import com.chuncan.model.RoleDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 角色数据库操作接口
 * @author: xuesh
 * @Date: 2020/04/17 2:43
 */

@Mapper
public interface RoleMapper extends BaseMapper<RoleDO> {
}
