package com.chuncan.utils;

import lombok.Data;

/**
 * 结果返回工具类
* @Author: xuesh
* @Date: 2020/4/9
* @Time: 23:57
*/

@Data
public class Message {

    //返回消息
    private String message;

    //返回结果码 200成功  500失败
    private int code;

    public Message(String message,int code){
        this.message = message;
        this.code = code;
    }
}
