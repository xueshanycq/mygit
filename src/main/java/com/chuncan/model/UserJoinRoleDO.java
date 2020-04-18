package com.chuncan.model;

import com.chuncan.model.base.BaseDO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @description:
 * @author: xuesh
 * @Date: 2020/04/17 19:36
 */
@Data
@Table(name = "tb_user_role")
public class UserJoinRoleDO extends BaseDO {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "role_id")
    private String roleId;
}
