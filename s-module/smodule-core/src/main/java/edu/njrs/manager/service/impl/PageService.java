/*


 */

package edu.njrs.manager.service.impl;

import edu.njrs.common.util.PageBean;
import edu.njrs.common.util.SelectBean;
import edu.njrs.manager.bean.MenuVo;
import edu.njrs.manager.bean.Page;
import edu.njrs.manager.mapper.PageMapper;
import edu.njrs.manager.service.PageServiceInterface;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单Service实现
 * 
 * @author IShopTeam
 * @since 2014年1月8日 下午10:24:16
 * @version 1.0
 */
@Repository("PageService")
public class PageService implements PageServiceInterface {

    private PageMapper pagemapper;

    public PageMapper getPagemapper() {
        return pagemapper;
    }

    @Resource(name = "PageMapperImpl")
    public void setPagemapper(PageMapper pagemapper) {
        this.pagemapper = pagemapper;
    }

    /**
     */
    @Override
    public int savePage(Page page) {
        page.setFlag("0");
        if(page.getParentId()==null){
            page.setParentId(0L);
        }
        if (page.getParentId() == 0) {
            page.setGrade(1L);
        } else {
            page.setGrade(this.pagemapper.selectByPrimaryKey(page.getParentId()).getGrade() + 1);
        }
        return this.pagemapper.insertSelective(page);
    }

    /**
     */
    @Override
    public int saveRegionalPCPage(Page page) {
        page.setFlag("0");
        if(page.getParentId()==null){
            page.setParentId(0L);
        }
        if (page.getParentId() == 0) {
            page.setGrade(1L);
        } else {
            page.setGrade(this.pagemapper.selectRegionalPCByPrimaryKey(page.getParentId()).getGrade() + 1);
        }
        return this.pagemapper.insertRegionalPCSelective(page);
    }

    /**
     */
    @Override
    public int linkRegionalAuthorityAndPage(String designation) {

        return this.pagemapper.insertRegionalLinkAuthAndPage(designation);
    }

    /**
     */
    @Override
    public int linkStoreAuthorityAndPage(String designation) {

        return this.pagemapper.insertStoreLinkAuthAndPage(designation);
    }

    /**
     */
    @Override
    public int saveRegionalAPPPage(Page page) {
        page.setFlag("0");
        if(page.getParentId()==null){
            page.setParentId(0L);
        }
        if (page.getParentId() == 0) {
            page.setGrade(1L);
        } else {
            page.setGrade(this.pagemapper.selectRegionalAPPByPrimaryKey(page.getParentId()).getGrade() + 1);
        }
        return this.pagemapper.insertRegionalAPPSelective(page);
    }

    /**
     */
    @Override
    public int saveStorePCPage(Page page) {
        page.setFlag("0");
        if(page.getParentId()==null){
            page.setParentId(0L);
        }
        if (page.getParentId() == 0) {
            page.setGrade(1L);
        } else {
            page.setGrade(this.pagemapper.selectStorePCByPrimaryKey(page.getParentId()).getGrade() + 1);
        }
        return this.pagemapper.insertStorePCSelective(page);
    }

    /**
     */
    @Override
    public int saveStoreAPPPage(Page page) {
        page.setFlag("0");
        if(page.getParentId()==null){
            page.setParentId(0L);
        }
        if (page.getParentId() == 0) {
            page.setGrade(1L);
        } else {
            page.setGrade(this.pagemapper.selectStoreAPPByPrimaryKey(page.getParentId()).getGrade() + 1);
        }
        return this.pagemapper.insertStoreAPPSelective(page);
    }

    @Override
    public int updatePage(Page page) {
        if (page.getParentId() == 0) {
            page.setGrade(1L);
        } else {
            page.setGrade(this.pagemapper.selectByPrimaryKey(page.getParentId()).getGrade() + 1);
        }
        return this.pagemapper.updateByPrimaryKeySelective(page);
    }

    @Override
    public int updateRegionalPCPage(Page page) {
        if (page.getParentId() == 0) {
            page.setGrade(1L);
        } else {
            page.setGrade(this.pagemapper.selectRegionalPCByPrimaryKey(page.getParentId()).getGrade() + 1);
        }
        return this.pagemapper.updateRegionalPCByPrimaryKeySelective(page);
    }

