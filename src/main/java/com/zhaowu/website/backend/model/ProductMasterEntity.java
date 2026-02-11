package com.zhaowu.website.backend.model;


import com.baomidou.mybatisplus.annotation.TableName;
import com.zhaowu.website.common.BaseEntity;
import lombok.Data;

@Data
@TableName("t_product_master")
public class ProductMasterEntity extends BaseEntity {
    /** 商品名称 */
    private String productName;

    private String productCode;
    /** 商品类目 */
    private String schemaCode;
    /** 品牌名称 */
    private String brandName;
//    /** 图片1*/
//    private String imageUrl1;
//    /** 图片2*/
//    private String imageUrl2;
//    /** 图片3*/
//    private String imageUrl3;
    /** 图片集*/
    private String imageUrls;
    /** 参考价格*/
    private String price;
    /** 产品详情*/
    private String detail;
    /** 售后服务描述（质保/安装等） */
    private String serviceDesc;
}
