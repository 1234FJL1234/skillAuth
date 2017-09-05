package edu.njrs.manager.bean;

import java.util.Date;

/**
 * 权限页面关系表
 */
public class AuthorityPage {
    /**
     * 权限页面ID
     */
    private Long id;
    /**
     * 权限ID
     */
    private Long authorityId;
    /**
     * 页面ID
     */
    private Long pageId;
    /**
     * 权限页面关系创建时间
     */
    private Date createTime;
    /**
     * 权限页面修改时间
     */
    private Date modTime;
    /**
     * 权限页面标记状态
     */
    private String flag;

    /**
     * 获取<code>AuthorityPage</code> createTime
     * 
     * @return createTime
     */
    public Date getCreateTime() {
        if (this.createTime != null) {
            return new Date(this.createTime.getTime());
        }
        return null;
    }

    /**
     * 设置<code>AuthorityPage</code> createTime
     * 
     * @param createTime
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
     * 获取<code>AuthorityPage</code> modTime
     *
     */
    public Date getModTime() {
        if (this.modTime != null) {
            return new Date(this.modTime.getTime());
        }
        return null;
    }

    /**
     * 设置<code>AuthorityPage</code> modTime
     * 
     * @param modTime
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
