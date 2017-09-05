package edu.njrs.manager.mapper.impl;

import edu.njrs.common.util.BasicSqlSupport;
import edu.njrs.manager.bean.Manager;
import edu.njrs.manager.mapper.ManagerMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author IShopTeam
 * @since 2013年11月20日下午4:34:10
 */
@Repository("managerMapper")
public final class ManagerMapperImpl extends BasicSqlSupport implements
        ManagerMapper {
    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerMapper#deleteByPrimaryKey(java.lang
     * .Long)
     */
    @Override
    @Transactional
    public int deleteByPrimaryKey(Long id) {

        return this.delete(
                "edu.njrs.manager.mapper.ManagerMapper.deleteByPrimaryKey",
                id);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerMapper#insert(com.kldaby.manager.bean
     * .Manager)
     */
    @Override
    @Transactional
    public int insert(Manager record) {

        return this.insert("edu.njrs.manager.mapper.ManagerMapper.insert",
                record);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerMapper#insertSelective(com.kldaby.
     * manager.bean.Manager)
     */
    @Override
    @Transactional
    public int insertSelective(Manager record) {

        return this.insert(
                "edu.njrs.manager.mapper.ManagerMapper.insertSelective",
                record);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerMapper#selectByPrimaryKey(java.lang
     * .Long)
     */
    @Override
    public Manager selectByPrimaryKey(Long id) {

        return this.selectOne(
                "edu.njrs.manager.mapper.ManagerMapper.selectByPrimaryKey",
                id);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerMapper#updateByPrimaryKeySelective(
     * com.kldaby.manager.bean.Manager)
     */
    @Override
    @Transactional
    public int updateByPrimaryKeySelective(Manager record) {
        return this
                .update("edu.njrs.manager.mapper.ManagerMapper.updateByPrimaryKeySelective",
                        record);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerMapper#updateByPrimaryKey(com.kldaby
     * .manager.bean.Manager)
     */
    @Override
    @Transactional
    public int updateByPrimaryKey(Manager record) {
        return this.update(
                "edu.njrs.manager.mapper.ManagerMapper.updateByPrimaryKey",
                record);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerMapper#selectByName(java.lang.String)
     */
    @Override
    public Manager selectByName(String name) {
        return this.selectOne(
                "edu.njrs.manager.mapper.ManagerMapper.selectByName", name);
    }

    @Override
    public Manager selectDelManagerByName(String name) {
        return this
                .selectOne(
                        "edu.njrs.manager.mapper.ManagerMapper.selectDelManagerByName",
                        name);
    }

    /*
     * 
     * 
     * @see edu.njrs.manager.mapper.ManagerMapper#queryManagerList()
     */
    @Override
    public List<Manager> queryManagerList(Manager manager) {
        return this.selectList(
                "edu.njrs.manager.mapper.ManagerMapper.queryManagerList",
                manager);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerMapper#selectManagerByLimit(java.util
     * .Map)
     */
    @Override
    public List<Object> selectManagerByLimit(Map<String, Integer> paramMap) {
        return this
                .selectList(
                        "edu.njrs.manager.mapper.ManagerMapper.selectManagerByLimit",
                        paramMap);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerMapper#selectManagerByManager(com.kldaby
     * .manager.bean.Manager)
     */
    @Override
    public List<Object> selectManagerByManager(Manager manager) {
        return this
                .selectList(
                        "edu.njrs.manager.mapper.ManagerMapper.selectManagerByManager",
                        manager);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerMapper#addManager(com.kldaby.manager
     * .bean.Manager, java.lang.String[])
     */
    @Override
    @Transactional
    public int addManager(Manager manager, String authorityId) {
        int i = this.insert(
                "edu.njrs.manager.mapper.ManagerMapper.insertSelective",
                manager);
        if (i == 1) {
            Long managerId = this
                    .selectOne("edu.njrs.manager.mapper.ManagerMapper.selectLastId");
            manager.setId(managerId);
            Map<String, Long> paramMap = new HashMap<String, Long>();
            try {
                paramMap.put("managerId", managerId);
                paramMap.put("authorityId", Long.parseLong(authorityId));
                return this
                        .insert("edu.njrs.manager.mapper.ManagerAuthorityMapper.insertSelective",
                                paramMap);
            } finally {
                paramMap = null;
            }
        } else {
            return 0;
        }
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerMapper#delectMangerById(java.lang.Long
     * [])
     */
    @Override
    public int delectMangerById(Long parameterIds) {
        return this.delete(
                "edu.njrs.manager.mapper.ManagerMapper.delectMangerById",
                parameterIds);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerMapper#delectMangerByIds(java.util.Map)
     */
    @Override
    public int delectMangerByIds(Map<String, Object> paramMap) {
        return this.delete(
                "edu.njrs.manager.mapper.ManagerMapper.delectMangerByIds",
                paramMap);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerMapper#delectMangerByIds(java.util.Map)
     */
    @Override
    public int enabledMangerByIds(Map<String, Object> paramMap) {
        return this.delete(
                "edu.njrs.manager.mapper.ManagerMapper.enabledMangerByIds",
                paramMap);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerMapper#queryManagerCount(com.kldaby
     * .manager.bean.Manager)
     */
    @Override
    public int queryManagerCount(Manager manager) {
        return this.selectOne(
                "edu.njrs.manager.mapper.ManagerMapper.queryManagerCount",
                manager);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerMapper#selectCaptcha(java.lang.Long)
     */
    @Override
    public Manager selectCaptcha(Long managerId) {
        return this.selectOne(
                "edu.njrs.manager.mapper.ManagerMapper.selectCaptcha",
                managerId);
    }


    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerMapper#checkexistsByCustName(java.lang
     * .String)
     */
    @Override
    public Long checkexistsByCustName(String name) {
        return this
                .selectOne(
                        "edu.njrs.manager.mapper.ManagerMapper.checkexistsByCustName",
                        name);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.ManagerMapper#selectCustomerByNamePwd(java
     * .util.Map)
     */
    @Override
    public Manager selectCustomerByNamePwd(Map<String, Object> paramMap) {
        return this
                .selectOne(
                        "edu.njrs.manager.mapper.ManagerMapper.selectCustomerByNamePwd",
                        paramMap);
    }

    /*
     * 
     * @see edu.njrs.manager.mapper.ManagerMapper#selectById(java.lang.Long)
     */
    @Override
    public Manager selectById(Long id) {
        return this.selectOne(
                "edu.njrs.manager.mapper.ManagerMapper.selectById", id);
    }
}
