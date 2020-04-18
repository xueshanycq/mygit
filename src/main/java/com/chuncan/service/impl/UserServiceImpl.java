package com.chuncan.service.impl;

import com.chuncan.mapper.system.UserMapper;
import com.chuncan.model.RoleDO;
import com.chuncan.model.UserDO;
import com.chuncan.model.UserJoinRoleDO;
import com.chuncan.service.RoleService;
import com.chuncan.service.UserJoinRoleService;
import com.chuncan.service.UserService;
import com.chuncan.utils.ModelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户服务接口实现类
 * @description:
 * @author: xuesh
 * @Date: 2020/04/10 11:09
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * 用户信息数据库操作接口
     */
    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired
    private UserJoinRoleService userJoinRoleService;

    @Autowired
    private RoleService roleService;

    /**
     * 根据用户id获取用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public UserDO getUserById(String userId) {
        //1. 根据userId查询UserDO信息
        UserDO userDO = userMapper.selectByPrimaryKey(userId);

        userDO.setRoles(new ArrayList<>());

        //2.如果用户存在，就继续查用户角色信息
        if (userDO != null) {
            //创建用户关联角色实体对象用于存放查询条件
            UserJoinRoleDO userJoinRoleDO = new UserJoinRoleDO();
            //放入用户id
            userJoinRoleDO.setUserId(userId);
            //3.先查询到跟该用户关联的roleId
            List<UserJoinRoleDO> userJoinRoleDOList = userJoinRoleService.selectUserJoinRoleDO(userJoinRoleDO);

            //4.遍历查询到的roleId
            for (UserJoinRoleDO joinRoleDO : userJoinRoleDOList) {

                RoleDO roleDO = roleService.getRoleById(joinRoleDO.getRoleId());
                userDO.getRoles().add(roleDO);
            }
        }
        return userDO;
    }

    /**
     * 用户登录验证
     * @param userName
     * @param password
     * @return
     */
    @Override
    public int login(String userName, String password) {

        UserDO userDO = new UserDO();
        userDO.setUserName(userName);
        userDO = userMapper.selectOne(userDO);

        if(userDO != null){
            if (userDO.getPassword().equals(password)){
                return 200;
            }

            return 4002;
        }

        return 4001;
    }

    /**
     * 获取用户所有信息
     *
     * @return
     */
    @Override
    public List<UserDO> listUser() {
        return userMapper.selectAll();
    }

    /**
     * 新增用户信息
     *
     * @param userDO
     * @return
     */
    @Override
    public Boolean insertUser(UserDO userDO) {

        //补齐新增必填字段
        ModelUtils.makeupSaveParam(userDO);

        return userMapper.insert(userDO) > 0;
    }

    /**
     * 修改用户信息
     *
     * @param userDO
     * @return
     */
    @Override
    public Boolean updateUser(UserDO userDO) {

        //补齐修改必填字段
        ModelUtils.makeupUpdateParam(userDO);

        return userMapper.updateByPrimaryKeySelective(userDO) > 0;
    }

    /**
     * 删除用户信息
     *
     * @param userId
     * @return
     */
    @Override
    @Transactional
    public Boolean deleteUser(String userId) {

       Boolean result = userJoinRoleService.deleteUserJoinRoleByUserId(userId);

        if (result){
        return userMapper.deleteByPrimaryKey(userId) > 0;
       }
       return false;
    }

    @Override
    public UserDO getUserByUserName(String userName) {
        UserDO userDO = new UserDO();
        userDO.setUserName(userName);
        userDO = userMapper.selectOne(userDO);

        if (userDO!=null){
           return getUserById(userDO.getId());
        }
        return null;
    }
}
