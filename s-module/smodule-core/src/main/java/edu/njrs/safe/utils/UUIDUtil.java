package edu.njrs.safe.utils;


import edu.njrs.common.util.MyLogger;

/**
 * <p>
 * </p>
 *
 * @version 1.0
 */
public class UUIDUtil {

    public static final MyLogger LOGGER = new MyLogger(UUIDUtil.class);
    private static UIDFactory uuid = null;

    static {
        try {
            uuid = UIDFactory.getInstance("UUID");
        } catch (Exception unsex) {
            LOGGER.info(unsex);
        }
    }

    /**
     * Constructor for the UUIDGener object
     */
    private UUIDUtil() {
    }

    /**
     * 获取uuid字符
     *
     * @author IShopTeam
     * @return
     * @see
     * @since
     */
    public static String getUUID() {
        return uuid.getNextUID();
    }
}
