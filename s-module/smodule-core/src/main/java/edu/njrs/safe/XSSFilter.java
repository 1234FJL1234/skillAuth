package edu.njrs.safe;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 拦截器
 * */
public class XSSFilter implements Filter {
    /**
     * 重写父类方法
     * */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    /**
     * 重写父类方法
     * */
    @Override
    public void destroy() {
    }
    /**
     * 重写父类方法
     * */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        /*
         * //设置request字符编码 request.setCharacterEncoding("UTF-8");
         * //设置response字符编码 response.setContentType("text/html;charset=UTF-8");
         */

        chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request),
                response);

    }

}