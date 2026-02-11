package com.zhaowu.website.backend.controller;

import com.zhaowu.website.backend.model.ItemPropertyEntity;
import com.zhaowu.website.backend.model.SchemaEntity;
import com.zhaowu.website.backend.service.SchemaService;
import com.zhaowu.website.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schema")
public class SchemaController {
   @Autowired
    private SchemaService service;

    //@CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/save")
    public Result<String> save(@RequestBody SchemaEntity entity){
        System.out.println("save");
        service.save(entity);
        return Result.ok();
    }

    @PostMapping("/query")
    public Result<List<SchemaEntity>> list(@RequestBody Long parentId) {
        if (parentId == null) {
            return Result.error("参数为空");
        }
        return Result.ok(service.queryByParenId(parentId));
    }

    @PostMapping("/delete")
    public Result<String> delete(@RequestBody SchemaEntity entity){
        System.out.println("delete");
        if(entity.getId()==null){
            return Result.error("id不能为空","删除失败");
        }
        service.delete(entity.getId());
        return Result.ok();
    }

    @PostMapping("/itemSave")
    public Result<String> itemSave(@RequestBody ItemPropertyEntity entity){
        return Result.ok();
    }
}