    @Override
    public int updateRegionalAPPPage(Page page) {
        if (page.getParentId() == 0) {
            page.setGrade(1L);
        } else {
            page.setGrade(this.pagemapper.selectRegionalAPPByPrimaryKey(page.getParentId()).getGrade() + 1);
        }
        return this.pagemapper.updateRegionalAPPByPrimaryKeySelective(page);
    }

    @Override
    public int updateStorePCPage(Page page) {
        if (page.getParentId() == 0) {
            page.setGrade(1L);
        } else {
            page.setGrade(this.pagemapper.selectStorePCByPrimaryKey(page.getParentId()).getGrade() + 1);
        }
        return this.pagemapper.updateStorePCByPrimaryKeySelective(page);
    }

    @Override
    public int updateStoreAPPPage(Page page) {
        if (page.getParentId() == 0) {
            page.setGrade(1L);
        } else {
            page.setGrade(this.pagemapper.selectStoreAPPByPrimaryKey(page.getParentId()).getGrade() + 1);
        }
        return this.pagemapper.updateStoreAPPByPrimaryKeySelective(page);
    }

    /**
     */
    @Override
    public int delPage(Long pageId) {
        return this.pagemapper.deleteByPrimaryKey(pageId);
    }

    /**
     */
    @Override
    public int delRegionalPCPage(Long pageId) {
        return this.pagemapper.deleteRegionalPCByPrimaryKey(pageId);
    }

    /**
     */
    @Override
    public int delRegionalAPPPage(Long pageId) {
        return this.pagemapper.deleteRegionalAPPByPrimaryKey(pageId);
    }

    /**
     */
    @Override
    public int delStorePCPage(Long pageId) {
        return this.pagemapper.deleteStorePCByPrimaryKey(pageId);
    }

    /**
     */
    @Override
    public int delStoreAPPPage(Long pageId) {
        return this.pagemapper.deleteStoreAPPByPrimaryKey(pageId);
    }

    /**
     */
    @Override
    public int batchDelPage(Long[] pageIds) {
        Integer count = 0;

        if (null != pageIds && pageIds.length > 0) {
            for (int i = 0; i < pageIds.length; i++) {
                count += this.delPage(pageIds[i]);
            }
        }
        return count;

    }

    /**
     */
    @Override
    public int batchRegionalPCDelPage(Long[] pageIds) {
        Integer count = 0;

        if (null != pageIds && pageIds.length > 0) {
            for (int i = 0; i < pageIds.length; i++) {
                count += this.delRegionalPCPage(pageIds[i]);
            }
        }
        return count;

    }

    /**
     */
    @Override
    public int batchRegionalAPPDelPage(Long[] pageIds) {
        Integer count = 0;

        if (null != pageIds && pageIds.length > 0) {
            for (int i = 0; i < pageIds.length; i++) {
                count += this.delRegionalAPPPage(pageIds[i]);
            }
        }
        return count;

    }

    /**
     */
    @Override
    public int batchStorePCDelPage(Long[] pageIds) {
        Integer count = 0;

        if (null != pageIds && pageIds.length > 0) {
            for (int i = 0; i < pageIds.length; i++) {
                count += this.delStorePCPage(pageIds[i]);
            }
        }
        return count;

    }

    /**
     */
    @Override
    public int batchStoreAPPDelPage(Long[] pageIds) {
        Integer count = 0;

        if (null != pageIds && pageIds.length > 0) {
            for (int i = 0; i < pageIds.length; i++) {
                count += this.delStoreAPPPage(pageIds[i]);
            }
        }
        return count;

    }

    /**
     */
    @Override
    public Page queryPageByPrimaryKey(Long pageId) {
        return this.pagemapper.selectByPrimaryKey(pageId);
    }

    /**
     */
    @Override
    public Page queryRegionalPCPageByPrimaryKey(Long pageId) {
        return this.pagemapper.selectRegionalPCByPrimaryKey(pageId);
    }

    /**
     */
    @Override
    public Page queryRegionalAPPPageByPrimaryKey(Long pageId) {
        return this.pagemapper.selectRegionalAPPByPrimaryKey(pageId);
    }

    /**
     */
    @Override
    public Page queryStorePCPageByPrimaryKey(Long pageId) {
        return this.pagemapper.selectStorePCByPrimaryKey(pageId);
    }

