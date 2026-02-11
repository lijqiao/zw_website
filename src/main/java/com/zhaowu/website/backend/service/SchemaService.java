package com.zhaowu.website.backend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhaowu.website.backend.dao.SchemaMapper;
import com.zhaowu.website.backend.model.SchemaEntity;
import com.zhaowu.website.common.ResponseConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class SchemaService {


    @Resource
    private SchemaMapper mapper;

    public void save(SchemaEntity entity) {

        if (entity.getParentId() == null) {
            entity.setParentId(0L);
        } else {
            SchemaEntity parentEntity = mapper.selectById(entity.getParentId());
            if (parentEntity != null) {
                entity.setCodePath(parentEntity.getCodePath() + ResponseConstant.ATTACH + entity.getSchemaCode());
            }
        }
        if (StringUtils.isBlank(entity.getCodePath())) {
            entity.setCodePath("zw");
        }
        if (entity.getId() != null) {
            mapper.updateById(entity);
            return;
        }
        mapper.insert(entity);
    }

    public void delete(Long id){
        SchemaEntity schemaEntity = mapper.selectById(id);
        schemaEntity.setDeleted(ResponseConstant.DELETE_FLAG);
        mapper.updateById(schemaEntity);
    }

    public SchemaEntity queryBySchemaCode(String schemaCode){
        QueryWrapper<SchemaEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(ResponseConstant.DELETED,ResponseConstant.USE_FLAG);
        queryWrapper.eq("schema_code", schemaCode);
        return mapper.selectOne(queryWrapper);
    }

    public List<SchemaEntity> queryByParenId(Long parentId){
        QueryWrapper<SchemaEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(ResponseConstant.DELETED,ResponseConstant.USE_FLAG);
        queryWrapper.eq("parent_id", parentId);
        return mapper.selectList(queryWrapper);
    }


}
