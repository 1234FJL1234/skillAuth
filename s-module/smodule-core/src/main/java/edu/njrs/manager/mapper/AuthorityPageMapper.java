package edu.njrs.manager.mapper;

import edu.njrs.manager.bean.AuthorityPage;
import edu.njrs.manager.bean.MenuVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 权限页面关系网页关系mapper
 */
public interface AuthorityPageMapper {
    /**
     * 根据ID删除权限页面关系信息
     * 
     * @param id
     *            权限页面关系ID
     * @return int 1表示成功 0表示失败
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入权限页面关系信息
     * 
     * @param record
     *            <code>AuthorityPage</code>对象
     * @return int 1表示成功 0表示失败
     */
    int insert(AuthorityPage record);

    /**
     * 插入权限页面关系信息
     * 
     * @param record
     *            <code>AuthorityPage</code>对象
     * @return int 1表示成功 0表示失败
     */
    int insertSelective(AuthorityPage record);

    /**
     * 根据ID选取权限页面关系信息
     * 
     * @param id
     *            权限页面关系ID
     * @return <code>AuthorityPage</code>对象
     */
    AuthorityPage selectByPrimaryKey(Long id);

    /**
     * 修改权限页面关系信息
     * 
     * @param record
     *            <code>AuthorityPage</code>对象
     * @return int 1表示成功 0表示失败
     */
    int updateByPrimaryKeySelective(AuthorityPage record);

    /**
     * 修改权限页面关系信息
     * 
     * @param record
     *            <code>AuthorityPage</code>对象
     * @return int 1表示成功 0表示失败
     */
    int updateByPrimaryKey(AuthorityPage record);

    /**
     * 根据权限ID选取权限页面关系信息
     * 
     * @param authorityId
     *            权限ID
     * @return java.util.List <code>MenuVo</code>对象
     */
    List<MenuVo> selectByAuthorityID(Long authorityId);

    /**
     * 查询所有页面
     * 
     * @return java.util.List <code>MenuVo</code>对象
     */
    List<MenuVo> selectAllMenuVos(Long authorityId);

    /**
     * 查询所有页面--用于URL拦截权限
     * 
     * @return java.util.List <code>MenuVo</code>对象
     */
    List<MenuVo> selectAllMenuVo(Long authorityId);

    /**
     * 添加页面
     * 
     * @param map
     * @return
     */
    int insertAAndPage(Map<String, Object> map);

    /**
     * 删除权限页面
     * 
     * @param parseLong
     *            编号
     * @return 0 失败 1 成功
     */
    Integer deleteAuthorityPageById(long parseLong);

    /**
     * 批量赋予某个角色权限
     *
     * @param paramMap
     *            参数包括 ： authorityId 角色id menuVos 菜单列表
     */
    void addAuthorityPageBatch(Map<String, Object> paramMap);

    /**
     * 删除模块中所有的权限
     *
     * @param paramMap 参数包括 ：
     *                 startMenuId 开始菜单id
     *                 endMenuId 结束菜单id
     */
    void deleteAuthByParam(Map<String, Object> paramMap);

    /**
     * 添加页面
     *
     * @param list
     * @return
     */
    int insertAuthorities(ArrayList<Map<String, Object>> list);
}
