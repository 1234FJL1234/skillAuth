package edu.njrs.manager.service;


import edu.njrs.manager.bean.Manager;
import edu.njrs.manager.bean.MenuVo;

import java.util.List;

/**
 * 菜单格式处理接口
 * 
 * @author IShopTeam
 * @since 2013年11月21日下午3:42:28
 */
public interface MenuServiceInterface {
    /**
     * 菜单显示格式化
     * 
     * @param pageList
     * @see List {@link List} <code>Page</code>
     * @see com.kldaby.manager.bean.Page {@link com.kldaby.manager.bean.Page}
     * @return @see com.kldaby.manager.bean.valueBean.MenuVo
     *         {@link com.kldaby.manager.bean.valueBean.Menvo}
     */
  /*  MenuVo getMenuList(List<Page> pageList);*/

    /**
     * 根据管理员权限显示菜单
     * 
     */
    List<MenuVo> getMenuLists(Manager manager);
    /**
     * 根据管理员ID 从管理员权限关系表中获取到权限ID 根据权限ID在权限页面表中查找到对应的页面集合父,递归权限菜单
     * @param attribute
     * @return List<MenuVo>
     */
    List<MenuVo> getAllMenuByLogin(Long attribute);
}
