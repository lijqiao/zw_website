package com.zhaowu.website.backend.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhaowu.website.common.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;


/** 商品变体/sku表实体类（对应t_product_variant表） **/
/** 用途：存储商品具体规格的信息（如XX品牌PCR仪-96孔-220V） **/
@Data
@TableName("t_product_variant") // 关联数据库表名，统一命名规范
public class ProductVariantEntity extends BaseEntity {

    /** SKU编码（唯一标识，如PCR2024001-96H220V） **/
    private String variantCode;

    /** 商品类目编码（冗余字段，关联SPU的类目，便于筛选） **/
    private String schemaCode;

    /** 商品编码（关联SPU的productCode，外键） **/
    private String productCode;

    /** 销售价（实际售价，如12800.00元） **/
    private BigDecimal salePrice;

    /** 划线价/原价（展示用，如15800.00元） **/
    private BigDecimal originalPrice;

    /** 库存数量 **/
    private Integer stockCount; /** 原count字段重命名，语义更清晰 **/

    /** SKU规格参数（JSON格式，如{"孔数":"96孔","电压":"220V","颜色":"白色"}） **/
    private String params;

    /** SKU名称（如XX品牌PCR仪-96孔-220V-白色，便于展示） **/
    private String variantName;

    /** 仪器型号（生物仪器核心规格，单独字段便于检索） **/
    //private String model;

    /** 技术参数（JSON格式，如{"温控精度":"±0.1℃","升温速率":"5℃/s"}） **/
    //private String techParams;

    /** SKU状态：1-可用 0-不可用（如售罄/下架） **/
    private Integer status;

    /** 排序权重（同SPU下SKU的展示顺序） **/
    private Integer sortNum;
}
