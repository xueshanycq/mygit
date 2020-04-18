package com.chuncan.model;

import com.chuncan.model.base.BaseDO;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.List;

/**
 * @description: 角色表实体对象
 * @author: xuesh
 * @Date: 2020/04/17 2:12
 */

@Data
@Table(name = "tb_role")
public class RoleDO extends BaseDO {

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色描述
     */
    @Column(name = "role_describe")
    private String roleDescribe;

    List<PermissionDO> permissions;
}