    /**
     */
    @Override
    public Page queryStoreAPPPageByPrimaryKey(Long pageId) {
        return this.pagemapper.selectStoreAPPByPrimaryKey(pageId);
    }

    /**
     */
    @Override
    public PageBean queryCateListByPageBean(PageBean pb, SelectBean selectBean) {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("condition", selectBean.getCondition());
        map.put("searchText", selectBean.getSearchText());
        // 查询数据的总行数并设置到PageBean中
        pb.setRows(this.pagemapper.queryTotalCount(map));
        map.put("startRowNum", pb.getStartRowNum());
        map.put("endRowNum", pb.getEndRowNum());
        pb.setList(this.pagemapper.queryByPageBean(map));

        return pb;
    }

    /**
     * 根据分页帮助类查询third端大区PC端菜单分页列表
     *
     * @param pb
     * @param selectBean
     * @return
     */
    @Override
    public PageBean queryRegionalPCCateListByPageBean(PageBean pb, SelectBean selectBean) {
        return null;
    }

    /**
     * 根据分页帮助类查询third端大区APP端菜单分页列表
     *
     * @param pb
     * @param selectBean
     */
    @Override
    public PageBean queryRegionalAPPCateListByPageBean(PageBean pb, SelectBean selectBean) {
        return null;
    }

    /**
     * 根据分页帮助类查询third端门店PC端菜单分页列表
     *
     * @param pb
     * @param selectBean
     */
    @Override
    public PageBean queryStorePCCateListByPageBean(PageBean pb, SelectBean selectBean) {
        return null;
    }

    /**
     * 根据分页帮助类查询third端门店APP端菜单分页列表
     *
     * @param pb
     * @param selectBean
     */
    @Override
    public PageBean queryStoreAPPCateListByPageBean(PageBean pb, SelectBean selectBean) {
        return null;
    }

//    /**
//     */
//    @Override
//    public PageBean queryRegionalPCCateListByPageBean(PageBean pb, SelectBean selectBean) {
//        Map<String, Object> map = new HashMap<String, Object>();
//
//        map.put("condition", selectBean.getCondition());
//        map.put("searchText", selectBean.getSearchText());
//        // 查询数据的总行数并设置到PageBean中
//        pb.setRows(this.pagemapper.queryRegionalPCTotalCount(map));
//        map.put("startRowNum", pb.getStartRowNum());
//        map.put("endRowNum", pb.getEndRowNum());
//        pb.setList(this.pagemapper.queryRegionalPCByPageBean(map));
//
//        return pb;
//    }

//    /**
//     */
//    @Override
//    public PageBean queryRegionalAPPCateListByPageBean(PageBean pb, SelectBean selectBean) {
//        Map<String, Object> map = new HashMap<String, Object>();
//
//        map.put("condition", selectBean.getCondition());
//        map.put("searchText", selectBean.getSearchText());
//        // 查询数据的总行数并设置到PageBean中
//        pb.setRows(this.pagemapper.queryRegionalAPPTotalCount(map));
//        map.put("startRowNum", pb.getStartRowNum());
//        map.put("endRowNum", pb.getEndRowNum());
//        pb.setList(this.pagemapper.queryRegionalAPPByPageBean(map));
//
//        return pb;
//    }

//    /**
//     */
//    @Override
//    public PageBean queryStorePCCateListByPageBean(PageBean pb, SelectBean selectBean) {
//        Map<String, Object> map = new HashMap<String, Object>();
//
//        map.put("condition", selectBean.getCondition());
//        map.put("searchText", selectBean.getSearchText());
//        // 查询数据的总行数并设置到PageBean中
//        pb.setRows(this.pagemapper.queryStorePCTotalCount(map));
//        map.put("startRowNum", pb.getStartRowNum());
//        map.put("endRowNum", pb.getEndRowNum());
//        pb.setList(this.pagemapper.queryStorePCByPageBean(map));
//
//        return pb;
//    }

    /**
     */
//    @Override
//    public PageBean queryStoreAPPCateListByPageBean(PageBean pb, SelectBean selectBean) {
//        Map<String, Object> map = new HashMap<String, Object>();
//
//        map.put("condition", selectBean.getCondition());
//        map.put("searchText", selectBean.getSearchText());
//        // 查询数据的总行数并设置到PageBean中
//        pb.setRows(this.pagemapper.queryStoreAPPTotalCount(map));
//        map.put("startRowNum", pb.getStartRowNum());
//        map.put("endRowNum", pb.getEndRowNum());
//        pb.setList(this.pagemapper.queryStoreAPPByPageBean(map));
//
//        return pb;
//    }

