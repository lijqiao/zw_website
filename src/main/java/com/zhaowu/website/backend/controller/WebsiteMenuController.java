package com.zhaowu.website.backend.controller;

import com.zhaowu.website.backend.model.WebsiteMenuEntity;
import com.zhaowu.website.backend.model.WebsiteMenuTree;
import com.zhaowu.website.backend.service.WebsiteMenuService;
import com.zhaowu.website.common.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/website")
public class WebsiteMenuController {

    @Autowired
    private WebsiteMenuService service;

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/list")
    public Result<List<WebsiteMenuEntity>> list(@Param("name") String name) {
        return Result.ok(service.list(name));
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/listByParentId")
    public Result<List<WebsiteMenuEntity>> listByParentId(@Param("parentId") Long parentId) {
        return Result.ok((service.listByParentId(parentId)));
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/getTree")
    public Result<List<WebsiteMenuTree>> getTree(@Param("pageName")String pageName) {
        return Result.ok(service.getTree(pageName));
    }


    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping ("/save")
    public Result<String> save(@RequestBody WebsiteMenuEntity entity){
         System.out.println(123);
         service.save(entity);
         return Result.ok();
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping ("/delete")
    public Result<String> delete(@RequestBody WebsiteMenuEntity entity){
        entity.setDeleted(1);
        service.save(entity);
        return Result.ok();
    }

}
