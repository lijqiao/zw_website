package com.zhaowu.website.backend.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.zhaowu.website.common.BaseEntity;
import lombok.Data;


@Data
@TableName("t_website_menu")
public class WebsiteMenuEntity extends BaseEntity {
    /** 菜单名称*/
    private String menuName;
    /** 菜单链接 */
    private String link;
//    private String menuLevel;
//    private int seq;
    /** 上一级id */
    private Long parentId;
}
