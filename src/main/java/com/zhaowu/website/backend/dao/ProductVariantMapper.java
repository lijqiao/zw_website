package com.zhaowu.website.backend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhaowu.website.backend.model.ProductVariantEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductVariantMapper extends BaseMapper<ProductVariantEntity> {
}
