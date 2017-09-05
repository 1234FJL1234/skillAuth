package edu.njrs.manager.mapper;

import edu.njrs.manager.bean.MenuVo;
import edu.njrs.manager.bean.Page;

import java.util.List;
import java.util.Map;

/**
 * 页面Mapper
 * 
 * @author IShopTeam
 */
public interface PageMapper {
    /**
     * 根据ID删除页面信息
     * 
     * @param id
     *            页面ID
     * @return int 1表示成功 0表示失败
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 根据ID删除页面信息(管理third端大区PC端菜单)
     *
     * @param id
     *            页面ID
     * @return int 1表示成功 0表示失败
     */
    int deleteRegionalPCByPrimaryKey(Long id);

    /**
     * 根据ID删除页面信息(管理third端大区APP端菜单)
     *
     * @param id
     *            页面ID
     * @return int 1表示成功 0表示失败
     */
    int deleteRegionalAPPByPrimaryKey(Long id);

    /**
     * 根据ID删除页面信息(管理third端门店PC端菜单)
     *
     * @param id
     *            页面ID
     * @return int 1表示成功 0表示失败
     */
    int deleteStorePCByPrimaryKey(Long id);

    /**
     * 根据ID删除页面信息(管理third端门店APP端菜单)
     *
     * @param id
     *            页面ID
     * @return int 1表示成功 0表示失败
     */
    int deleteStoreAPPByPrimaryKey(Long id);

    /**
     * 插入页面信息
     * 
     * @param record
     *            <code>Page</code>对象
     * @return int 1表示成功 0表示失败
     */
    int insertSelective(Page record);

    /**
     * 插入页面信息(管理third端大区PC端菜单)
     *
     * @param record
     *            <code>Page</code>对象
     * @return int 1表示成功 0表示失败
     */
    int insertRegionalPCSelective(Page record);

    /**
     * 关联权限和菜单实体(大区)
     *
     * @param designation
     *            菜单名称
     * @return int 1表示成功 0表示失败
     */
    int insertRegionalLinkAuthAndPage(String designation);

    /**
     * 关联权限和菜单实体(门店)
     *
     * @param designation
     *            菜单名称
     * @return int 1表示成功 0表示失败
     */
    int insertStoreLinkAuthAndPage(String designation);

    /**
     * 插入页面信息(管理third端大区APP端菜单)
     *
     * @param record
     *            <code>Page</code>对象
     * @return int 1表示成功 0表示失败
     */
    int insertRegionalAPPSelective(Page record);

    /**
     * 插入页面信息(管理third端门店PC端菜单)
     *
     * @param record
     *            <code>Page</code>对象
     * @return int 1表示成功 0表示失败
     */
    int insertStorePCSelective(Page record);

    /**
     * 插入页面信息(管理third端门店APP端菜单)
     *
     * @param record
     *            <code>Page</code>对象
     * @return int 1表示成功 0表示失败
     */
    int insertStoreAPPSelective(Page record);

    /**
     * 根据ID选取页面信息
     * 
     * @param id
     *            页面ID
     * @return <code>Page</code>对象
     */
    Page selectByPrimaryKey(Long id);

    /**
     * 根据ID选取页面信息(管理third端大区PC端菜单)
     *
     * @param id
     *            页面ID
     * @return <code>Page</code>对象
     */
    Page selectRegionalPCByPrimaryKey(Long id);

    /**
     * 根据ID选取页面信息(管理third端大区APP端菜单)
     *
     * @param id
     *            页面ID
     * @return <code>Page</code>对象
     */
    Page selectRegionalAPPByPrimaryKey(Long id);

    /**
     * 根据ID选取页面信息(管理third端门店PC端菜单)
     *
     * @param id
     *            页面ID
     * @return <code>Page</code>对象
     */
    Page selectStorePCByPrimaryKey(Long id);

    /**
     * 根据ID选取页面信息(管理third端门店APP端菜单)
     *
     * @param id
     *            页面ID
     * @return <code>Page</code>对象
     */
    Page selectStoreAPPByPrimaryKey(Long id);

