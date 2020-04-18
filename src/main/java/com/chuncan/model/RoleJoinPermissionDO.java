package com.chuncan.model;

import com.chuncan.model.base.BaseDO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @description: 角色权限关联表实体类
 * @author: xuesh
 * @Date: 2020/04/17 22:04
 */

@Data
@Table(name = "tb_role_permission")
public class RoleJoinPermissionDO  extends BaseDO {

    @Column(name = "role_id")
    private String roleId;

    @Column(name = "permission_id")
    private String permissionId;
}
