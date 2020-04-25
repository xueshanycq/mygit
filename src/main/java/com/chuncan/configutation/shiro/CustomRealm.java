package com.chuncan.configutation.shiro;

import com.chuncan.controller.SystemController;
import com.chuncan.model.PermissionDO;
import com.chuncan.model.RoleDO;
import com.chuncan.model.UserDO;
import com.chuncan.service.UserService;
import com.chuncan.utils.ErrorCode;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @description:
 * @author: xuesh
 * @Date: 2020/04/16 16:52
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 给用户授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //1.定义权限信息类用于存储权限信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //2.根据用户名获取该用户的权限信息
        UserDO userDO = userService.getUserByUsername(principalCollection.getPrimaryPrincipal().toString());

        if (userDO != null){

            for (RoleDO role : userDO.getRoles()) {
                info.addRole(role.getRoleName());
                for (PermissionDO permission : role.getPermissions()) {
                    info.addStringPermission(permission.getPermissionName());
                }
            }
        }

        return info;
    }

    /**
     * 验证用户身份
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("----------账号信息校验开始-------------");
        //将认证token转换为用户密码token,方便获取用户输入的用户名和密码
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        String username = token.getUsername();
        String password = new String(token.getPassword());

        int code = userService.login(username,password);
        if (code == ErrorCode.LOGIN_NOT_USERNAME){
           throw new AuthenticationException(ErrorCode.LOGIN_NOT_USERNAME_MESSAGE);
        }else if (code == ErrorCode.LOGIN_ERROR_PASSWORD){
            throw new AuthenticationException(ErrorCode.LOGIN_ERROR_PASSWORD_MESSAGE);
        }

        return new SimpleAuthenticationInfo(token.getPrincipal(),token.getCredentials(),getName());


    }
}
