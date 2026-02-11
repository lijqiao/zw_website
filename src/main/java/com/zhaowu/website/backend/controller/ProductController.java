package com.zhaowu.website.backend.controller;

import com.zhaowu.website.backend.model.ProductMasterEntity;
import com.zhaowu.website.backend.model.ProductVariantEntity;
import com.zhaowu.website.backend.model.SchemaEntity;
import com.zhaowu.website.backend.service.ProductMasterService;
import com.zhaowu.website.backend.service.ProductVariantService;
import com.zhaowu.website.backend.view.ProductDTO;
import com.zhaowu.website.backend.view.ProductMasterDTO;
import com.zhaowu.website.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pruduct")
public class ProductController {

    @Autowired
    private ProductMasterService productMasterService;
    @Autowired
    private ProductVariantService productVariantService;

    @PostMapping("/spu/save")
    public Result<String> save(@RequestBody ProductMasterDTO request){
        System.out.println("spu save");
        productMasterService.save(request);
        return Result.ok("保存成功");
    }

    @PostMapping("/spu/homeList")
    public Result<List<ProductDTO>> homeList(@RequestBody ProductMasterDTO entity){
        return Result.ok(productMasterService.homeList(entity.getSchemaCode()));
    }

    @GetMapping("/spu/{id}")
    public Result<ProductMasterDTO> detail(@PathVariable Long id){
        System.out.println("spu detail，id：" + id);
        // 1. 调用服务层查询SPU详情（核心业务逻辑）
        ProductMasterDTO spu = productMasterService.getById(id);
        if (spu == null) {
            return Result.error("未查询到该SPU的详情");
        }
        return Result.ok(spu);
    }




    @PostMapping("/sku/save")
    public Result<String> skuSave(@RequestBody ProductVariantEntity entity){
        System.out.println("sku save");
        productVariantService.save(entity);
        return Result.ok();
    }
}
