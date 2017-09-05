package edu.njrs.manager.controller;


import edu.njrs.common.util.MyLogger;
import edu.njrs.common.util.PageBean;
import edu.njrs.manager.bean.Authority;
import edu.njrs.manager.bean.Manager;
import edu.njrs.manager.bean.ManagerAuthority;
import edu.njrs.manager.bean.MenuVo;
import edu.njrs.manager.mapper.AuthorityMapper;
import edu.njrs.manager.service.ManagerServiceInterface;
import edu.njrs.manager.service.MenuServiceInterface;
import net.sf.json.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.WebUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 管理员控制器
 *
 */
@Controller("managerController")
public class ManagerController {

    /**
     * 日志记录 *
     */
    private static final MyLogger LOGGER = new MyLogger(ManagerController.class);

    private static final String MANAGER = "manager";
    private static final String LOGINUSERID = "loginUserId";
    private static final String INITMANAGER_HTM = "initManager.htm";
    private static final String CHECKTYPE = "checkType";
    private static final String CHECKSUCCESS = "checkSuccess";

    private MenuServiceInterface menuServiceInterface;

    private ManagerServiceInterface managerService;

    private static final int HTHOUSAND = 100000;

    private static final String NAME = "name";


    @Resource(name = "authorityMapper")
    private AuthorityMapper authorityMapper;

    /**
     * 管理员登陆
     *
     * @return 获取权限跳转地址
     */
    @RequestMapping("/iflogin")
    @ResponseBody
    public int ifLogin(HttpServletRequest request, String name, String password, String code, String patchcaFlag) {


        if ( "1".equals(patchcaFlag) ) {
            if( null == code || !code.equals(request.getSession().getAttribute("PATCHCA"))){
                // 验证码匹配
                return -1;
            }

        }

        // 非空验证 用户名
        if (null != name) {
            LOGGER.info("管理员【" + name + "】登陆");
        }
        return managerService.ifManager(request, name, password);
    }


    /**
     * 跳转页面到首页
     *
     * @param name
     *            用户名
     * @param password
     * @return
     */
    @RequestMapping("/login11")
    public ModelAndView managerLogin(String name, String password) {
        // 跳转首页
        LOGGER.info("跳转到首页");
        return new ModelAndView();
    }


    @RequestMapping("/index")
    public ModelAndView indexPageForward(HttpServletRequest request){
//        Manager manager = managerService.queryManagerByName((String) request.getSession().getAttribute(NAME));
//        List<MenuVo> menuVos = managerService.queryMenuByMangerName(manager.getUsername());
//        Authority authority = authorityMapper.selectAuthByManagerId(manager.getId());
//        WebUtils.setSessionAttribute(request, "menus", menuVos);
//        WebUtils.setSessionAttribute(request, "managerAuthority", authority);
        return new ModelAndView("index/index");
    }

    /**
     * 管理员登陆
     *
     * @return 加载权限菜单
     */
    @RequestMapping("/loadMenus")
    @ResponseBody
    public List<MenuVo> loadMenus(String name) {
        // 非空验证 用户名
        if (null != name) {
            LOGGER.info("管理员【" + name + "】登陆");
        }
        // 加载权限菜单
        return managerService.queryMenuByMangerName(name);
    }

//    /**
//     * 退出登录
//     *
//     * @return ModelAndView
//     */
//    @RequestMapping("/login")
//    public String login(HttpServletRequest request) {
//
//        String loginUsername = (String)WebUtils.getSessionAttribute(request, NAME);
//        if(StringUtils.isNotBlank(loginUsername)){
//            return "redirect:index.htm";
//        }
//        return "jsp/begin";
//    }

    @RequestMapping("/logout")
    public String logOut(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:login.htm";
    }


    /**
     * 加载管理员列表
     *
     * @return 管理员列表
     */
    @RequestMapping("/initManager")
    public ModelAndView initManager(PageBean pageBean, HttpServletRequest request, Manager manager) {
        // 获取管理员标识
        Integer flag = (Integer) request.getSession().getAttribute("managerFlag");
        Long createId = null;
        if (flag != null && flag != 1) {
            // 获取当前登录ID
            createId = (Long) request.getSession().getAttribute(LOGINUSERID);
        }
        pageBean.setUrl(INITMANAGER_HTM);
        // 查询管理员列表
        return new ModelAndView("jsp/core/manager/managerlist").addObject("pageBean", managerService.queryManagerList(manager, pageBean, createId));
    }

