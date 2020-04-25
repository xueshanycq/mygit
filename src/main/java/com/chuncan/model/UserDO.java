package com.chuncan.model;

import com.chuncan.enums.UserSexEnum;
import com.chuncan.model.base.BaseDO;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

/**
 * 用户实体类
* @Author: xuesh
* @Date: 2020/4/10 
* @Time: 0:20
*/
@Data
@Table(name="tb_user")
public class UserDO extends BaseDO {

    //用户名
    @Column(name = "username")
    private String username;

    //用户密码
    @Column(name = "password")
    private String password;

    //用户电话
    @Column(name = "phone")
    private String phone;

    //用户邮箱
    @Column(name = "email")
    private String email;

    //用户出生日期
    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    //用户性别
    @Column(name = "sex")
    private UserSexEnum sex;

    private List<RoleDO> roles;

}
