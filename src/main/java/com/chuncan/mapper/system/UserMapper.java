package com.chuncan.mapper.system;

import com.chuncan.mapper.base.BaseMapper;
import com.chuncan.model.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户信息数据库操作接口
 * @description:
 * @author: xuesh
 * @Date: 2020/04/10 11:33
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

}