    /**
     */
    @Override
    public List<MenuVo> queryAllMenuVo() {
        return this.pagemapper.queryAllMenuVo();
    }

    /**
     */
    @Override
    public List<MenuVo> queryRegionalPCAllMenuVo() {
        return this.pagemapper.queryRegionalPCAllMenuVo();
    }

    /**
     * 查询third端大区APP端所有的菜单
     *
     * @return 查询到的列表
     */
    @Override
    public List<MenuVo> queryRegionalAPPAllMenuVo() {
        return null;
    }

    /**
     * 查询third端门店PC端所有的菜单
     *
     * @return 查询到的列表
     */
    @Override
    public List<MenuVo> queryStorePCAllMenuVo() {
        return null;
    }

    /**
     * 查询third端门店APP端所有的菜单
     *
     * @return 查询到的列表
     */
    @Override
    public List<MenuVo> queryStoreAPPAllMenuVo() {
        return null;
    }

//    /**
//     */
//    @Override
//    public List<MenuVo> queryRegionalAPPAllMenuVo() {
//        return this.pagemapper.queryRegionalAPPAllMenuVo();
//    }
//
//    /**
//     */
//    @Override
//    public List<MenuVo> queryStorePCAllMenuVo() {
//        return this.pagemapper.queryStorePCAllMenuVo();
//    }
//
//    /**
//     */
//    @Override
//    public List<MenuVo> queryStoreAPPAllMenuVo() {
//        return this.pagemapper.queryStoreAPPAllMenuVo();
//    }

    /**
     */
    @Override
    public boolean checkDelWithPageId(Long pageId) {
        return this.pagemapper.querySonCountByParentId(pageId) > 0 ? false : true;
    }

    /**
     */
    @Override
    public List<Object> getCateList(PageBean pb, SelectBean selectBean) {

        selectBean.setCondition("");
        // 创建需要返回的集合
        List<Object> cateVoList = new ArrayList<Object>();
        // 根据分页查询所有的父分类的集合
        List<Object> parentList = this.queryCateListByPageBean(pb, selectBean).getList();
        // 查询所有的分类信息
        List<MenuVo> allCateList = this.pagemapper.queryAllMenuVo();

        MenuVo menu;
        MenuVo menuVo;

        // 根据父分类集合循环调用计算的方法，整理出二叉树
        for (int i = 0; i < parentList.size(); i++) {
            // 从父分类中取出每一个分类
            menu = (MenuVo) parentList.get(i);
            // 创建最上级的分类，并把属性转移给这个分类
            menuVo = new MenuVo();
            menuVo.setId(menu.getId());
            menuVo.setGrade(menu.getGrade());
            menuVo.setDesignation(menu.getDesignation());
            menuVo.setParentId(menu.getParentId());
            menuVo.setUrl(menu.getUrl());
            menuVo.setSort(menu.getSort());
            // 根据取得的父分类ID和所有的分类列表计算分类实体，并添加到需要返回的集合中
            menuVo.setMenuVos(this.calcCateVo(menuVo.getId(), allCateList));
            cateVoList.add(menuVo);
        }
        // 返回整理好的分类集合
        return cateVoList;
    }

    /**
     */
    @Override
    public List<Object> getRegionalPCCateList(PageBean pb, SelectBean selectBean) {

        selectBean.setCondition("");
        // 创建需要返回的集合
        List<Object> cateVoList = new ArrayList<Object>();
        // 根据分页查询所有的父分类的集合
        List<Object> parentList = this.queryRegionalPCCateListByPageBean(pb, selectBean).getList();
        // 查询所有的分类信息
        List<MenuVo> allCateList = this.pagemapper.queryRegionalPCAllMenuVo();

        MenuVo menu;
        MenuVo menuVo;

        // 根据父分类集合循环调用计算的方法，整理出二叉树
        for (int i = 0; i < parentList.size(); i++) {
            // 从父分类中取出每一个分类
            menu = (MenuVo) parentList.get(i);
            // 创建最上级的分类，并把属性转移给这个分类
            menuVo = new MenuVo();
            menuVo.setId(menu.getId());
            menuVo.setGrade(menu.getGrade());
            menuVo.setDesignation(menu.getDesignation());
            menuVo.setParentId(menu.getParentId());
            menuVo.setUrl(menu.getUrl());
            menuVo.setSort(menu.getSort());
            // 根据取得的父分类ID和所有的分类列表计算分类实体，并添加到需要返回的集合中
            menuVo.setMenuVos(this.calcCateVo(menuVo.getId(), allCateList));
            cateVoList.add(menuVo);
        }
        // 返回整理好的分类集合
        return cateVoList;
    }

