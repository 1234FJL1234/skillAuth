/*


 */

package edu.njrs.manager.controller;

import edu.njrs.common.util.MyLogger;
import edu.njrs.common.util.PageBean;
import edu.njrs.common.util.SelectBean;
import edu.njrs.manager.bean.MenuVo;
import edu.njrs.manager.bean.Page;
import edu.njrs.manager.service.PageServiceInterface;
import edu.njrs.manager.service.impl.MenuService;
import edu.njrs.manager.util.ManagerValueUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 菜单控制器
 * 
 * @author IShopTeam
 * @since 2014年1月8日 下午10:42:23
 * @version 1.0
 */
@Controller
public class PageController {
    @Resource(name = "PageService")
    private PageServiceInterface pageserviceInterface;
    @Resource(name = "menuServiceInterface")
    private MenuService menuServiceInterface;

    /**
     * 记录日志对象
     */
    private static final MyLogger LOGGER = new MyLogger(PageController.class);

    /**
     * 删除Page
     *
     * @param pageId 待删除的PageId
     */
    @RequestMapping("/delPage")
    public ModelAndView delPage(Long pageId, String active) {
        // 非空验证 页面ID
        if (null != pageId) {
            // 获取页面对象
            Page page = pageserviceInterface.queryPageByPrimaryKey(pageId);
            // 验证页面名称是否为空
            if (null != page.getDesignation()) {
                LOGGER.info("删除【" + page.getDesignation() + "】页面");
            }
        }
        this.pageserviceInterface.delPage(pageId);
        if (active != null) {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.INITSETTING));
        } else {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.JUMPFORPAGEVIEW));
        }
    }

    /**
     * 删除Page(管理third端大区PC端菜单)
     *
     * @param pageId 待删除的PageId
     */
    @RequestMapping("/delRegionalPCPage")
    public ModelAndView delRegionalPCPage(Long pageId, String active) {
        // 非空验证 页面ID
        if (null != pageId) {
            // 获取页面对象
            Page page = pageserviceInterface.queryRegionalPCPageByPrimaryKey(pageId);
            // 验证页面名称是否为空
            if (null != page.getDesignation()) {
                LOGGER.info("删除【" + page.getDesignation() + "】页面");
            }
        }
        this.pageserviceInterface.delRegionalPCPage(pageId);
        if (active != null) {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.INITREGIONALPCSETTING));
        } else {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.JUMPFORPAGEVIEW));
        }
    }

    /**
     * 删除Page(管理third端大区APP端菜单)
     *
     * @param pageId 待删除的PageId
     */
    @RequestMapping("/delRegionalAPPPage")
    public ModelAndView delRegionalAPPPage(Long pageId, String active) {
        // 非空验证 页面ID
        if (null != pageId) {
            // 获取页面对象
            Page page = pageserviceInterface.queryRegionalAPPPageByPrimaryKey(pageId);
            // 验证页面名称是否为空
            if (null != page.getDesignation()) {
                LOGGER.info("删除【" + page.getDesignation() + "】页面");
            }
        }
        this.pageserviceInterface.delRegionalAPPPage(pageId);
        if (active != null) {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.INITREGIONALAPPSETTING));
        } else {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.JUMPFORPAGEVIEW));
        }
    }

    /**
     * 删除Page(管理third端门店PC端菜单)
     *
     * @param pageId 待删除的PageId
     */
    @RequestMapping("/delStorePCPage")
    public ModelAndView delStorePCPage(Long pageId, String active) {
        // 非空验证 页面ID
        if (null != pageId) {
            // 获取页面对象
            Page page = pageserviceInterface.queryStorePCPageByPrimaryKey(pageId);
            // 验证页面名称是否为空
            if (null != page.getDesignation()) {
                LOGGER.info("删除【" + page.getDesignation() + "】页面");
            }
        }
        this.pageserviceInterface.delStorePCPage(pageId);
        if (active != null) {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.INITSTOREPCSETTING));
        } else {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.JUMPFORPAGEVIEW));
        }
    }

    /**
     * 删除Page(管理third端门店APP端菜单)
     *
     * @param pageId 待删除的PageId
     */
    @RequestMapping("/delStoreAPPPage")
    public ModelAndView delStoreAPPPage(Long pageId, String active) {
        // 非空验证 页面ID
        if (null != pageId) {
            // 获取页面对象
            Page page = pageserviceInterface.queryStoreAPPPageByPrimaryKey(pageId);
            // 验证页面名称是否为空
            if (null != page.getDesignation()) {
                LOGGER.info("删除【" + page.getDesignation() + "】页面");
            }
        }
        this.pageserviceInterface.delStoreAPPPage(pageId);
        if (active != null) {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.INITSTOREAPPSETTING));
        } else {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.JUMPFORPAGEVIEW));
        }
    }

    /**
     * 批量删除Page
     *
     * @param pageIds 待删除的PageID数组
     */
    @RequestMapping("/batchDelPage")
    public ModelAndView batchDelPage(Long[] pageIds, String active, Long pageId) {
        if (active == null) {
            // 旧的Boss
            this.pageserviceInterface.batchDelPage(pageIds);
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.JUMPFORPAGEVIEW));
        } else {
            // 新Boss删除菜单
            this.pageserviceInterface.newBatchDelPage(pageId);
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.INITSETTING));
        }

    }

    /**
     * 批量删除Page(管理third端大区PC端菜单)
     *
     * @param pageIds 待删除的PageID数组
     */
    @RequestMapping("/batchRegionalPCDelPage")
    public ModelAndView batchRegionalPCDelPage(Long[] pageIds, String active, Long pageId) {
        if (active == null) {
            // 旧的Boss
            this.pageserviceInterface.batchRegionalPCDelPage(pageIds);
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.JUMPFORPAGEVIEW));
        } else {
            // 新Boss删除菜单
            this.pageserviceInterface.newRegionalPCBatchDelPage(pageId);
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.INITREGIONALPCSETTING));
        }

    }

    /**
     * 批量删除Page(管理third端大区APP端菜单)
     *
     * @param pageIds 待删除的PageID数组
     */
    @RequestMapping("/batchRegionalAPPDelPage")
    public ModelAndView batchRegionalAPPDelPage(Long[] pageIds, String active, Long pageId) {
        if (active == null) {
            // 旧的Boss
            this.pageserviceInterface.batchRegionalAPPDelPage(pageIds);
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.JUMPFORPAGEVIEW));
        } else {
            // 新Boss删除菜单
            this.pageserviceInterface.newRegionalAPPBatchDelPage(pageId);
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.INITREGIONALAPPSETTING));
        }

    }

    /**
     * 批量删除Page(管理third端门店PC端菜单)
     *
     * @param pageIds 待删除的PageID数组
     */
    @RequestMapping("/batchStorePCDelPage")
    public ModelAndView batchStorePCDelPage(Long[] pageIds, String active, Long pageId) {
        if (active == null) {
            // 旧的Boss
            this.pageserviceInterface.batchStorePCDelPage(pageIds);
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.JUMPFORPAGEVIEW));
        } else {
            // 新Boss删除菜单
            this.pageserviceInterface.newStorePCBatchDelPage(pageId);
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.INITSTOREPCSETTING));
        }

    }

    /**
     * 批量删除Page(管理third端门店APP端菜单)
     *
     * @param pageIds 待删除的PageID数组
     */
    @RequestMapping("/batchStoreAPPDelPage")
    public ModelAndView batchStoreAPPDelPage(Long[] pageIds, String active, Long pageId) {
        if (active == null) {
            // 旧的Boss
            this.pageserviceInterface.batchStoreAPPDelPage(pageIds);
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.JUMPFORPAGEVIEW));
        } else {
            // 新Boss删除菜单
            this.pageserviceInterface.newStoreAPPBatchDelPage(pageId);
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.INITSTOREAPPSETTING));
        }

    }

    /**
     * 增加Page
     *
     * @param page 待增加的Page实体
     */
    @RequestMapping("/savePage")
    public ModelAndView savePage(Page page, String active,
                                 HttpServletRequest request) {
        // 验证页面名称是否为空
        if (null != page.getDesignation()) {
            LOGGER.info("增加【" + page.getDesignation() + "】页面");
        }
        this.pageserviceInterface.savePage(page);
//        OperaLogUtil.addOperaLog(multipartRequest, (String) multipartRequest.getSession().getAttribute("name"), "增加Page", "增加Page" + ",增加【" + page.getDesignation()+"】界面,用户名:"+(String) multipartRequest.getSession().getAttribute("name"));
        if (active != null) {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.INITSETTING));
        } else {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.JUMPFORPAGEVIEW));
        }

    }

    /**
     * 增加Page(管理third端大区PC端菜单)
     *
     * @param page 待增加的Page实体
     */
    @RequestMapping("/saveRegionalPCPage")
    public ModelAndView saveRegionalPCPage(Page page, String active,
                                 MultipartHttpServletRequest multipartRequest,
                                 HttpServletRequest request) {
        // 验证页面名称是否为空
        if (null != page.getDesignation()) {
            LOGGER.info("增加【" + page.getDesignation() + "】页面");
        }
        this.pageserviceInterface.saveRegionalPCPage(page);
        this.pageserviceInterface.linkRegionalAuthorityAndPage(page.getDesignation());
//        OperaLogUtil.addOperaLog(multipartRequest, (String) multipartRequest.getSession().getAttribute("name"), "增加Page(third端大区PC)", "增加Page" + ",增加【" + page.getDesignation()+"】界面,用户名:"+(String) multipartRequest.getSession().getAttribute("name"));
        if (active != null) {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.INITREGIONALPCSETTING));
        } else {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.JUMPFORPAGEVIEW));
        }

    }

    /**
     * 增加Page(管理third端大区APP端菜单)
     *
     * @param page 待增加的Page实体
     */
    @RequestMapping("/saveRegionalAPPPage")
    public ModelAndView saveRegionalAPPPage(Page page, String active,
                                           MultipartHttpServletRequest multipartRequest,
                                           HttpServletRequest request) {
        // 验证页面名称是否为空
        if (null != page.getDesignation()) {
            LOGGER.info("增加【" + page.getDesignation() + "】页面");
        }
        this.pageserviceInterface.saveRegionalAPPPage(page);
        this.pageserviceInterface.linkRegionalAuthorityAndPage(page.getDesignation());
//        OperaLogUtil.addOperaLog(multipartRequest, (String) multipartRequest.getSession().getAttribute("name"), "增加Page(third端大区APP)", "增加Page" + ",增加【" + page.getDesignation()+"】界面,用户名:"+(String) multipartRequest.getSession().getAttribute("name"));
        if (active != null) {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.INITREGIONALAPPSETTING));
        } else {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.JUMPFORPAGEVIEW));
        }

    }

    /**
     * 增加Page(管理third端门店PC端菜单)
     *
     * @param page 待增加的Page实体
     */
    @RequestMapping("/saveStorePCPage")
    public ModelAndView saveStorePCPage(Page page, String active,
                                      MultipartHttpServletRequest multipartRequest,
                                      HttpServletRequest request) {
        // 验证页面名称是否为空
        if (null != page.getDesignation()) {
            LOGGER.info("增加【" + page.getDesignation() + "】页面");
        }
        this.pageserviceInterface.saveStorePCPage(page);
        this.pageserviceInterface.linkStoreAuthorityAndPage(page.getDesignation());
//        OperaLogUtil.addOperaLog(multipartRequest, (String) multipartRequest.getSession().getAttribute("name"), "增加Page(third端门店PC)", "增加Page" + ",增加【" + page.getDesignation()+"】界面,用户名:"+(String) multipartRequest.getSession().getAttribute("name"));
        if (active != null) {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.INITSTOREPCSETTING));
        } else {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.JUMPFORPAGEVIEW));
        }

    }

    /**
     * 增加Page(管理third端门店APP端菜单)
     *
     * @param page 待增加的Page实体
     */
    @RequestMapping("/saveStoreAPPPage")
    public ModelAndView saveStoreAPPPage(Page page, String active,
                                        MultipartHttpServletRequest multipartRequest,
                                        HttpServletRequest request) {
        // 验证页面名称是否为空
        if (null != page.getDesignation()) {
            LOGGER.info("增加【" + page.getDesignation() + "】页面");
        }
        this.pageserviceInterface.saveStoreAPPPage(page);
        this.pageserviceInterface.linkStoreAuthorityAndPage(page.getDesignation());
//        OperaLogUtil.addOperaLog(multipartRequest, (String) multipartRequest.getSession().getAttribute("name"), "增加Page(third端门店APP)", "增加Page" + ",增加【" + page.getDesignation()+"】界面,用户名:"+(String) multipartRequest.getSession().getAttribute("name"));
        if (active != null) {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.INITSTOREAPPSETTING));
        } else {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.JUMPFORPAGEVIEW));
        }

    }

    /**
     * 设置会员头像 若前断没有选择图片 则不上传
     * <p>
     * 会员详细信息
     *
     * @param request
     * @param multipartRequest
     */
    public void setPageImgUrl1(Page page, HttpServletRequest request,
                               MultipartHttpServletRequest multipartRequest) {
//        String imgUrl = "";
//        String imgUrlSelected = "";
//        // 设置会员头像 若前断没有选择图片 则不上传
//        if (multipartRequest.getFile(Constants.IMGURL) != null
//                && !"".equals(multipartRequest.getFile(Constants.IMGURL)
//                .getOriginalFilename())) {
//            // 使用上传后路径
//            imgUrl = UploadUtil.uploadFileOne(
//                    multipartRequest.getFile(Constants.IMGURL), request);
//        }
//        if (multipartRequest.getFile(Constants.IMGURLSELECTED) != null
//                && !"".equals(multipartRequest
//                .getFile(Constants.IMGURLSELECTED)
//                .getOriginalFilename())) {
//            // 使用上传后路径
//            imgUrlSelected = UploadUtil
//                    .uploadFileOne(
//                            multipartRequest.getFile(Constants.IMGURLSELECTED),
//                            request);
//        }
//        page.setImgUrl(imgUrl);
//        page.setImgUrlSelected(imgUrlSelected);
    }

    /**
     * 更新Page
     *
     * @param page 待更新的Page实体
     */
    @RequestMapping("/updatePage")
    public ModelAndView updatePage(Page page, String active,
                                   MultipartHttpServletRequest multipartRequest,
                                   HttpServletRequest request) {
        // 验证页面名称是否为空
        if (null != page.getDesignation()) {
            // 日志记录
            LOGGER.info("更新【" + page.getDesignation() + "】页面");
        }
        this.pageserviceInterface.updatePage(page);
//        OperaLogUtil.addOperaLog(multipartRequest, (String) multipartRequest.getSession().getAttribute("name"), "更新Page", "更新Page" + ",更新【" + page.getDesignation()+"】界面,用户名:"+(String) multipartRequest.getSession().getAttribute("name"));
        if (active != null) {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.INITSETTING));
        } else {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.JUMPFORPAGEVIEW));
        }
    }

    /**
     * 更新Page(管理third端大区PC端菜单)
     *
     * @param page 待更新的Page实体
     */
    @RequestMapping("/updateRegionalPCPage")
    public ModelAndView updateRegionalPCPage(Page page, String active,
                                   MultipartHttpServletRequest multipartRequest,
                                   HttpServletRequest request) {
        // 验证页面名称是否为空
        if (null != page.getDesignation()) {
            // 日志记录
            LOGGER.info("更新【" + page.getDesignation() + "】页面");
        }
        this.pageserviceInterface.updateRegionalPCPage(page);
//        OperaLogUtil.addOperaLog(multipartRequest, (String) multipartRequest.getSession().getAttribute("name"), "更新Page(third端大区PC)", "更新Page" + ",更新【" + page.getDesignation()+"】界面,用户名:"+(String) multipartRequest.getSession().getAttribute("name"));
        if (active != null) {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.INITREGIONALPCSETTING));
        } else {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.JUMPFORPAGEVIEW));
        }
    }

    /**
     * 更新Page(管理third端大区APP端菜单)
     *
     * @param page 待更新的Page实体
     */
    @RequestMapping("/updateRegionalAPPPage")
    public ModelAndView updateRegionalAPPPage(Page page, String active,
                                             MultipartHttpServletRequest multipartRequest,
                                             HttpServletRequest request) {
        // 验证页面名称是否为空
        if (null != page.getDesignation()) {
            // 日志记录
            LOGGER.info("更新【" + page.getDesignation() + "】页面");
        }
        this.pageserviceInterface.updateRegionalAPPPage(page);
//        OperaLogUtil.addOperaLog(multipartRequest, (String) multipartRequest.getSession().getAttribute("name"), "更新Page(third端大区APP)", "更新Page" + ",更新【" + page.getDesignation()+"】界面,用户名:"+(String) multipartRequest.getSession().getAttribute("name"));
        if (active != null) {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.INITREGIONALAPPSETTING));
        } else {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.JUMPFORPAGEVIEW));
        }
    }

    /**
     * 更新Page(管理third端门店PC端菜单)
     *
     * @param page 待更新的Page实体
     */
    @RequestMapping("/updateStorePCPage")
    public ModelAndView updateStorePCPage(Page page, String active,
                                          MultipartHttpServletRequest multipartRequest,
                                          HttpServletRequest request) {
        // 验证页面名称是否为空
        if (null != page.getDesignation()) {
            // 日志记录
            LOGGER.info("更新【" + page.getDesignation() + "】页面");
        }
        this.pageserviceInterface.updateStorePCPage(page);
//        OperaLogUtil.addOperaLog(multipartRequest, (String) multipartRequest.getSession().getAttribute("name"), "更新Page(third端门店PC)", "更新Page" + ",更新【" + page.getDesignation()+"】界面,用户名:"+(String) multipartRequest.getSession().getAttribute("name"));
        if (active != null) {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.INITSTOREPCSETTING));
        } else {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.JUMPFORPAGEVIEW));
        }
    }

    /**
     * 更新Page(管理third端门店APP端菜单)
     *
     * @param page 待更新的Page实体
     */
    @RequestMapping("/updateStoreAPPPage")
    public ModelAndView updateStoreAPPPage(Page page, String active,
                                          MultipartHttpServletRequest multipartRequest,
                                          HttpServletRequest request) {
        // 验证页面名称是否为空
        if (null != page.getDesignation()) {
            // 日志记录
            LOGGER.info("更新【" + page.getDesignation() + "】页面");
        }
        this.pageserviceInterface.updateStoreAPPPage(page);
//        OperaLogUtil.addOperaLog(multipartRequest, (String) multipartRequest.getSession().getAttribute("name"), "更新Page(third端门店APP)", "更新Page" + ",更新【" + page.getDesignation()+"】界面,用户名:"+(String) multipartRequest.getSession().getAttribute("name"));
        if (active != null) {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.INITSTOREAPPSETTING));
        } else {
            return new ModelAndView(new RedirectView(
                    ManagerValueUtil.JUMPFORPAGEVIEW));
        }
    }

    /**
     * 根据主键查询实体
     *
     * @param pageId 主键ID
     */
    @RequestMapping("/queryPageById")
    @ResponseBody
    public Page queryPageById(Long pageId) {
        Page page = this.pageserviceInterface.queryPageByPrimaryKey(pageId);
        // 验证页面名称是否为空
        if (null != page.getDesignation()) {
            // 日志记录
            LOGGER.info("获取【" + page.getDesignation() + "】页面的信息");
        }
        return page;
    }

    /**
     * 根据主键查询实体(管理third端大区PC端菜单)
     *
     * @param pageId 主键ID
     */
    @RequestMapping("/queryRegionalPCPageById")
    @ResponseBody
    public Page queryRegionalPCPageById(Long pageId) {
        Page page = this.pageserviceInterface.queryRegionalPCPageByPrimaryKey(pageId);
        // 验证页面名称是否为空
        if (null != page.getDesignation()) {
            // 日志记录
            LOGGER.info("获取【" + page.getDesignation() + "】页面的信息");
        }
        return page;
    }

    /**
     * 根据主键查询实体(管理third端大区APP端菜单)
     *
     * @param pageId 主键ID
     */
    @RequestMapping("/queryRegionalAPPPageById")
    @ResponseBody
    public Page queryRegionalAPPPageById(Long pageId) {
        Page page = this.pageserviceInterface.queryRegionalAPPPageByPrimaryKey(pageId);
        // 验证页面名称是否为空
        if (null != page.getDesignation()) {
            // 日志记录
            LOGGER.info("获取【" + page.getDesignation() + "】页面的信息");
        }
        return page;
    }

    /**
     * 根据主键查询实体(管理third端门店PC端菜单)
     *
     * @param pageId 主键ID
     */
    @RequestMapping("/queryStorePCPageById")
    @ResponseBody
    public Page queryStorePCPageById(Long pageId) {
        Page page = this.pageserviceInterface.queryStorePCPageByPrimaryKey(pageId);
        // 验证页面名称是否为空
        if (null != page.getDesignation()) {
            // 日志记录
            LOGGER.info("获取【" + page.getDesignation() + "】页面的信息");
        }
        return page;
    }

    /**
     * 根据主键查询实体(管理third端门店APP端菜单)
     *
     * @param pageId 主键ID
     */
    @RequestMapping("/queryStoreAPPPageById")
    @ResponseBody
    public Page queryStorePageById(Long pageId) {
        Page page = this.pageserviceInterface.queryStoreAPPPageByPrimaryKey(pageId);
        // 验证页面名称是否为空
        if (null != page.getDesignation()) {
            // 日志记录
            LOGGER.info("获取【" + page.getDesignation() + "】页面的信息");
        }
        return page;
    }

    /**
     * 验证是否可以删除
     *
     * @param pageId 待验证的菜单ID
     * @return 验证的结果
     */
    @RequestMapping("/checkDelPage")
    @ResponseBody
    public boolean checkDel(Long pageId) {
        // 验证是否可以删除
        return this.pageserviceInterface.checkDelWithPageId(pageId);
    }

    /**
     * 查询所有的Page
     *
     * @return 查询到的列表
     */
    @RequestMapping("/queryAllMenuVo")
    @ResponseBody
    public List<MenuVo> queruAllPage() {
        // 查询到的列表
        return this.pageserviceInterface.queryAllMenuVo();
    }

    /**
     * 查询third端大区PC端菜单所有的Page
     *
     * @return 查询到的列表
     */
    @RequestMapping("/queryRegionalPCAllMenuVo")
    @ResponseBody
    public List<MenuVo> queryRegionalPCAllPage() {
        // 查询到的列表
        return this.pageserviceInterface.queryRegionalPCAllMenuVo();
    }

    /**
     * 查询third端大区APP端菜单所有的Page
     *
     * @return 查询到的列表
     */
    @RequestMapping("/queryRegionalAPPAllMenuVo")
    @ResponseBody
    public List<MenuVo> queryRegionalAPPAllPage() {
        // 查询到的列表
        return this.pageserviceInterface.queryRegionalAPPAllMenuVo();
    }

    /**
     * 查询third端门店PC端菜单所有的Page
     *
     * @return 查询到的列表
     */
    @RequestMapping("/queryStorePCAllMenuVo")
    @ResponseBody
    public List<MenuVo> queryStorePCAllPage() {
        // 查询到的列表
        return this.pageserviceInterface.queryStorePCAllMenuVo();
    }

    /**
     * 查询third端门店APP端菜单所有的Page
     *
     * @return 查询到的列表
     */
    @RequestMapping("/queryStoreAPPAllMenuVo")
    @ResponseBody
    public List<MenuVo> queryStoreAPPAllPage() {
        // 查询到的列表
        return this.pageserviceInterface.queryStoreAPPAllMenuVo();
    }

    /**
     * 根据 参数查询page并通过AJAX返回
     *
     * @param pb         分页帮助类
     * @param selectBean 查询帮助类
     * @return PageBean
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/queryMenuVoList")
    @ResponseBody
    public PageBean queryMenuVoList(PageBean pb, SelectBean selectBean)
            throws UnsupportedEncodingException {
        pb.setList(this.pageserviceInterface.getCateList(pb, selectBean));
        return pb;
    }

    /**
     * 根据 参数查询third端大区PC端菜单page并通过AJAX返回
     *
     * @param pb         分页帮助类
     * @param selectBean 查询帮助类
     * @return PageBean
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/queryRegionalPCMenuVoList")
    @ResponseBody
    public PageBean queryRegionalPCMenuVoList(PageBean pb, SelectBean selectBean)
            throws UnsupportedEncodingException {
        pb.setList(this.pageserviceInterface.getRegionalPCCateList(pb, selectBean));
        return pb;
    }

    /**
     * 根据 参数查询third端大区APP端菜单page并通过AJAX返回
     *
     * @param pb         分页帮助类
     * @param selectBean 查询帮助类
     * @return PageBean
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/queryRegionalAPPMenuVoList")
    @ResponseBody
    public PageBean queryRegionalAPPMenuVoList(PageBean pb, SelectBean selectBean)
            throws UnsupportedEncodingException {
        pb.setList(this.pageserviceInterface.getRegionalAPPCateList(pb, selectBean));
        return pb;
    }

    /**
     * 根据 参数查询third端门店PC端菜单page并通过AJAX返回
     *
     * @param pb         分页帮助类
     * @param selectBean 查询帮助类
     * @return PageBean
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/queryStorePCMenuVoList")
    @ResponseBody
    public PageBean queryStorePCMenuVoList(PageBean pb, SelectBean selectBean)
            throws UnsupportedEncodingException {
        pb.setList(this.pageserviceInterface.getStorePCCateList(pb, selectBean));
        return pb;
    }

    /**
     * 根据 参数查询third端门店APP端菜单page并通过AJAX返回
     *
     * @param pb         分页帮助类
     * @param selectBean 查询帮助类
     * @return PageBean
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/queryStoreAPPMenuVoList")
    @ResponseBody
    public PageBean queryStoreAPPMenuVoList(PageBean pb, SelectBean selectBean)
            throws UnsupportedEncodingException {
        pb.setList(this.pageserviceInterface.getStoreAPPCateList(pb, selectBean));
        return pb;
    }

    /**
     * 跳转到page管理的视图
     */
    @RequestMapping("/jumpForPageView")
    public ModelAndView jumpForPageView() {
        return new ModelAndView("jsp/core/manager/menu_list");
    }

    /**
     * 获取所有菜单
     *
     * @return List
     */
    @RequestMapping("/queryAllMenu")
    @ResponseBody
    public List<MenuVo> queryAllMenu() {
        return menuServiceInterface.getAllMenu();
    }

    /**
     * 查询当前全下的菜单
     *
     * @param request
     * @return List
     */
    @RequestMapping("/queryAllMenuByLogin")
    @ResponseBody
    public List<MenuVo> queryAllMenuByLogin(HttpServletRequest request) {
        return menuServiceInterface.getAllMenuByLogin((Long) request
                .getSession().getAttribute("loginUserId"));
    }

}
