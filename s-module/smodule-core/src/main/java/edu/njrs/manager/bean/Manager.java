package edu.njrs.manager.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员Bean
 *
 */
@Data
public class Manager implements Serializable {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = -449909232999422484L;
    /**
     * 管理员ID
     */
    private Long id;
    /**
     * 管理员名称
     */
    private String username;
    /**
     * 管理员密码
     */
    private String userkey;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modTime;
    /**
     * 最后登录时间
     */
    private Date loginTime;
    /**
     * 状态标记
     */
    private String flag;
    // 分页开始的条数
    private int startRowNum;
    // 分页结束的条数
    private int endRowNum;

    // 管理员手机
    private String mobile;
    /**
     * 手机验证码
     */
    private String captcha;
    /**
     * 验证码失效时间
     */
    private Date aeadTime;
    // 管理员头像
    private String photoImg;

    /**
     * 创建者ID
     */
    private Long createId;

}
