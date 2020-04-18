package com.chuncan.controller;

import com.chuncan.model.RoleDO;
import com.chuncan.service.RoleService;
import com.chuncan.utils.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 角色业务控制器
 * @author: xuesh
 * @Date: 2020/04/17 1:58
 */

@RestController
@RequestMapping("/role")
@Api(description = "角色业务控制器")
public class RoleController {

    /**
     * 角色服务操作接口
     */
    @Autowired
    private RoleService roleService;

    @ApiOperation("根据角色id查询对应的角色信息")
    @GetMapping("/findRoleById")
    @RequiresPermissions(value = "role_find")
    public RoleDO findRoleById(String id ){

        return roleService.getRoleById(id);
    }

    @ApiOperation("查询所有角色的信息")
    @GetMapping("/findRoleAll")
    @RequiresPermissions(value = "role_find")
    public List<RoleDO> findRoleAll(){

        return roleService.listRole();
    }

    @ApiOperation("新增角色接口")
    @PostMapping("/saveRole")
    @RequiresPermissions(value = "role_add")
    public Message saveRole(RoleDO roleDO){

        if (!roleService.insertRole(roleDO)) {
            return new Message("新增失败", 500);
        }
        return new Message("新增成功", 200);
    }

    @ApiOperation("删除角色接口")
    @DeleteMapping("/removeRole")
    @RequiresPermissions(value = "role_delete")
    public Message removeRole(String id){

        if (!roleService.deleteRole(id)) {
            return new Message("删除失败", 500);
        }
        return new Message("删除成功",200);
    }

    @ApiOperation("修改角色接口")
    @PostMapping("/editRole")
    @RequiresPermissions(value = "role_update")
    public Message editRole(RoleDO roleDO){

        if (!roleService.updateRole(roleDO)){
            return new Message("修改失败", 500);
        }
        return new Message("修改成功",200);

    }
}