    /**
     * 查询所有的管理员信息 ,并以AJAX返回 FOR GOODS--WareHouse
     * <p/>
     *
     * @return
     */
    @RequestMapping("/queryAllManagerForWareHouse")
    @ResponseBody
    public List<Object> queryAllManagerForWareHouse(PageBean pb) {
        pb.setPageSize(HTHOUSAND);
        // 查询所有的管理员信息
        return this.managerService.queryManagerList(new Manager(), pb, null).getList();
    }

    /**
     * 跳转页面
     *
     * @return 设置中心
     */
    @RequestMapping("/initSetting")
    public ModelAndView initSetting() { return new ModelAndView("manager/pageList"); }

    /**
     * 跳转界面
     *
     * @return third端大区PC端菜单管理
     */
    @RequestMapping("/initRegionalPCSetting")
    public ModelAndView initRegionalPCSetting() { return new ModelAndView("jsp/core/manager/settingregionalpccenter"); }

    /**
     * 跳转界面
     *
     * @return third端大区APP端菜单管理
     */
    @RequestMapping("/initRegionalAPPSetting")
    public ModelAndView initRegionalAPPSetting() { return new ModelAndView("jsp/core/manager/settingregionalappcenter"); }

    /**
     * 跳转界面
     *
     * @return third端门店PC端菜单管理
     */
    @RequestMapping("/initStorePCSetting")
    public ModelAndView initStorePCSetting() { return new ModelAndView("jsp/core/manager/settingstorepccenter"); }

    /**
     * 跳转界面
     *
     * @return third端门店APP端菜单管理
     */
    @RequestMapping("/initStoreAPPSetting")
    public ModelAndView initStoreAPPSetting() { return new ModelAndView("jsp/core/manager/settingstoreappcenter"); }

    /**
     * 添加管理员
     *
     * @param manager
     *            管理员信息
     * @param authorityId
     *            权限编号
     * @return
     */
    @RequestMapping("/addManager")
    public ModelAndView addManager(HttpServletRequest request, Manager manager, String authorityId, HttpServletResponse response, MultipartHttpServletRequest multipartRequest) {
        // 非空验证 管理员名称
        if (null != manager.getUsername()) {
            LOGGER.info("新增名称为【" + manager.getUsername() + "】管理员");
        }
        // 设置管理员头像 setImg(manager, multipartRequest);
        Long createId = (Long) request.getSession().getAttribute(LOGINUSERID);
        manager.setCreateId(createId);
        // 插入数据库
        managerService.addManager(manager, authorityId);
        // 插入日志
//        OperaLogUtil.addOperaLog(multipartRequest, (String) multipartRequest.getSession().getAttribute(NAME), "添加管理员", "添加管理员,管理员名:" + manager.getUsername());
        return new ModelAndView(new RedirectView(INITMANAGER_HTM));
    }


