package edu.njrs.manager.bean;

import lombok.Data;

import java.util.Date;

/**
 * 权限BEAN
 */
@Data
public class Authority {
    /**
     * 权限ID
     */
    private Long id;
    /**
     * 权限名称
     */
    private String designation;
    /**
     * 权限页面描述
     */
    private String characterization;
    /**
     * 创建时间
     *
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modTime;

    private Long createId;

    /**
     * 状态标记
     */
    private String flag;
    // 分页开始的条数
    private int startRowNum;
    // 分页结束的条数
    private int endRowNum;

    /**
     * 获取创建<code>Authority</code>创建时间
     */
    public Date getCreateTime() {
        if (this.createTime != null) {
            return new Date(this.createTime.getTime());
        }
        return null;
    }

    /**
     * 设置创建<code>Authority</code>创建时间
     * 
     * @param createTime
     *
     */
    public void setCreateTime(Date createTime) {
        if (createTime != null) {
            Date tEmp = (Date) createTime.clone();
            if (tEmp != null) {
                this.createTime = tEmp;
            }
        }
    }

    /**
     * 获取<code>Authority</code>修改时间
     *
     */
    public Date getModTime() {
        if (this.modTime != null) {
            return new Date(this.modTime.getTime());
        }
        return null;
    }

    /**
     * 设置<code>Authority</code>修改时间
     * 
     * @param modTime
     *
     */
    public void setModTime(Date modTime) {
        if (modTime != null) {
            Date tEmp = (Date) modTime.clone();
            if (tEmp != null) {
                this.modTime = tEmp;
            }
        }
    }

}
