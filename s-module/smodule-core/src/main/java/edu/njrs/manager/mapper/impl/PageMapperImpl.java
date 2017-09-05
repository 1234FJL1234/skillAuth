package edu.njrs.manager.mapper.impl;

import edu.njrs.common.util.BasicSqlSupport;
import edu.njrs.manager.bean.MenuVo;
import edu.njrs.manager.bean.Page;
import edu.njrs.manager.mapper.PageMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 */
@Repository("PageMapperImpl") 
public final class PageMapperImpl extends BasicSqlSupport implements PageMapper {
    /**
     * 
     * 
     */
    @Override
    public int deleteByPrimaryKey(Long id) {

        return this.delete("edu.njrs.manager.mapper.PageMapper.deleteByPrimaryKey", id);
    }

    /**
     *
     *
     */
    @Override
    public int deleteRegionalPCByPrimaryKey(Long id) {

        return this.delete("edu.njrs.manager.mapper.PageMapper.deleteRegionalPCByPrimaryKey", id);
    }

    /**
     *
     *
     */
    @Override
    public int deleteRegionalAPPByPrimaryKey(Long id) {

        return this.delete("edu.njrs.manager.mapper.PageMapper.deleteRegionalAPPByPrimaryKey", id);
    }

    /**
     *
     *
     */
    @Override
    public int deleteStorePCByPrimaryKey(Long id) {

        return this.delete("edu.njrs.manager.mapper.PageMapper.deleteStorePCByPrimaryKey", id);
    }

    /**
     *
     *
     */
    @Override
    public int deleteStoreAPPByPrimaryKey(Long id) {

        return this.delete("edu.njrs.manager.mapper.PageMapper.deleteStoreAPPByPrimaryKey", id);
    }

    /**
     *
     *
     */
    @Override
    public int insertSelective(Page record) {

        return this.insert("edu.njrs.manager.mapper.PageMapper.insertSelective", record);
    }

    /**
     *
     *
     */
    @Override
    public int insertRegionalPCSelective(Page record) {

        return this.insert("edu.njrs.manager.mapper.PageMapper.insertRegionalPCSelective", record);
    }

    /**
     *
     *
     */
    @Override
    public int insertRegionalLinkAuthAndPage(String designation) {

        return this.insert("edu.njrs.manager.mapper.PageMapper.insertRegionalLinkAuthAndPage", designation);
    }

    /**
     *
     *
     */
    @Override
    public int insertStoreLinkAuthAndPage(String designation) {

        return this.insert("edu.njrs.manager.mapper.PageMapper.insertStoreLinkAuthAndPage", designation);
    }

    /**
     *
     *
     */
    @Override
    public int insertRegionalAPPSelective(Page record) {

        return this.insert("edu.njrs.manager.mapper.PageMapper.insertRegionalAPPSelective", record);
    }

    /**
     *
     *
     */
    @Override
    public int insertStorePCSelective(Page record) {

        return this.insert("edu.njrs.manager.mapper.PageMapper.insertStorePCSelective", record);
    }

    /**
     *
     *
     */
    @Override
    public int insertStoreAPPSelective(Page record) {

        return this.insert("edu.njrs.manager.mapper.PageMapper.insertStoreAPPSelective", record);
    }

    /*
     *
     *
     * @see edu.njrs.manager.mapper.PageMapper#selectByPrimaryKey(java.lang.Long)
     */
    @Override
    public Page selectByPrimaryKey(Long id) {

        return this.selectOne("edu.njrs.manager.mapper.PageMapper.selectByPrimaryKey", id);
    }

    /*
    *
    *
    * @see edu.njrs.manager.mapper.PageMapper#selectRegionalPCByPrimaryKey(java.lang.Long)
    */
    @Override
    public Page selectRegionalPCByPrimaryKey(Long id) {

        return this.selectOne("edu.njrs.manager.mapper.PageMapper.selectRegionalPCByPrimaryKey", id);
    }

    /*
    *
    *
    * @see edu.njrs.manager.mapper.PageMapper#selectRegionalAPPByPrimaryKey(java.lang.Long)
    */
    @Override
    public Page selectRegionalAPPByPrimaryKey(Long id) {

        return this.selectOne("edu.njrs.manager.mapper.PageMapper.selectRegionalAPPByPrimaryKey", id);
    }

    /*
    *
    *
    * @see edu.njrs.manager.mapper.PageMapper#selectStorePCByPrimaryKey(java.lang.Long)
    */
    @Override
    public Page selectStorePCByPrimaryKey(Long id) {

        return this.selectOne("edu.njrs.manager.mapper.PageMapper.selectStorePCByPrimaryKey", id);
    }

    /*
    *
    *
    * @see edu.njrs.manager.mapper.PageMapper#selectStoreAPPByPrimaryKey(java.lang.Long)
    */
    @Override
    public Page selectStoreAPPByPrimaryKey(Long id) {

        return this.selectOne("edu.njrs.manager.mapper.PageMapper.selectStoreAPPByPrimaryKey", id);
    }

