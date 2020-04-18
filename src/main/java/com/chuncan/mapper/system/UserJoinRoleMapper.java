package com.chuncan.mapper.system;

import com.chuncan.mapper.base.BaseMapper;
import com.chuncan.model.UserJoinRoleDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @description: 自定义用户角色关联表数据库操作接口
 * @author: xuesh
 * @Date: 2020/04/17 11:47
 */
@Mapper
public interface UserJoinRoleMapper extends BaseMapper<UserJoinRoleDO> {

    /**
     * 新增用户关联角色信息
     * @param userId
     * @param roleId
     * @return
     */
    int insertUserJoinRole(String userId, String roleId);

//    未创建UserJoinRoleDO之前，用Map封装时与UserJoinRoleMapper.xml映射的方法
//    List<Map<String,Object>> selectJoinByUserId(String userId);

    /**
     * 自定义根据用户id删除用户角色关联表信息
     * @param userId
     * @return
     */
    int deleteUserJoinRoleByUserId(String userId);
}