    /**
     * 添加管理员(配置私有云演示账号)
     *
     * @param manager
     *            管理员信息
     * @param applyMobilephone
     *            管理员用户名
     * @return
     */
    @RequestMapping("/configManager")
    @ResponseBody
    public Map<String, Object> configManager(String applyMobilephone, Manager manager) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 非空验证 管理员名称
        if (null != manager.getUsername()) {
            LOGGER.info("新增名称为【" + manager.getUsername() + "】管理员");
        }
        // 配置演示账号（插入一条管理员账号）
        /* 设置用户名为手机号码 */
        manager.setUsername(applyMobilephone);
        /* 生成六位数字的随机密码 */
        int num = (int) ((Math.random() * 9 + 1) * 100000);
        manager.setUserkey(((Integer) num).toString());
        // 设置创建人id
        manager.setCreateId(-1L);
        /* 设置authorityId */
        String authorityId = new String("1");
        managerService.addManager(manager, authorityId);
        // 获取刚插入的managerId，并查询出此条记录的详细信息
        Manager configManager = managerService.queryManagerById(manager.getId());
        map.put("configManager", configManager);
        map.put(MANAGER, manager);
        return map;
    }

    /**
     * 查询管理员信息
     *
     * @param request
     *            管理员编号
     * @return
     */
    @RequestMapping("/queryManagerById")
    @ResponseBody
    public Manager queryManagerById(HttpServletRequest request, Long id) {
        if (id != null) {
            // id=(Long) request.getSession().getAttribute(LOGINUSERID);
            Manager manager = managerService.queryManagerById(id);
            manager.setUserkey(null);
            // 非空验证 管理员名称
            if (null != manager.getUsername()) {
                // 日志记录
                LOGGER.info("获取管理员【" + manager.getUsername() + "】的信息");
                return manager;
            }
        }
        return null;

    }

    /**
     * 根据条件查询管理员
     *
     * @param manager
     *            查询条件
     * @param pageBean
     *            查询结果
     * @param attr
     *            查询项
     * @return
     */
    @RequestMapping("/queryByManager")
    public ModelAndView queryByManager(Manager manager, PageBean pageBean, String[] attr) throws UnsupportedEncodingException {
        // 设置页面跳转路径
        pageBean.setUrl("queryByManager.htm");
        // 查询管理员
        return new ModelAndView("jsp/core/manager/managerlist", "pageBean", managerService.queryManagerList(manager, pageBean, null)).addObject(MANAGER, manager).addObject("attr",
                attr);
    }

    /**
     * 删除管理员
     * <p/>
     * 管理员编号
     *
     * @return
     */
    @RequestMapping("/deleteManager")
    public ModelAndView deleteManager(HttpServletRequest request, HttpServletResponse response, Long managerId) {

        PrintWriter pr = null;
        String[] customerIds = null;
        StringBuilder str = new StringBuilder("[");
        String empStr = "";
        try {
            pr = response.getWriter();
            if (managerId != null) {
                customerIds = new String[1];
                customerIds[0] = managerId + "";
                for (String id : customerIds) {
                    str.append(id + ",");
                }
                empStr = str.toString().substring(0, str.length() - 1) + "]";
            } else {
                customerIds = request.getParameterValues("parameterIds[]");
                for (String id : customerIds) {
                    str.append(id + ",");
                }
                empStr = str.toString().substring(0, str.length() - 1) + "]";
            }

            // 删除会员信息 输出信息 0 失败 1成功
            pr.print(managerService.deleteManager(customerIds));

        } catch (IOException e) {
            // 插入日志
//            OperaLogUtil.addOperaException((String) request.getSession().getAttribute(NAME), e, request);
        } finally {
            // 插入日志
//            OperaLogUtil.addOperaLog(request, (String) request.getSession().getAttribute(NAME), "删除管理员", "删除管理员,管理员编号:" + empStr);
            customerIds = null;
            str = null;
            pr = null;
            empStr = null;
        }

        return null;
    }

    /**
     * 删除管理员
     * <p/>
     * 管理员编号
     *
     * @return
     */
    @RequestMapping("/deleteallmanager")
    public ModelAndView deleteAllManager(HttpServletRequest request, HttpServletResponse response) {
        // 删除管理员
        managerService.deleteManager(request.getParameterValues("managerid"));
        return new ModelAndView(new RedirectView(INITMANAGER_HTM));
    }

    /**
     * 停用管理员(私有云停用账号)
     *
     * @param loginName
     *            管理员编号
     * @return
     */
    @RequestMapping("/delCloudManager")
    @ResponseBody
    public Map<String, Object> delCloudManager(String loginName) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 查询管理员
        Manager manager = managerService.queryDelManagerByName(loginName);
        if (manager != null) {
            String[] managerIds = new String[1];
            managerIds[0] = Long.toString(manager.getId());
            int line = managerService.deleteManager(managerIds);
            map.put("line", line);
        }
        return map;
    }

    /**
     * 启用管理员(私有云启用账号)
     *
     * @param loginName
     *            管理员编号
     * @return
     */
    @RequestMapping("/enableCloudManager")
    @ResponseBody
    public Map<String, Object> enableCloudManager(String loginName) {
        Map<String, Object> map = new HashMap<String, Object>();
        Manager manager = managerService.queryDelManagerByName(loginName);
        if (manager != null) {
            String[] managerIds = new String[1];
            managerIds[0] = Long.toString(manager.getId());
            int line = managerService.enabledManager(managerIds);
            // 查询更新后的manager
            Manager newManager = managerService.queryManagerById(manager.getId());
            map.put("createTime", newManager.getCreateTime());
            map.put("line", line);
        }
        return map;
    }

    /**
     * 修改管理员信息
     *
     * @param manager
     * @return
     */
    @RequestMapping("/updateManager")
    public ModelAndView updateManager(Manager manager, ManagerAuthority authority, MultipartHttpServletRequest multipartRequest, HttpServletRequest request) {
        // 非空验证 管理员名称
        if (null != manager.getUsername()) {
            // 日志记录
            LOGGER.info("修改管理员【" + manager.getUsername() + "】的信息");
        }
        String name = (String)request.getSession().getAttribute(NAME);
        Manager managers = managerServiceInterface.queryDelManagerByName(name);
        if(managers!=null){
            if(manager.getId().equals(managers.getId())){
                request.getSession().removeAttribute(NAME);
                request.getSession().setAttribute(NAME,manager.getUsername());
            }
        }
        managerService.updateManager(manager, authority);
//        OperaLogUtil.addOperaLog(multipartRequest, (String) multipartRequest.getSession().getAttribute(NAME), "修改管理员", "修改管理员" + ",编号:" + manager.getId());
        return new ModelAndView(new RedirectView(INITMANAGER_HTM));
    }

    /**
     * 验证密码
     *
     * @param userKey
     * @return ModelAndView
     */
    @RequestMapping("/checkUserKey")
    public ModelAndView checkUserKey(HttpServletRequest request, HttpServletResponse response, String userKey) {
        // 非空验证 密码
        if (null != userKey) {
            // 日志记录
            LOGGER.info("验证密码【" + userKey + "】是否正确！");
        }
        try {
            // 输出检查结果
            response.getWriter().print(managerService.checkUserKey(request, userKey));
        } catch (IOException e) {
//            OperaLogUtil.addOperaException((String) request.getSession().getAttribute(NAME), e, request);
        }

        return null;
    }

    /**
     * 验证密码
     *
     * @param userKey
     * @return
     */
    @RequestMapping("/checkUserKeyMain")
    public ModelAndView checkUserKeyMain(HttpServletRequest request, HttpServletResponse response, String userKey) {
        // 非空验证 密码
        if (null != userKey) {
            // 日志记录
            LOGGER.info("验证密码【" + userKey + "】是否正确！");
        }
        try {
            // 输出检查结果
            int f = managerService.checkUserKey(request, userKey);
            if (f == 1) {
                // 设置密码验证方式为 1 密码验证
                request.getSession().setAttribute(CHECKTYPE, "1");
                request.getSession().setAttribute(CHECKSUCCESS, "1");
            } else {
                request.getSession().setAttribute(CHECKTYPE, "");
                request.getSession().setAttribute(CHECKSUCCESS, "");
            }
            response.getWriter().print(f);
        } catch (IOException e) {
//            OperaLogUtil.addOperaException((String) request.getSession().getAttribute(NAME), e, request);
        }

        return null;
    }

    /**
     * 修改密码
     *
     * @param request
     * @param response
     * @param userKey
     * @param newuserkey
     * @return
     */
    @RequestMapping("/modifiedUserKey")
    public ModelAndView modifiedUserKey(HttpServletRequest request, HttpServletResponse response, String userKey, String newuserkey) {
        // 非空验证 密码
        if (null != userKey) {
            // 日志记录
            LOGGER.info("修改密码，旧密码为【" + userKey + "】");
        }
        try {
            // 通过什么方式进行修改信息 checkType： 1.登录密码 2.手机验证码
            if (request.getSession().getAttribute(CHECKTYPE) != null && "1".equals(request.getSession().getAttribute(CHECKTYPE))) {
                // 检查登录密码是否正确,若正确才能对密码进行修改 checkSuccess：1.密码正确
                if (request.getSession().getAttribute(CHECKSUCCESS) != null && "1".equals(request.getSession().getAttribute(CHECKSUCCESS))) {
                    response.getWriter().print(managerService.modifiedUserKey(request, userKey, newuserkey));
                }
            } else if (request.getSession().getAttribute(CHECKTYPE) != null && "2".equals(request.getSession().getAttribute(CHECKTYPE))) {
                // 检查手机验证码是否正确,若正确才能对密码进行修改 checkSuccess：1.验证码正确
                if (request.getSession().getAttribute(CHECKSUCCESS) != null && "1".equals(request.getSession().getAttribute(CHECKSUCCESS))) {
                    response.getWriter().print(managerService.modifiedUserKey(request, userKey, newuserkey));
                }
            } else {
                response.getWriter().print(0);
            }

            request.getSession().setAttribute(CHECKTYPE, "");
            request.getSession().setAttribute(CHECKSUCCESS, "");
        } catch (IOException e) {
//            OperaLogUtil.addOperaException((String) request.getSession().getAttribute(NAME), e, request);
        }

        return null;
    }

    /**
     * 修改管理员信息 -- 首页
     *
     * @param manager
     * @return
     */
    @RequestMapping("/modifymanager")
    public ModelAndView updateManager(Manager manager, HttpServletResponse response, MultipartHttpServletRequest multipartRequest) {
        // 非空验证 管理员名称
        if (null != manager.getUsername()) {
            // 日志记录
            LOGGER.info("修改管理员【" + manager.getUsername() + "】的信息");
        }
        // 通过什么方式进行修改信息 checkType： 1.登录密码 2.手机验证码
        if (multipartRequest.getSession().getAttribute(CHECKTYPE) != null && "1".equals(multipartRequest.getSession().getAttribute(CHECKTYPE)) && multipartRequest.getSession().getAttribute(CHECKSUCCESS) != null && "1".equals(multipartRequest.getSession().getAttribute(CHECKSUCCESS))) {
            // 检查登录密码是否正确,若正确才能对资料进行修改 checkSuccess：1.密码正确
                managerService.updateManagerOnly(manager);
                Manager m = managerService.queryManagerById(manager.getId());
                multipartRequest.getSession().setAttribute("photoImg", m.getPhotoImg());
        } else if (multipartRequest.getSession().getAttribute(CHECKTYPE) != null && "2".equals(multipartRequest.getSession().getAttribute(CHECKTYPE)) && multipartRequest.getSession().getAttribute(CHECKSUCCESS) != null && "1".equals(multipartRequest.getSession().getAttribute(CHECKSUCCESS))) {
            // 检查手机验证码是否正确,若正确才能对资料进行修改 checkSuccess：1.验证码正确
                managerService.updateManagerOnly(manager);
                Manager m = managerService.queryManagerById(manager.getId());
                multipartRequest.getSession().setAttribute("photoImg", m.getPhotoImg());
        }
        multipartRequest.getSession().setAttribute(CHECKTYPE, "");
        multipartRequest.getSession().setAttribute(CHECKSUCCESS, "");
        return new ModelAndView(new RedirectView("index.htm"));
    }

