package edu.njrs.manager.mapper.impl;

import edu.njrs.common.util.BasicSqlSupport;
import edu.njrs.manager.bean.AuthorityPage;
import edu.njrs.manager.bean.MenuVo;
import edu.njrs.manager.mapper.AuthorityPageMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 */
@Repository("authorityPageMapper")
public final class AuthorityPageMapperImpl extends BasicSqlSupport implements
        AuthorityPageMapper {
    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityPageMapper#deleteByPrimaryKey(java
     * .lang.Long)
     */
    @Override
    public int deleteByPrimaryKey(Long id) {

        return this
                .delete("edu.njrs.manager.mapper.AuthorityPageMapper.deleteByPrimaryKey",
                        id);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityPageMapper#insert(com.kldaby.manager
     * .bean.AuthorityPage)
     */
    @Override
    public int insert(AuthorityPage record) {

        return this
                .insert("edu.njrs.manager.mapper.AuthorityPageMapper.insert",
                        record);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityPageMapper#insertSelective(com.kldaby
     * .manager.bean.AuthorityPage)
     */
    @Override
    public int insertSelective(AuthorityPage record) {

        return this
                .insert("edu.njrs.manager.mapper.AuthorityPageMapper.insertSelective",
                        record);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityPageMapper#selectByPrimaryKey(java
     * .lang.Long)
     */
    @Override
    public AuthorityPage selectByPrimaryKey(Long id) {

        return this
                .selectOne(
                        "com.ningapi.manager.mapper.AuthorityPageMapper.selectByPrimaryKey",
                        id);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityPageMapper#updateByPrimaryKeySelective
     * (com.kldaby.manager.bean.AuthorityPage)
     */
    @Override
    public int updateByPrimaryKeySelective(AuthorityPage record) {

        return this
                .update("edu.njrs.manager.mapper.AuthorityPageMapper.updateByPrimaryKeySelective",
                        record);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityPageMapper#updateByPrimaryKey(com
     * .IShopOrganization.manager.bean.AuthorityPage)
     */
    @Override
    public int updateByPrimaryKey(AuthorityPage record) {

        return this
                .update("edu.njrs.manager.mapper.AuthorityPageMapper.updateByPrimaryKey",
                        record);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityPageMapper#selectByAuthorityID(java
     * .lang.Long)
     */
    @Override
    public List<MenuVo> selectByAuthorityID(Long authorityId) {
        return this
                .selectList(
                        "edu.njrs.manager.mapper.AuthorityPageMapper.selectByAuthorityID",
                        authorityId);
    }

    /*
     * 
     * 
     * @see edu.njrs.manager.mapper.AuthorityPageMapper#selectAllMenuVos(Long
     * authorityId)
     */
    @Override
    public List<MenuVo> selectAllMenuVos(Long authorityId) {
        return this
                .selectList(
                        "edu.njrs.manager.mapper.AuthorityPageMapper.selectAllMenuVos",
                        authorityId);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityPageMapper#selectAllMenuVo(java.lang
     * .Long)
     */
    @Override
    public List<MenuVo> selectAllMenuVo(Long authorityId) {
        return this
                .selectList(
                        "edu.njrs.manager.mapper.AuthorityPageMapper.selectAllMenuVo",
                        authorityId);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityPageMapper#insertAAndPage(java.util
     * .Map)
     */
    @Override
    public int insertAAndPage(Map<String, Object> map) {
        return this
                .insert("edu.njrs.manager.mapper.AuthorityPageMapper.insertAAndPage",
                        map);
    }

    /*
     *
     *
     * @see
     * edu.njrs.manager.mapper.AuthorityPageMapper#deleteAuthorityPageById
     * (long)
     */
    @Override
    public Integer deleteAuthorityPageById(long parseLong) {
        return this
                .insert("edu.njrs.manager.mapper.AuthorityPageMapper.deleteAuthorityPageById",
                        parseLong);
    }

    /**
     * 批量赋予某个角色权限
     *
     * @param paramMap
     *            参数包括 ： authorityId 角色id menuVos 菜单列表
     */
    @Override
    public void addAuthorityPageBatch(Map<String, Object> paramMap) {
        this.insert(
                "edu.njrs.manager.mapper.AuthorityPageMapper.addAuthorityPageBatch",
                paramMap);
    }

    /**
     * 删除模块中所有的权限
     *
     * @param paramMap 参数包括 ：
     *                 startMenuId 开始菜单id
     *                 endMenuId 结束菜单id
     */
    @Override
    public void deleteAuthByParam(Map<String, Object> paramMap) {
        this.delete("edu.njrs.manager.mapper.AuthorityPageMapper.deleteAuthByParam", paramMap);
    }

    /**
     * 添加页面
     *
     * @param list
     * @return
     */
    @Override
    public int insertAuthorities(ArrayList<Map<String, Object>> list) {
        return this
                .insert("edu.njrs.manager.mapper.AuthorityPageMapper.insertAuthorities",
                        list);
    }

}
