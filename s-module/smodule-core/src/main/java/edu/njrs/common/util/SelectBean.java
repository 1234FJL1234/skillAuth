/*


 */
package edu.njrs.common.util;

import lombok.Data;

/**
 * 分页参数Bean
 * 
 * @author IShopTeam
 * @since 2013年12月18日 下午2:56:14
 * @version 1.0
 */
@Data
public class SelectBean {

    // 条件标记
    private String condition = "";
    // 查询文本
    private String searchText = "";

    // 查询条件（sku名称）
    private String goodsName;

    // 查询条件（sku编号）
    private String goodsNo;
    //会员编号
    private Long customerId;

    //门店编号
    private Long storeId;
}