    /**
     * 获得third端大区APP端分类下的所有的子分类
     *
     * @param pb         分页辅助类
     * @param selectBean
     * @return 整理好的分类列表
     */
    @Override
    public List<Object> getRegionalAPPCateList(PageBean pb, SelectBean selectBean) {
        return null;
    }

    /**
     * 获得third端门店PC端分类下的所有的子分类
     *
     * @param pb         分页辅助类
     * @param selectBean
     * @return 整理好的分类列表
     */
    @Override
    public List<Object> getStorePCCateList(PageBean pb, SelectBean selectBean) {
        return null;
    }

    /**
     * 获得third端门店APP端分类下的所有的子分类
     *
     * @param pb         分页辅助类
     * @param selectBean
     * @return 整理好的分类列表
     */
    @Override
    public List<Object> getStoreAPPCateList(PageBean pb, SelectBean selectBean) {
        return null;
    }

    /**
     */
//    @Override
//    public List<Object> getRegionalAPPCateList(PageBean pb, SelectBean selectBean) {
//
//        selectBean.setCondition("");
//        // 创建需要返回的集合
//        List<Object> cateVoList = new ArrayList<Object>();
//        // 根据分页查询所有的父分类的集合
//        List<Object> parentList = this.queryRegionalAPPCateListByPageBean(pb, selectBean).getList();
//        // 查询所有的分类信息
//        List<MenuVo> allCateList = this.pagemapper.queryRegionalAPPAllMenuVo();
//
//        MenuVo menu;
//        MenuVo menuVo;
//
//        // 根据父分类集合循环调用计算的方法，整理出二叉树
//        for (int i = 0; i < parentList.size(); i++) {
//            // 从父分类中取出每一个分类
//            menu = (MenuVo) parentList.get(i);
//            // 创建最上级的分类，并把属性转移给这个分类
//            menuVo = new MenuVo();
//            menuVo.setId(menu.getId());
//            menuVo.setGrade(menu.getGrade());
//            menuVo.setDesignation(menu.getDesignation());
//            menuVo.setParentId(menu.getParentId());
//            menuVo.setUrl(menu.getUrl());
//            menuVo.setSort(menu.getSort());
//            // 根据取得的父分类ID和所有的分类列表计算分类实体，并添加到需要返回的集合中
//            menuVo.setMenuVos(this.calcCateVo(menuVo.getId(), allCateList));
//            cateVoList.add(menuVo);
//        }
//        // 返回整理好的分类集合
//        return cateVoList;
//    }

//    /**
//     */
//    @Override
//    public List<Object> getStorePCCateList(PageBean pb, SelectBean selectBean) {
//
//        selectBean.setCondition("");
//        // 创建需要返回的集合
//        List<Object> cateVoList = new ArrayList<Object>();
//        // 根据分页查询所有的父分类的集合
//        List<Object> parentList = this.queryStorePCCateListByPageBean(pb, selectBean).getList();
//        // 查询所有的分类信息
//        List<MenuVo> allCateList = this.pagemapper.queryStorePCAllMenuVo();
//
//        MenuVo menu;
//        MenuVo menuVo;
//
//        // 根据父分类集合循环调用计算的方法，整理出二叉树
//        for (int i = 0; i < parentList.size(); i++) {
//            // 从父分类中取出每一个分类
//            menu = (MenuVo) parentList.get(i);
//            // 创建最上级的分类，并把属性转移给这个分类
//            menuVo = new MenuVo();
//            menuVo.setId(menu.getId());
//            menuVo.setGrade(menu.getGrade());
//            menuVo.setDesignation(menu.getDesignation());
//            menuVo.setParentId(menu.getParentId());
//            menuVo.setUrl(menu.getUrl());
//            menuVo.setSort(menu.getSort());
//            // 根据取得的父分类ID和所有的分类列表计算分类实体，并添加到需要返回的集合中
//            menuVo.setMenuVos(this.calcCateVo(menuVo.getId(), allCateList));
//            cateVoList.add(menuVo);
//        }
//        // 返回整理好的分类集合
//        return cateVoList;
//    }

//    /**
//     */
//    @Override
//    public List<Object> getStoreAPPCateList(PageBean pb, SelectBean selectBean) {
//
//        selectBean.setCondition("");
//        // 创建需要返回的集合
//        List<Object> cateVoList = new ArrayList<Object>();
//        // 根据分页查询所有的父分类的集合
//        List<Object> parentList = this.queryStoreAPPCateListByPageBean(pb, selectBean).getList();
//        // 查询所有的分类信息
//        List<MenuVo> allCateList = this.pagemapper.queryStoreAPPAllMenuVo();
//
//        MenuVo menu;
//        MenuVo menuVo;
//
//        // 根据父分类集合循环调用计算的方法，整理出二叉树
//        for (int i = 0; i < parentList.size(); i++) {
//            // 从父分类中取出每一个分类
//            menu = (MenuVo) parentList.get(i);
//            // 创建最上级的分类，并把属性转移给这个分类
//            menuVo = new MenuVo();
//            menuVo.setId(menu.getId());
//            menuVo.setGrade(menu.getGrade());
//            menuVo.setDesignation(menu.getDesignation());
//            menuVo.setParentId(menu.getParentId());
//            menuVo.setUrl(menu.getUrl());
//            menuVo.setSort(menu.getSort());
//            // 根据取得的父分类ID和所有的分类列表计算分类实体，并添加到需要返回的集合中
//            menuVo.setMenuVos(this.calcCateVo(menuVo.getId(), allCateList));
//            cateVoList.add(menuVo);
//        }
//        // 返回整理好的分类集合
//        return cateVoList;
//    }

