package com.zhaowu.website.backend.model;


import com.zhaowu.website.backend.view.RefEnum;
import com.zhaowu.website.common.BaseEntity;
import lombok.Data;

@Data
public class ItemPropertyEntity extends BaseEntity {
    /** */
    private String refCode;
    /** */
    private String propertyCode;
    /** */
    private String propertyName;
    /** */
    private RefEnum refType;

}
