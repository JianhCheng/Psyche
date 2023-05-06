package com.zcxy.psyche.controller;


import com.zcxy.psyche.entity.SysUser;
import com.zcxy.psyche.entity.UserCollectPaper;
import com.zcxy.psyche.mapper.UserCollectPaperMapper;
import com.zcxy.psyche.service.IUserCollectPaperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "用户收藏文章",value = "UserCollectPaper")
@RestController
@RequestMapping("/zcxy/UserCollectPaper")
public class UserCollectPaperController {
    @Autowired
    private IUserCollectPaperService service;

    @Autowired
    private UserCollectPaperMapper mapper;

    @ApiOperation(value = "查询列表")
    @GetMapping("/list")
    private List<UserCollectPaper> list(){
        return service.list();
    }

    @ApiOperation(value = "点赞收藏")
    @GetMapping("/like")
    private Integer like(String username,Integer operation,String paperid){
        return service.like(username,operation,paperid);
    }

    @ApiOperation(value = "查找是否收藏")
    @GetMapping("/geIstCollect")
    private Integer geIstCollect(String knowledgeid){
        return service.geIstCollect(knowledgeid);
    }

}
