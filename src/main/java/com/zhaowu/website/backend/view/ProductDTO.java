package com.zhaowu.website.backend.view;

import lombok.Data;

/**
 * 商城首页DTO
 */
@Data
public class ProductDTO {
    private Long id;
    /** 商品名称 */
    private String productName;
    /** 商品图片*/
    private String imageUrl;

    private String price;
}
