package com.chuncan.service;

import com.chuncan.model.UserDO;
import com.chuncan.utils.Message;
import java.util.List;

/**
 * @description: 用户服务操作接口
 * @author: xuesh
 * @Date: 2020/04/10 10:58
 */

public interface UserService {
    /**
     * 根据用户id获取用户信息
     * @param userId
     * @return
     */
    UserDO getUserById(String userId);

    /**
     * 用户登录验证
     * @param username
     * @param password
     * @return
     */
    int login(String username,String password);

    /**
     * 获取用户所有信息
     * @return
     */
    List<UserDO> listUser(UserDO userDO);

    /**
     * 新增用户信息
     * @param userDO
     * @return
     */
    Boolean insertUser(UserDO userDO);

    /**
     * 修改用户信息
     * @param userDO
     * @return
     */
    Boolean updateUser(UserDO userDO);

    /**
     * 删除用户信息
     * @param userId
     * @return
     */
    Boolean deleteUser(String userId);


    UserDO getUserByUsername(String username);
}
