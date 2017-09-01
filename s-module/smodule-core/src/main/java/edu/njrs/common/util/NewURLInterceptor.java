/*


 */
package edu.njrs.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * URL拦截器
 *
 * @author IShopTeam
 * @version 0.0.1
 * @since 2014年1月24日 上午11:04:35
 */
public class NewURLInterceptor extends HandlerInterceptorAdapter {

    /**
     * 日志
     * */
//    public static final MyLogger LOGGER = new MyLogger(NewURLInterceptor.class);

    // spring 注解
//    private MenuService menuServiceInterface;
    private Boolean urlFlag = false;
    private int depth = 0;
    private String operaPath = "";
    private static final String MANAGERFLAG = "managerFlag";
    private static final String PEX_DIV = " </div>";
    private static final String PEX_DIALOG = "<div id='dialog-tip' title='操作提示'>";

    /**
     * 在请求处理前拦截URL 进行相应处理
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return true;
    }

    /**
     * 设置不用拦截的htm
     *
     * @return String []
     */
    private String[] getManagerFilters() {
        return new String[] {};
    }

    /**
     * 设置不用拦截的htm
     *
     * @return String []
     */
    private String[] getNoFilters() {
        return new String[] {};
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }


}
