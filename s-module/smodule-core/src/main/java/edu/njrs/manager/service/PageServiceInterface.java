/*


 */

package edu.njrs.manager.service;


import edu.njrs.common.util.PageBean;
import edu.njrs.common.util.SelectBean;
import edu.njrs.manager.bean.MenuVo;
import edu.njrs.manager.bean.Page;

import java.util.List;

/**
 * 菜单Service
 * 
 */
public interface PageServiceInterface {
    /**
     * 保存菜单实体
     * 
     * @param page
     *            菜单实体
     * @return 保存的行数
     */
    int savePage(Page page);

    /**
     * 保存菜单实体(管理third端大区PC端菜单)
     *
     * @param page
     *            菜单实体
     * @return 保存的行数
     */
    int saveRegionalPCPage(Page page);

    /**
     * 关联权限和菜单实体(大区)
     *
     * @param designation
     *            菜单名称
     * @return 保存的行数
     */
    int linkRegionalAuthorityAndPage(String designation);

    /**
     * 关联权限和菜单实体(门店)
     *
     * @param designation
     *            菜单名称
     * @return 保存的行数
     */
    int linkStoreAuthorityAndPage(String designation);

    /**
     * 保存菜单实体(管理third端大区APP端菜单)
     *
     * @param page
     *            菜单实体
     * @return 保存的行数
     */
    int saveRegionalAPPPage(Page page);

    /**
     * 保存菜单实体(管理third端门店PC端菜单)
     *
     * @param page
     *            菜单实体
     * @return 保存的行数
     */
    int saveStorePCPage(Page page);

    /**
     * 保存菜单实体(管理third端门店APP端菜单)
     *
     * @param page
     *            菜单实体
     * @return 保存的行数
     */
    int saveStoreAPPPage(Page page);

    /**
     * 更新菜单
     * 
     * @param page
     *            待更新的菜单实体
     * @return 更新的行行数
     */
    int updatePage(Page page);

    /**
     * 更新菜单(管理third端大区PC端菜单)
     *
     * @param page
     *            待更新的菜单实体
     * @return 更新的行行数
     */
    int updateRegionalPCPage(Page page);

    /**
     * 更新菜单(管理third端大区APP端菜单)
     *
     * @param page
     *            待更新的菜单实体
     * @return 更新的行行数
     */
    int updateRegionalAPPPage(Page page);

    /**
     * 更新菜单(管理third端门店PC端菜单)
     *
     * @param page
     *            待更新的菜单实体
     * @return 更新的行行数
     */
    int updateStorePCPage(Page page);

    /**
     * 更新菜单(管理third端门店APP端菜单)
     *
     * @param page
     *            待更新的菜单实体
     * @return 更新的行行数
     */
    int updateStoreAPPPage(Page page);

    /**
     * 删除菜单实体
     * 
     * @param pageId
     *            待删除的菜单的ID
     * @return 删除的行数
     */
    int delPage(Long pageId);

    /**
     * 删除菜单实体(管理third端大区PC端菜单)
     *
     * @param pageId
     *            待删除的菜单的ID
     * @return 删除的行数
     */
    int delRegionalPCPage(Long pageId);

    /**
     * 删除菜单实体(管理third端大区APP端菜单)
     *
     * @param pageId
     *            待删除的菜单的ID
     * @return 删除的行数
     */
    int delRegionalAPPPage(Long pageId);

    /**
     * 删除菜单实体(管理third端门店PC端菜单)
     *
     * @param pageId
     *            待删除的菜单的ID
     * @return 删除的行数
     */
    int delStorePCPage(Long pageId);

    /**
     * 删除菜单实体(管理third端门店APP端菜单)
     *
     * @param pageId
     *            待删除的菜单的ID
     * @return 删除的行数
     */
    int delStoreAPPPage(Long pageId);

    /**
     * 批量删除Page
     *
     * @param pageIds
     * @return
     */
    int batchDelPage(Long[] pageIds);

    /**
     * 批量删除Page(管理third端大区PC端菜单)
     *
     * @param pageIds
     * @return
     */
    int batchRegionalPCDelPage(Long[] pageIds);

    /**
     * 批量删除Page(管理third端大区APP端菜单)
     *
     * @param pageIds
     * @return
     */
    int batchRegionalAPPDelPage(Long[] pageIds);

    /**
     * 批量删除Page(管理third端门店PC端菜单)
     *
     * @param pageIds
     * @return
     */
    int batchStorePCDelPage(Long[] pageIds);

    /**
     * 批量删除Page(管理third端门店APP端菜单)
     *
     * @param pageIds
     * @return
     */
    int batchStoreAPPDelPage(Long[] pageIds);

    /**
     * 根据主键查询Page实体
     * 
     * @param pageId
     *            主键ID
     * @return 查询到的Page实体
     */
    Page queryPageByPrimaryKey(Long pageId);

    /**
     * 根据主键查询Page实体(管理third端大区PC端菜单)
     *
     * @param pageId
     *            主键ID
     * @return 查询到的Page实体
     */
    Page queryRegionalPCPageByPrimaryKey(Long pageId);

    /**
     * 根据主键查询Page实体(管理third端大区APP端菜单)
     *
     * @param pageId
     *            主键ID
     * @return 查询到的Page实体
     */
    Page queryRegionalAPPPageByPrimaryKey(Long pageId);

    /**
     * 根据主键查询Page实体(管理third端门店PC端菜单)
     *
     * @param pageId
     *            主键ID
     * @return 查询到的Page实体
     */
    Page queryStorePCPageByPrimaryKey(Long pageId);

