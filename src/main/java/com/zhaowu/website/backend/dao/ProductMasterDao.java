package com.zhaowu.website.backend.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhaowu.website.backend.model.ProductMasterEntity;
import com.zhaowu.website.common.ResponseConstant;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class ProductMasterDao{
    @Resource
    private ProductMasterMapper mapper;

    public ProductMasterEntity queryByProductCode(String productCode){
        QueryWrapper<ProductMasterEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(ResponseConstant.DELETED,ResponseConstant.USE_FLAG);
        queryWrapper.eq("product_code", productCode);
        return mapper.selectOne(queryWrapper);
    }

    public List<ProductMasterEntity> queryBySchemaCode(String schemaCode){
        QueryWrapper<ProductMasterEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(ResponseConstant.DELETED,ResponseConstant.USE_FLAG);
        queryWrapper.eq("schema_code", schemaCode);
        return mapper.selectList(queryWrapper);
    }
}
