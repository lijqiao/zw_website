package com.zhaowu.website.backend.model;

import lombok.Data;

import java.util.List;

@Data
public class WebsiteMenuTree {
    private Long id;
    /** 菜单名称*/
    private String menuName;
    /** 菜单链接 */
    private String link;
    /** 上一级id */
    private Long parentId;
    /** 子菜单*/
    private List<WebsiteMenuTree> submenu;
}
