package edu.njrs.bean;

import lombok.Data;

/**
 * 用户类
 * Created by Administrator on 2017/9/1.
 */
@Data
public class User {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 登录KEY
     */
    private String loginKey;
    /**
     * 盐值,用于加密密码
     */
    private String saltVal;
    /**
     * 账户类型
     */
    private String accountType;
    /**
     * 删除标记
     */
    private String delFlag;
    /**
     * 登录ip
     */
    private String loginIp;
    /**
     * 登录时间
     */
    private String loginTime;
    /**
     * 创建时间
     */
    private String createTime;


}
