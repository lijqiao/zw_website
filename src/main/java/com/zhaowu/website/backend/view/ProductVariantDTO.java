package com.zhaowu.website.backend.view;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductVariantDTO {

    /** SKU编码（唯一标识，如PCR2024001-96H220V） **/
    private String variantCode;
    /** 销售价（实际售价，如12800.00元） **/
    private BigDecimal salePrice;
    /** 划线价/原价（展示用，如15800.00元） **/
    private BigDecimal originalPrice;
    /** 库存数量 **/
    private Integer stockCount; /** 原count字段重命名，语义更清晰 **/
    /** SKU规格参数（JSON格式，如{"孔数":"96孔","电压":"220V","颜色":"白色"}） **/
    /** 技术参数（JSON格式，如{"温控精度":"±0.1℃","升温速率":"5℃/s"}） **/
    /** 规格项，{"规格"："10次/盒"，"尺寸":"10ml/盒"}*/
    private String params;
    /** SKU名称（如XX品牌PCR仪-96孔-220V-白色，便于展示） **/
    private String variantName;
    /** SKU状态：1-可用 0-不可用（如售罄/下架） **/
    private Integer status;
    /** 排序权重（同SPU下SKU的展示顺序） **/
    private Integer sortNum;

    /** 仪器型号（生物仪器核心规格，单独字段便于检索） **/
    //private String model;

    //private String techParams;
}
