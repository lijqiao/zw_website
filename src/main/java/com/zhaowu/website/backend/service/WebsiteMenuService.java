package com.zhaowu.website.backend.service;

import com.alibaba.excel.util.CollectionUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhaowu.website.backend.dao.WebsiteMenuMapper;
import com.zhaowu.website.backend.model.WebsiteMenuEntity;
import com.zhaowu.website.backend.model.WebsiteMenuTree;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

import java.util.List;

@Service
public class WebsiteMenuService {
    @Resource
    private WebsiteMenuMapper mapper;

    public void save(WebsiteMenuEntity entity){
        if(entity.getId()!= null){
            mapper.updateById(entity);
            return;
        }
        if(entity.getParentId()==null){
            entity.setParentId(0L);
        }
        entity.setDeleted(0);
        mapper.insert(entity);
    }

    public List<WebsiteMenuEntity> list(String name){
        QueryWrapper<WebsiteMenuEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("deleted", 0);
        if (StringUtils.isNotEmpty(name)) {
            queryWrapper.eq("menu_name", name);
        }
        return mapper.selectList(queryWrapper);
    }
    public List<WebsiteMenuEntity> listByParentId(Long parentId){
        QueryWrapper<WebsiteMenuEntity> queryWrapper = new QueryWrapper<>();
        if (parentId==null) {
            parentId = 0L;
        }
        queryWrapper.eq("parent_id", parentId);
        return mapper.selectList(queryWrapper);
    }

    public List<WebsiteMenuTree> getTree(String pageName){
        List<WebsiteMenuTree> result = new ArrayList<>();
        List<WebsiteMenuEntity> list = listByParentId(0L);
        list.forEach(e->{
            WebsiteMenuTree websiteMenuTree = new WebsiteMenuTree();
            BeanUtils.copyProperties(e,websiteMenuTree);
            websiteMenuTree.setSubmenu(getTree(e.getId()));
            result.add(websiteMenuTree);
        });
        return result;
    }

    public List<WebsiteMenuTree> getTree(Long parentId){
        List<WebsiteMenuTree> result = new ArrayList<>();
        List<WebsiteMenuEntity> list = listByParentId(parentId);
        if(!CollectionUtils.isEmpty(list)){
            list.forEach(e->{
                WebsiteMenuTree websiteMenuTree = new WebsiteMenuTree();
                BeanUtils.copyProperties(e,websiteMenuTree);
                result.add(websiteMenuTree);
            });
        }
        return result;
    }
}
