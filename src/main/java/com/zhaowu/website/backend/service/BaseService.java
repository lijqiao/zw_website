package com.zhaowu.website.backend.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhaowu.website.backend.model.SchemaEntity;
import com.zhaowu.website.common.BaseEntity;
import com.zhaowu.website.common.ResponseConstant;

import javax.annotation.Resource;

public  class BaseService<T extends BaseEntity> {

    @Resource
    BaseMapper mapper;

    public void delete(Long id){
        T entity = (T)mapper.selectById(id);
        entity.setDeleted(ResponseConstant.DELETE_FLAG);
        mapper.updateById(entity);
    }
}
