package com.chuncan.utils;

import com.chuncan.enums.DateStateEnum;
import com.chuncan.model.base.BaseDO;
import tk.mybatis.mapper.util.StringUtil;

import java.time.LocalDateTime;

/**
 *
 * @description: 保存补齐共有必填字段工具类
 * @author: xuesh
 * @Date: 2020/04/10 14:25
 */
public class ModelUtils {

    //补齐新增时共有必填字段
    public static void makeupSaveParam(BaseDO baseDO){

        //判断用户id是否为空，为空则自动生成id
        if (StringUtil.isEmpty(baseDO.getId())){
            baseDO.setId(IdUtils.getRandomIdByUUID());
        }

        //判断创建人是否为空，为空则设置为1或admin账户
        if (StringUtil.isEmpty(baseDO.getCreateUser())){
            baseDO.setCreateUser("1");
        }

        //设置创建时间
        baseDO.setCreateTime(LocalDateTime.now());

        //设置默认数据状态，默认为可用
        baseDO.setDataState(DateStateEnum.AVAILABLE);
    }

    //补齐修改时共有必填字段
    public static void makeupUpdateParam(BaseDO baseDO){

        //判断修改人是否为空，为空则设置为1或admin账户
        if (StringUtil.isEmpty(baseDO.getUpdateUser())){
            baseDO.setUpdateUser("1");

        //设置修改时间
        baseDO.setUpdateTime(LocalDateTime.now());

        }
    }

}
