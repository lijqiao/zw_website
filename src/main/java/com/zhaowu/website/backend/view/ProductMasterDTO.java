package com.zhaowu.website.backend.view;

import lombok.Data;

import java.util.List;

@Data
public class ProductMasterDTO {
    /** 商品名称 */
    private String productName;
    /** 商品编码*/
    private String productCode;
    /** 商品类目 */
    private String schemaCode;
    /** 品牌名称 */
    private String brandName;
    /** 图片集*/
    private String imageUrls;
    /** 参考价格（原价）*/
    private String price;
    /** 产品详情*/
    private String detail;
    /** 售后服务描述（质保/安装等） */
    private String serviceDesc;

    //----
    private String firstSchemaCode;

    private String secondSchemaCode;

    private String salePrice;
    /** 产品参数*/
    private String param;

    private List<ProductVariantDTO> skuList;
}
