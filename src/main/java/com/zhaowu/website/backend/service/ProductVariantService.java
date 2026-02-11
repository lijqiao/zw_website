package com.zhaowu.website.backend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhaowu.website.backend.dao.ProductMasterMapper;
import com.zhaowu.website.backend.dao.ProductVariantMapper;
import com.zhaowu.website.backend.model.ProductMasterEntity;
import com.zhaowu.website.backend.model.ProductVariantEntity;
import com.zhaowu.website.common.ResponseConstant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductVariantService {

    @Resource
    private ProductVariantMapper mapper;

    public void save(ProductVariantEntity entity) {
        mapper.insert(entity);
    }

    public void delete(Long id){

    }

    public List<ProductVariantEntity> queryByProductCode(String productCode){
        QueryWrapper<ProductVariantEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(ResponseConstant.DELETED,ResponseConstant.USE_FLAG);
        queryWrapper.eq("product_code", productCode);
        return mapper.selectList(queryWrapper);
    }
}