//    /**
//     * 发送验证码
//     *
//     * @param request
//     *            手机号码
//     * @return
//     */
//    @RequestMapping("sendcodecore")
//    @ResponseBody
//    public int sendMobileCode(HttpServletRequest request, String mobile) {
//        // 非空验证 手机号码
//        if (null != mobile) {
//            // 日志记录
//            LOGGER.info("发送验证码到号码为【" + mobile + "】的手机上");
//        }
//        return managerSmsService.sendPost(request, mobile);
//    }

    /**
     * 验证管理员是否已经存在
     * <p/>
     * 管理员名
     *
     * @return 0 不存在 1存在
     */
    @RequestMapping("/checkmanagerexist")
    @ResponseBody
    public Long checkManagerExist(String usernamen) {
        // 非空验证 管理员名称
        if (null != usernamen) {
            // 日志记录
            LOGGER.info("验证管理员【" + usernamen + "】是否存在");
        }
        return managerService.checkManagerExist(usernamen);
    }

    public ManagerServiceInterface getManagerService() {
        return managerService;
    }

    @Resource(name = "managerService")
    public void setManagerService(ManagerServiceInterface managerService) {
        this.managerService = managerService;
    }

    public MenuServiceInterface getMenuServiceInterface() {
        return menuServiceInterface;
    }

    @Resource(name = "menuServiceInterface")
    public void setMenuServiceInterface(MenuServiceInterface menuServiceInterface) {
        this.menuServiceInterface = menuServiceInterface;
    }

    @Resource(name = "managerService")
    private ManagerServiceInterface managerServiceInterface;
}