    /**
     * 根据id选取结果
     * */
    @Override
    public List<Long> selectByPrimaryKeys(List<Long> pageList) {

        return this.selectList("edu.njrs.manager.mapper.PageMapper.selectByPrimaryKeys", pageList);
    }

    /**
     *
     *
     */
    @Override
    public int updateByPrimaryKeySelective(Page record) {
        return this.update("edu.njrs.manager.mapper.PageMapper.updateByPrimaryKeySelective", record);
    }

    /**
     *
     *
     */
    @Override
    public int updateRegionalPCByPrimaryKeySelective(Page record) {
        return this.update("edu.njrs.manager.mapper.PageMapper.updateRegionalPCByPrimaryKeySelective", record);
    }

    /**
     *
     *
     */
    @Override
    public int updateRegionalAPPByPrimaryKeySelective(Page record) {
        return this.update("edu.njrs.manager.mapper.PageMapper.updateRegionalAPPByPrimaryKeySelective", record);
    }

    /**
     *
     *
     */
    @Override
    public int updateStorePCByPrimaryKeySelective(Page record) {
        return this.update("edu.njrs.manager.mapper.PageMapper.updateStorePCByPrimaryKeySelective", record);
    }

    /**
     *
     *
     */
    @Override
    public int updateStoreAPPByPrimaryKeySelective(Page record) {
        return this.update("edu.njrs.manager.mapper.PageMapper.updateStoreAPPByPrimaryKeySelective", record);
    }

    /**
     *
     *
     */
    @Override
    public List<MenuVo> selectByParentId(Long id) {
        return this.selectList("edu.njrs.manager.mapper.PageMapper.selectByParentId", id);
    }

    /**
     *
     *
     */
    @Override
    public List<Object> queryByPageBean(Map<String, Object> map) {
        return this.selectList("edu.njrs.manager.mapper.PageMapper.queryByPageBean", map);
    }

    /**
     *
     *
     */
    @Override
    public List<Object> queryRegionalPCByPageBean(Map<String, Object> map) {
        return this.selectList("edu.njrs.manager.mapper.PageMapper.queryRegionalPCByPageBean", map);
    }

    /**
     *
     *
     */
    @Override
    public List<Object> queryRegionalAPPByPageBean(Map<String, Object> map) {
        return this.selectList("edu.njrs.manager.mapper.PageMapper.queryRegionalAPPByPageBean", map);
    }

    /**
     *
     *
     */
    @Override
    public List<Object> queryStorePCByPageBean(Map<String, Object> map) {
        return this.selectList("edu.njrs.manager.mapper.PageMapper.queryStorePCByPageBean", map);
    }

    /**
     *
     *
     */
    @Override
    public List<Object> queryStoreAPPByPageBean(Map<String, Object> map) {
        return this.selectList("edu.njrs.manager.mapper.PageMapper.queryStoreAPPByPageBean", map);
    }

    /**
     *
     *
     */
    @Override
    public Integer queryTotalCount(Map<String, Object> map) {
        return this.selectOne("edu.njrs.manager.mapper.PageMapper.queryTotalCount", map);
    }

    /**
     *
     *
     */
    @Override
    public List<MenuVo> queryAllMenuVo() {
        return this.selectList("edu.njrs.manager.mapper.PageMapper.queryAllMenuVo");
    }

    /**
     *
     *
     */
    @Override
    public List<MenuVo> queryRegionalPCAllMenuVo() {
        return this.selectList("edu.njrs.manager.mapper.PageMapper.queryRegionalPCAllMenuVo");
    }


    /**
     *
     *
     */
    @Override
    public int querySonCountByParentId(Long pageId) {
        return this.selectOne("edu.njrs.manager.mapper.PageMapper.querySonCountByParentId", pageId);
    }

    /**
     *
     *
     */
    @Override
    public List<MenuVo> queryAllParentMenuVo() {
        return this.selectList("edu.njrs.manager.mapper.PageMapper.queryAllParentMenuVo");
    }

    /**
     *
     *
     */
    @Override
    public List<MenuVo> queryAllChildrenMenuVo() {
        return this.selectList("edu.njrs.manager.mapper.PageMapper.queryAllChildrenMenuVo");
    }

    /**
     *
     */
    @Override
    public List<MenuVo> queryAllParentMenuVoByLogin(Long managerId) {
        
           return this.selectList("edu.njrs.manager.mapper.PageMapper.queryAllParentMenuVoByLogin",managerId);
    }

    /**
     * 查询id范围在 startId 和 endId 之间的菜单
     *
     * @param paramMap 里面装开始startId和结束endId
     * @return 菜单集合 List
     */
    @Override
    public List<MenuVo> queryMenuByBundleName(Map<String, Object> paramMap) {
        return this.selectList("edu.njrs.manager.mapper.PageMapper.queryMenuByBundleName",paramMap);
    }

    /**
     * 查询id范围在 startId 和 endId 之间的菜单
     *
     * @param paramMap 里面装开始startId和结束endId
     */
    @Override
    public void deleteMenuByBundleName(Map<String, Object> paramMap) {
        this.delete("edu.njrs.manager.mapper.PageMapper.deleteMenuByBundleName", paramMap);
    }

}
