package com.zcxy.psyche.controller;


import com.zcxy.psyche.entity.UserCollectKnowledge;
import com.zcxy.psyche.entity.UserCollectPaper;
import com.zcxy.psyche.mapper.UserCollectKnowledgeMapper;
import com.zcxy.psyche.mapper.UserCollectPaperMapper;
import com.zcxy.psyche.service.IUserCollectKnowledgeService;
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
@RequestMapping("/zcxy/UserCollectKnowledge")
public class UserCollectKnowledgeController {
    @Autowired
    private IUserCollectKnowledgeService service;

    @Autowired
    private UserCollectKnowledgeMapper mapper;

    @ApiOperation(value = "查询收藏列表")
    @GetMapping("/list")
    private List<UserCollectKnowledge> list(){
        return service.list();
    }

    @ApiOperation(value = "查询收藏列表")
    @GetMapping("/collect")
    private Integer collect(String username,Integer operation,String knowledgeid){
        return service.collect(username,operation,knowledgeid);
    }

    @ApiOperation(value = "查询收藏列表")
    @GetMapping("/geIstCollect")
    private Integer geIstCollect(String knowledgeid){
        return service.geIstCollect(knowledgeid);
    }

}
