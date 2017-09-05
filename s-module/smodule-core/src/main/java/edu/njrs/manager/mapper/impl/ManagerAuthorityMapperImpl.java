package edu.njrs.manager.mapper.impl;

import edu.njrs.common.util.BasicSqlSupport;
import edu.njrs.manager.bean.ManagerAuthority;
import edu.njrs.manager.mapper.ManagerAuthorityMapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 */
@Repository("managerAuthorityMapper")
public final class ManagerAuthorityMapperImpl extends BasicSqlSupport implements
        ManagerAuthorityMapper {
    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerAuthorityMapper#deleteByPrimaryKey(
     * java.lang.Long)
     */
    @Override
    public int deleteByPrimaryKey(Long id) {

        return this
                .delete("edu.njrs.manager.mapper.ManagerAuthorityMapper.deleteByPrimaryKey",
                        id);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerAuthorityMapper#insert(com.kldaby.
     * manager.bean.ManagerAuthority)
     */
    @Override
    public int insert(ManagerAuthority record) {

        return this.insert(
                "edu.njrs.manager.mapper.ManagerAuthorityMapper.insert",
                record);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerAuthorityMapper#insertSelective(com
     * .IShopOrganization.manager.bean.ManagerAuthority)
     */
    @Override
    public int insertSelective(ManagerAuthority record) {
        return this
                .insert("edu.njrs.manager.mapper.ManagerAuthorityMapper.insertSelective",
                        record);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerAuthorityMapper#selectByPrimaryKey(
     * java.lang.Long)
     */
    @Override
    public ManagerAuthority selectByPrimaryKey(Long id) {

        return this
                .selectOne(
                        "edu.njrs.manager.mapper.ManagerAuthorityMapper.selectByPrimaryKey",
                        id);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerAuthorityMapper#updateByPrimaryKeySelective
     * (com.kldaby.manager.bean.ManagerAuthority)
     */
    @Override
    public int updateByPrimaryKeySelective(ManagerAuthority record) {
        return this
                .update("edu.njrs.manager.mapper.ManagerAuthorityMapper.updateByPrimaryKeySelective",
                        record);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerAuthorityMapper#updateByPrimaryKey(
     * com.kldaby.manager.bean.ManagerAuthority)
     */
    @Override
    public int updateByPrimaryKey(ManagerAuthority record) {
        return this
                .update("edu.njrs.manager.mapper.ManagerAuthorityMapper.updateByPrimaryKey",
                        record);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerAuthorityMapper#selectByManagerId(java
     * .lang.Long)
     */
    @Override
    public ManagerAuthority selectByManagerId(Long id) {
        return this
                .selectOne(
                        "edu.njrs.manager.mapper.ManagerAuthorityMapper.selectByManagerId",
                        id);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerAuthorityMapper#deleteByManagerIds(
     * java.util.Map)
     */
    @Override
    public int deleteByManagerIds(Map<String, Object> paramMap) {
        return this
                .delete("edu.njrs.manager.mapper.ManagerAuthorityMapper.deleteByManagerIds",
                        paramMap);
    }

    @Override
    public int enabledByManagerIds(Map<String, Object> paramMap) {
        return this
                .delete("edu.njrs.manager.mapper.ManagerAuthorityMapper.enabledByManagerIds",
                        paramMap);
    }
}
