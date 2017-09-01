/*


 */
package edu.njrs.common.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 日志封装
 * 
 * @author IShopTeam
 * @since 2015年2月26日14:38:55
 */
public class MyLogger {

    /** 记录日志对象 */
    private Logger LOGGER;

    /**
     * 日志
     * */
    public MyLogger(Class<?> c) {
        LOGGER = LoggerFactory.getLogger(c);
    }

    /**
     * 日志记录
     * 
     * @param message
     *            日志内容
     */
    public void error(String message) {
        LOGGER.error(message);
    }

    /**
     * 日志记录
     * 
     * @param message
     */
    public void error(String message, Throwable throwable) {
        LOGGER.error(message, throwable);
    }

    /**
     * 日志记录
     * 
     * @param message
     */
    public void debug(String message) {
        LOGGER.debug(message);
    }

    /**
     * 记录信息
     * 
     * @param message
     */
    public void info(Object message) {
        LOGGER.info("logInfo: {}", message);
    }

    /**
     * 日志记录
     *
     * @param message
     */
    public void trace(String message) {
        LOGGER.trace(message);
    }

    /**
     * 日志记录
     *
     * @param message
     */
    public void warn(String message) {
        LOGGER.warn(message);
    }
}
