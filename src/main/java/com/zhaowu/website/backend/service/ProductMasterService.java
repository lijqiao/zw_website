package com.zhaowu.website.backend.service;

import com.zhaowu.website.backend.dao.ProductMasterDao;
import com.zhaowu.website.backend.dao.ProductMasterMapper;
import com.zhaowu.website.backend.model.ProductMasterEntity;
import com.zhaowu.website.backend.model.ProductVariantEntity;
import com.zhaowu.website.backend.view.ProductDTO;
import com.zhaowu.website.backend.view.ProductMasterDTO;
import com.zhaowu.website.backend.view.ProductVariantDTO;
import com.zhaowu.website.common.BeanConvertUtils;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductMasterService {

    @Resource
    private ProductMasterMapper mapper;

    @Resource
    private ProductMasterDao productMasterDao;

    @Resource
    private ProductVariantService productVariantService;

    public static String imageSpilt = ";";

    public void save(ProductMasterDTO entity) {
        //mapper.insert(entity);
    }

    public void delete(Long id){

    }


    public ProductMasterEntity queryByProductCode(String productCode){
        return productMasterDao.queryByProductCode(productCode);
    }

    public ProductMasterDTO getById(Long id){
        ProductMasterEntity entity = mapper.selectById(id);
        if(entity == null){
            return null;
        }
        ProductMasterDTO result = BeanConvertUtils.convertTo(entity,ProductMasterDTO::new);
        List<ProductVariantEntity> skuLists = productVariantService.queryByProductCode(entity.getProductCode());
        List<ProductVariantDTO> skuList = BeanConvertUtils.convertListTo(skuLists,ProductVariantDTO::new);
        result.setSkuList(skuList);
        return result;
    }

    public List<ProductDTO> homeList(String schemaCode){
        List<ProductMasterEntity> list = productMasterDao.queryBySchemaCode(schemaCode);
        List<ProductDTO> result = new ArrayList<>();
        list.forEach(e->{
            ProductDTO dto = new ProductDTO();
            dto.setId(e.getId());
            dto.setProductName(e.getProductName());
            if(StringUtils.isNotEmpty(e.getImageUrls())){
                dto.setImageUrl(e.getImageUrls().split(imageSpilt)[0]);
            }
            result.add(dto);
        });
        return result;
    }
}
