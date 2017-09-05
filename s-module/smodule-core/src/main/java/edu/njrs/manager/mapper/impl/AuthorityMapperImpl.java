package edu.njrs.manager.mapper.impl;

import edu.njrs.common.util.BasicSqlSupport;
import edu.njrs.manager.bean.Authority;
import edu.njrs.manager.bean.AuthorityPage;
import edu.njrs.manager.mapper.AuthorityMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 */
@Repository("authorityMapper")
public final class AuthorityMapperImpl extends BasicSqlSupport implements
        AuthorityMapper {
    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityMapper#deleteByPrimaryKey(java.lang
     * .Long)
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        return this
                .delete("edu.njrs.manager.mapper.AuthorityMapper.deleteByPrimaryKey",
                        id);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityMapper#insert(com.kldaby.manager
     * .bean.Authority)
     */
    @Override
    public int insert(Authority record) {
        return this.insert("edu.njrs.manager.mapper.AuthorityMapper.insert",
                record);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityMapper#insertSelective(com.kldaby
     * .manager.bean.Authority)
     */
    @Override
    public int insertSelective(Authority record) {
        return this.insert(
                "edu.njrs.manager.mapper.AuthorityMapper.insertSelective",
                record);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityMapper#selectByPrimaryKey(java.lang
     * .Long)
     */
    @Override
    public Authority selectByPrimaryKey(Long id) {
        return this
                .selectOne(
                        "edu.njrs.manager.mapper.AuthorityMapper.selectByPrimaryKey",
                        id);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityMapper#updateByPrimaryKeySelective
     * (com.kldaby.manager.bean.Authority)
     */
    @Override
    public int updateByPrimaryKeySelective(Authority record) {
        return this
                .update("edu.njrs.manager.mapper.AuthorityMapper.updateByPrimaryKeySelective",
                        record);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityMapper#updateByPrimaryKey(com.kldaby
     * .manager.bean.Authority)
     */
    @Override
    public int updateByPrimaryKey(Authority record) {
        return this
                .update("edu.njrs.manager.mapper.AuthorityMapper.updateByPrimaryKey",
                        record);
    }

    /*
     * 
     * 
     * @see edu.njrs.manager.mapper.AuthorityMapper#selectAllAuthority()
     */
    @Override
    public List<Authority> selectAllAuthority(Long createId) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("createId", createId);

        return this
                .selectList(
                        "edu.njrs.manager.mapper.AuthorityMapper.selectAllAuthority",
                        paramMap);
    }

    /*
     * 
     * 
     * @see edu.njrs.manager.mapper.AuthorityMapper#queryAuthoritySize()
     */
    @Override
    public Long queryAuthoritySize(Authority authority) {
        return this
                .selectOne(
                        "edu.njrs.manager.mapper.AuthorityMapper.queryAuthoritySize",
                        authority);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityMapper#selectAuthorityByLimit(java
     * .util.Map)
     */
    @Override
    public List<Object> selectAuthorityByLimit(Map<String, Object> paramMap) {
        return this
                .selectList(
                        "edu.njrs.manager.mapper.AuthorityMapper.selectAuthorityByLimit",
                        paramMap);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityMapper#selectAuthorityByAuthority
     * (com.kldaby.manager.bean.Authority)
     */
    @Override
    public List<Object> selectAuthorityByAuthority(Authority authority) {
        return this
                .selectList(
                        "edu.njrs.manager.mapper.AuthorityMapper.selectAuthorityByAuthority",
                        authority);
    }

    /*
     * 
     * 
     * @see edu.njrs.manager.mapper.AuthorityMapper#deleteAuthorityById(long)
     */
    @Override
    public Integer deleteAuthorityById(long parseLong) {
        return this
                .delete("edu.njrs.manager.mapper.AuthorityMapper.deleteAuthorityById",
                        parseLong);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityMapper#insertByDesignation(java.lang
     * .String)
     */
    @Override
    public int insertByDesignation(Map<String, Object> paramMap) {
        return this
                .insert("edu.njrs.manager.mapper.AuthorityMapper.insertByDesignation",
                        paramMap);
    }

    /*
     * 
     * 
     * @see edu.njrs.manager.mapper.AuthorityMapper#selectLastId()
     */
    @Override
    public Long selectLastId() {
        return this
                .selectOne("edu.njrs.manager.mapper.AuthorityMapper.selectLastId");
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityMapper#selectAuthorityByAId(java.
     * lang.Long)
     */
    @Override
    public List<AuthorityPage> selectAuthorityByAId(Long id) {
        return this
                .selectList(
                        "edu.njrs.manager.mapper.AuthorityPageMapper.selectAuthorityByAId",
                        id);
    }

    /*
     * 
     * 
     * @see edu.njrs.manager.mapper.AuthorityMapper#querySupperAuthor()
     */
    @Override
    public Authority querySupperAuthor() {
        return this
                .selectOne("edu.njrs.manager.mapper.AuthorityMapper.querySupperAuthor");
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityMapper#deleteAuthorityByIds(java.
     * util.Map)
     */
    @Override
    public int deleteAuthorityByIds(Map<String, Object> paramMap) {
        return this
                .delete("edu.njrs.manager.mapper.AuthorityMapper.deleteAuthorityByIds",
                        paramMap);
    }

    /*
     * 
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityMapper#checkAuthExist(java.lang.String
     * )
     */
    @Override
    public Long checkAuthExist(String authName) {
        return this.selectOne(
                "edu.njrs.manager.mapper.AuthorityMapper.checkAuthExist",
                authName);
    }

    @Override
    public Authority checkManagerExist(String username) {
        return this.selectOne(
                "edu.njrs.manager.mapper.AuthorityMapper.checkManagerExist",
                username);
    }

    /*
     * 
     * @see
     * edu.njrs.manager.mapper.AuthorityMapper#selectAuthByManagerId(java
     * .lang.Long)
     */
    @Override
    public Authority selectAuthByManagerId(Long id) {
        return this
                .selectOne(
                        "edu.njrs.manager.mapper.AuthorityMapper.selectAuthByManagerId",
                        id);
    }

    /**
     * 查询角色关联的用户数据量
     *
     * @param authId
     * @return
     */
    @Override
    public int queryManangerAuthCount(String authId) {
        return this
                .selectOne(
                        "edu.njrs.manager.mapper.AuthorityMapper.queryManangerAuthCount",
                        authId);
    }

}