    /**
     */
    @Override
    public List<MenuVo> calcCateVo(Long parentId, List<MenuVo> allmenuVo) {
        List<MenuVo> cateVoList = new ArrayList<MenuVo>();
        // 需要返回的分类实体
        MenuVo cateVo;
        // 返回的分类实体的所有子分类
        List<MenuVo> allSonCate;
        // 循环中的迭代分类
        MenuVo cate;
        // 进行递归
        for (int i = 0; i < allmenuVo.size(); i++) {
            if (parentId.equals(allmenuVo.get(i).getParentId())) {
                // 必须在这里new对象 否则会覆盖原先的数据
                cate = allmenuVo.get(i);
                // 创建最上级的分类，并把属性转移给这个分类
                cateVo = new MenuVo();
                cateVo.setId(cate.getId());
                cateVo.setGrade(cate.getGrade());
                cateVo.setDesignation(cate.getDesignation());
                cateVo.setParentId(cate.getParentId());
                cateVo.setUrl(cate.getUrl());
                cateVo.setSort(cate.getSort());
                // 执行递归
                allSonCate = calcCateVo(cate.getId(), allmenuVo);
                cateVo.setMenuVos(allSonCate);
                cateVoList.add(cateVo);
            }
        }
        // 返回计算好的所有的子分类列表
        return cateVoList;

    }

    /**
     */
    @Override
    public List<MenuVo> queryAllParentMenuVo() {
        return pagemapper.queryAllParentMenuVo();
    }

    /**
     */
    @Override
    public List<MenuVo> queryAllChildrenMenuVo() {
        return pagemapper.queryAllChildrenMenuVo();
    }

    /**
     */
    @Override
    public List<MenuVo> queryAllParentMenuVoByLogin(Long managerId) {

        return pagemapper.queryAllParentMenuVoByLogin(managerId);
    }

    /**
     * 查询当前分类
     */
    @Override
    public int newBatchDelPage(Long pageId) {
        int count = 0;
        List<MenuVo> allCateList = this.pagemapper.queryAllMenuVo();
        List<Long> pageIds = calcCatePage(pageId, allCateList, new ArrayList<Long>());
        pageIds.add(pageId);
        for (int i = 0; i < pageIds.size(); i++) {
            count += delPage(pageIds.get(i));
        }
        return count;
    }

