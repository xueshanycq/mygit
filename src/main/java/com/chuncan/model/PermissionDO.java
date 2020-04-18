package com.chuncan.model;

import com.chuncan.model.base.BaseDO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @description: 权限表实体对象
 * @author: xuesh
 * @Date: 2020/04/17 2:23
 */
@Table(name = "tb_permission")
@Data
public class PermissionDO extends BaseDO {

    /**
     * 权限名称
     */
    @Column(name = "permission_name")
    private String permissionName;

    /**
     * 权限描述
     */
    @Column(name = "permission_describe")
    private String permissionDescribe;
}
