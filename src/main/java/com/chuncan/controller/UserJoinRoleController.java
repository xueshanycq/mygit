package com.chuncan.controller;

import com.chuncan.model.UserDO;
import com.chuncan.service.UserJoinRoleService;
import com.chuncan.utils.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description: 用户关联角色控制器
 * @author: xuesh
 * @Date: 2020/04/17 11:10
 */

@Api(description = "用户关联角色控制器")
@RestController("/UserJoinRoleController")
public class UserJoinRoleController {

    @Autowired
    private UserJoinRoleService userJoinRoleService;

    /**
     * 添加用户关联角色的信息
     * @param userId
     * @param roleId
     * @return
     */
    @PostMapping("/userJoinRole")
    public Message saveUserJoinRole(String userId,String roleId){

        if (!userJoinRoleService.insertUserJoinRole(userId,roleId)) {
            return new Message("新增失败", 500);
        }
        return new Message("新增成功", 200);
    }

    /**
     * 暂时没使用
     * @param userId
     * @return
     */
    @GetMapping("/findUserJoinRole")
    public UserDO findUserJoinRole(String userId){

        return userJoinRoleService.selectUserJoinRole(userId);
    }
}
