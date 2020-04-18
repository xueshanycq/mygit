package com.chuncan.model.base;

import com.chuncan.enums.DateStateEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @description:公共实体类
 * @author: xuesh
 * @Date: 2020/04/10 15:06
 */
@Data
public class BaseDO {

    //主键
    @Id
    @Column(name = "id")
    private String id;

    //创建时间
    @Column(name = "create_Time")
    private LocalDateTime createTime;

    //修改时间
    @Column(name = "update_Time")
    private LocalDateTime updateTime;

    //创建人
    @Column(name = "create_User")
    private String createUser;

    //修改人
    @Column(name = "update_User")
    private String updateUser;

    //数据状态
    @Column(name = "data_state")
    private DateStateEnum dataState;

}
