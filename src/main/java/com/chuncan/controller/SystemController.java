package com.chuncan.controller;

import com.chuncan.model.UserDO;
import com.chuncan.service.UserService;
import com.chuncan.utils.Message;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 用户登录控制器
 * @author: xuesh
 * @Date: 2020/04/11 10:26
 */
@Api(description = "系统操作控制器")
@RestController
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private UserService userService;

    @ApiOperation("登录方法")
    @GetMapping("/login")
    public Message login(String userName, String password) {

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password);

        try {
            subject.login(usernamePasswordToken);
        } catch (AuthenticationException e) {
            return new Message(e.getMessage(), 500);
        }
        return new Message("登录成功", 200);
    }

    @ApiOperation("测试用户是否登录")
    @GetMapping("/checkLoginUser")
    public String checkLoginUser(){
        Subject subject = SecurityUtils.getSubject();
        if (subject != null && subject.getPrincipal() != null){
            return subject.getPrincipal().toString();
        }

        return "还没有用户登录";
    }
}

//        int code = userService.login(userName,password);
//        if(code == 200){
//            return new Message("登录成功",200);
//        }else if (code == 4001){
//            return new Message("用户名不存在",4001);
//        }else if (code == 4002){
//            return new Message("用户名或密码不正确",4002);
//        }
//
//        return new Message("系统异常",500);
//    }
//}