    /**
     * 根据id选取结果
     * */
    List<Long> selectByPrimaryKeys(List<Long> list);

    /**
     * 修改页面信息
     * 
     * @param record
     *            <code>Page</code>对象
     * @return int 1表示成功 0表示失败
     */
    int updateByPrimaryKeySelective(Page record);

    /**
     * 修改页面信息(管理third端大区PC端菜单)
     *
     * @param record
     *            <code>Page</code>对象
     * @return int 1表示成功 0表示失败
     */
    int updateRegionalPCByPrimaryKeySelective(Page record);

    /**
     * 修改页面信息(管理third端大区APP端菜单)
     *
     * @param record
     *            <code>Page</code>对象
     * @return int 1表示成功 0表示失败
     */
    int updateRegionalAPPByPrimaryKeySelective(Page record);

    /**
     * 修改页面信息(管理third端门店PC端菜单)
     *
     * @param record
     *            <code>Page</code>对象
     * @return int 1表示成功 0表示失败
     */
    int updateStorePCByPrimaryKeySelective(Page record);

    /**
     * 修改页面信息(管理third端门店APP端菜单)
     *
     * @param record
     *            <code>Page</code>对象 {@link com.kldaby.manager.bean.Page}
     * @return int 1表示成功 0表示失败
     */
    int updateStoreAPPByPrimaryKeySelective(Page record);

    /**
     * 根据ID选取页面信息
     * 
     * @param id
     *            页面ID
     * @return <code>MenuVo</code>对象
     */
    List<MenuVo> selectByParentId(Long id);

    /**
     * 根据pageBean分页查询分类列表
     * 
     * @param map
     *            封装分页参数 {@link Map}
     * @return 查询到的列表 {@link List}
     */
    List<Object> queryByPageBean(Map<String, Object> map);

    /**
     * 根据pageBean分页查询third端大区PC端菜单分类列表
     *
     * @param map
     *            封装分页参数 {@link Map}
     * @return 查询到的列表 {@link List}
     */
    List<Object> queryRegionalPCByPageBean(Map<String, Object> map);

    /**
     * 根据pageBean分页查询third端大区APP端菜单分类列表
     *
     * @param map
     *            封装分页参数 {@link Map}
     * @return 查询到的列表 {@link List}
     */
    List<Object> queryRegionalAPPByPageBean(Map<String, Object> map);

    /**
     * 根据pageBean分页查询third端门店PC端菜单分类列表
     *
     * @param map
     *            封装分页参数 {@link Map}
     * @return 查询到的列表 {@link List}
     */
    List<Object> queryStorePCByPageBean(Map<String, Object> map);

    /**
     * 根据pageBean分页查询third端门店APP端菜单分类列表
     *
     * @param map
     *            封装分页参数 {@link Map}
     * @return 查询到的列表 {@link List}
     */
    List<Object> queryStoreAPPByPageBean(Map<String, Object> map);

    /**
     * 查询所有的记录行数
     *
     * @return {@link Integer}
     */
    Integer queryTotalCount(Map<String, Object> map);



    /**
     * 查询所有的菜单
     *
     */
    List<MenuVo> queryAllMenuVo();

    /**
     * 查询third端大区PC端所有的菜单
     *
     */
    List<MenuVo> queryRegionalPCAllMenuVo();


    /**
     * 根据父分类ID查询子分类的个数
     * 
     * @param pageId
     * @return
     */
    int querySonCountByParentId(Long pageId);

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
     * chauxn 
     * @param managerId
     * @return List
     */
    List<MenuVo> queryAllParentMenuVoByLogin(Long managerId);

    /**
     * 查询id范围在 startId 和 endId 之间的菜单
     *
     * @param paramMap 里面装bundleName
     * @return 菜单集合 List
     */
    List<MenuVo> queryMenuByBundleName(Map<String, Object> paramMap);

    /**
     * 查询id范围在 startId 和 endId 之间的菜单
     *
     * @param paramMap 里面装开始startId和结束endId
     */
    void deleteMenuByBundleName(Map<String, Object> paramMap);

}
