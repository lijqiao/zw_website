package com.zhaowu.website.backend.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhaowu.website.common.BaseEntity;
import lombok.Data;

import java.util.List;

@Data
@TableName("t_schema")
public class SchemaEntity extends BaseEntity {
    /** 预设模型名称 */
    private String name;
    /** 预设模型唯一业务名称 */
    private String schemaCode;
    /** 父模型唯一标识名称 */
    private String parentSchemaCode;
    /** 模型路径 */
    private String codePath;
    /** 父模型ID */
    private Long parentId;
    /** 预设模型元数据主属性列表 */
    //private List<PropertyView> properties;
    /** 版本号*/
    //private int version;
    /** 描述 */
    private String remark;

    private String picUrl;

    private int sort;

    //private int status;//不要

}