    /**
     * 查询当前分类(管理third端大区PC端菜单)
     */
    @Override
    public int newRegionalPCBatchDelPage(Long pageId) {
        int count = 0;
        List<MenuVo> allCateList = this.pagemapper.queryRegionalPCAllMenuVo();
        List<Long> pageIds = calcCatePage(pageId, allCateList, new ArrayList<Long>());
        pageIds.add(pageId);
        for (int i = 0; i < pageIds.size(); i++) {
            count += delRegionalPCPage(pageIds.get(i));
        }
        return count;
    }

    /**
     * 新Boss删除菜单(管理third端大区APP端菜单)
     *
     * @param pageId
     * @return int
     */
    @Override
    public int newRegionalAPPBatchDelPage(Long pageId) {
        return 0;
    }

    /**
     * 新Boss删除菜单(管理third端门店PC端菜单)
     *
     * @param pageId
     * @return int
     */
    @Override
    public int newStorePCBatchDelPage(Long pageId) {
        return 0;
    }

    /**
     * 新Boss删除菜单(管理third端门店APP端菜单)
     *
     * @param pageId
     * @return int
     */
    @Override
    public int newStoreAPPBatchDelPage(Long pageId) {
        return 0;
    }

//    /**
//     * 查询当前分类(管理third端大区APP端菜单)
//     */
//    @Override
//    public int newRegionalAPPBatchDelPage(Long pageId) {
//        int count = 0;
//        List<MenuVo> allCateList = this.pagemapper.queryRegionalAPPAllMenuVo();
//        List<Long> pageIds = calcCatePage(pageId, allCateList, new ArrayList<Long>());
//        pageIds.add(pageId);
//        for (int i = 0; i < pageIds.size(); i++) {
//            count += delRegionalAPPPage(pageIds.get(i));
//        }
//        return count;
//    }

//    /**
//     * 查询当前分类(管理third端门店PC端菜单)
//     */
//    @Override
//    public int newStorePCBatchDelPage(Long pageId) {
//        int count = 0;
//        List<MenuVo> allCateList = this.pagemapper.queryStorePCAllMenuVo();
//        List<Long> pageIds = calcCatePage(pageId, allCateList, new ArrayList<Long>());
//        pageIds.add(pageId);
//        for (int i = 0; i < pageIds.size(); i++) {
//            count += delStorePCPage(pageIds.get(i));
//        }
//        return count;
//    }

//    /**
//     * 查询当前分类(管理third端门店APP端菜单)
//     */
//    @Override
//    public int newStoreAPPBatchDelPage(Long pageId) {
//        int count = 0;
//        List<MenuVo> allCateList = this.pagemapper.queryStoreAPPAllMenuVo();
//        List<Long> pageIds = calcCatePage(pageId, allCateList, new ArrayList<Long>());
//        pageIds.add(pageId);
//        for (int i = 0; i < pageIds.size(); i++) {
//            count += delStoreAPPPage(pageIds.get(i));
//        }
//        return count;
//    }

    /**
     * 查询bundleName的菜单
     * 
     * @param bundleName
     *            模块配置的bundleName
     * @return 菜单集合 List
     */
    @Override
    public List<MenuVo> queryMenuByBundleName(String bundleName) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("bundleName", bundleName);
        return this.pagemapper.queryMenuByBundleName(paramMap);
    }

    /**
     * 删除bundleName的菜单
     * 
     * @param bundleName
     *            模块配置的bundleName
     */
    @Override
    public void deleteMenuByBundleName(String bundleName) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("bundleName", bundleName);
        this.pagemapper.deleteMenuByBundleName(paramMap);
    }

    /**
     * 递归获取选中的菜单
     * 
     * @param pageId
     *            当前ID
     * @param allCateList
     *            所有菜单
     * @param list
     *            返回菜单
     * @return List
     */
    public List<Long> calcCatePage(Long pageId, List<MenuVo> allCateList, List<Long> list) {

        if (allCateList != null) {
            for (int i = 0; i < allCateList.size(); i++) {
                if (pageId.equals(allCateList.get(i).getParentId())) {
                    list.add(allCateList.get(i).getId());
                    calcCatePage(allCateList.get(i).getId(), allCateList, list);
                }
            }

        }

        return list;
    }

}