    /**
     * 根据主键查询Page实体(管理third端门店APP端菜单)
     *
     * @param pageId
     *            主键ID
     * @return 查询到的Page实体
     */
    Page queryStoreAPPPageByPrimaryKey(Long pageId);

    /**
     * 根据分页帮助类查询分页列表
     * 
     * @param pb
     */
    PageBean queryCateListByPageBean(PageBean pb, SelectBean selectBean);

    /**
     * 根据分页帮助类查询third端大区PC端菜单分页列表
     *
     * @param pb
     * @return
     */
    PageBean queryRegionalPCCateListByPageBean(PageBean pb, SelectBean selectBean);

    /**
     * 根据分页帮助类查询third端大区APP端菜单分页列表
     *
     * @param pb
     */
    PageBean queryRegionalAPPCateListByPageBean(PageBean pb, SelectBean selectBean);

    /**
     * 根据分页帮助类查询third端门店PC端菜单分页列表
     *
     * @param pb
     */
    PageBean queryStorePCCateListByPageBean(PageBean pb, SelectBean selectBean);

    /**
     * 根据分页帮助类查询third端门店APP端菜单分页列表
     *
     * @param pb
     */
    PageBean queryStoreAPPCateListByPageBean(PageBean pb, SelectBean selectBean);

    /**
     * 查询所有的菜单
     * 
     * @return 查询到的列表
     */
    List<MenuVo> queryAllMenuVo();

    /**
     * 查询third端大区PC端所有的菜单
     *
     * @return 查询到的列表
     */
    List<MenuVo> queryRegionalPCAllMenuVo();

    /**
     * 查询third端大区APP端所有的菜单
     *
     * @return 查询到的列表
     */
    List<MenuVo> queryRegionalAPPAllMenuVo();

    /**
     * 查询third端门店PC端所有的菜单
     *
     * @return 查询到的列表
     */
    List<MenuVo> queryStorePCAllMenuVo();

    /**
     * 查询third端门店APP端所有的菜单
     *
     * @return 查询到的列表
     */
    List<MenuVo> queryStoreAPPAllMenuVo();

    /**
     * 验证是否可以删除 如果传递过来的分类 下面有子类 就返回false表示不可以删除
     *
     * @return 是否可以删除
     */
    boolean checkDelWithPageId(Long pageId);

    /**
     * 获得分类下的所有的子分类
     * 
     * @param pb
     *            分页辅助类 {@link }
     * @return 整理好的分类列表
     */
    List<Object> getCateList(PageBean pb, SelectBean selectBean);

    /**
     * 获得third端大区PC端分类下的所有的子分类
     *
     * @param pb
     *            分页辅助类
     * @return 整理好的分类列表
     */
    List<Object> getRegionalPCCateList(PageBean pb, SelectBean selectBean);

    /**
     * 获得third端大区APP端分类下的所有的子分类
     *
     * @param pb
     *            分页辅助类
     * @return 整理好的分类列表
     */
    List<Object> getRegionalAPPCateList(PageBean pb, SelectBean selectBean);

    /**
     * 获得third端门店PC端分类下的所有的子分类
     *
     * @param pb
     *            分页辅助类
     * @return 整理好的分类列表
     */
    List<Object> getStorePCCateList(PageBean pb, SelectBean selectBean);

    /**
     * 获得third端门店APP端分类下的所有的子分类
     *
     * @param pb
     *            分页辅助类
     * @return 整理好的分类列表
     */
    List<Object> getStoreAPPCateList(PageBean pb, SelectBean selectBean);

    /**
     * 使用递归根据父分类ID计算所有的自己分类
     * 
     * @param parentId
     *            第一级的父分类ID
     *
     * @return 计算好的分类实体
     */
    List<MenuVo> calcCateVo(Long parentId, List<MenuVo> allmenuVo);

    /**
     * 查询所有的菜单 节点
     * 
     * @return 查询到的列表
     */
    List<MenuVo> queryAllParentMenuVo();

    /**
     * 查询所有的菜单 页面
     * 
     * @return 查询到的列表
     */
    List<MenuVo> queryAllChildrenMenuVo();

    /**
     * 查询当前的登录用户的权限菜单
     * 
     * @param managerId
     * @return List
     */
    List<MenuVo> queryAllParentMenuVoByLogin(Long managerId);

    /**
     * 新Boss删除菜单
     *
     * @param pageId
     * @return int
     */
    int newBatchDelPage(Long pageId);

    /**
     * 新Boss删除菜单(管理third端大区PC端菜单)
     *
     * @param pageId
     * @return int
     */
    int newRegionalPCBatchDelPage(Long pageId);

    /**
     * 新Boss删除菜单(管理third端大区APP端菜单)
     *
     * @param pageId
     * @return int
     */
    int newRegionalAPPBatchDelPage(Long pageId);

    /**
     * 新Boss删除菜单(管理third端门店PC端菜单)
     *
     * @param pageId
     * @return int
     */
    int newStorePCBatchDelPage(Long pageId);

    /**
     * 新Boss删除菜单(管理third端门店APP端菜单)
     *
     * @param pageId
     * @return int
     */
    int newStoreAPPBatchDelPage(Long pageId);

    /**
     * 查询bundleName的菜单
     * @param bundleName 模块配置的bundleName
     * @return 菜单集合 List
     */
    List<MenuVo> queryMenuByBundleName(String bundleName);


    /**
     * 删除bundleName的菜单
     * @param bundleName 模块配置的bundleName
     * @return 菜单集合 List
     */
    void deleteMenuByBundleName(String bundleName);
}
