package com.zhaowu.website.common;

import com.zhaowu.website.backend.dao.WebsiteMenuMapper;

import javax.annotation.Resource;

public abstract class BaseService<T extends BaseEntity> {


    @Resource
    private CommonMapper mapper;

    public void save(T entity){
        if(entity.getId()!= null){
            mapper.updateById(entity);
            return;
        }
        entity.setDeleted(0);
        mapper.insert(entity);
    }


}
