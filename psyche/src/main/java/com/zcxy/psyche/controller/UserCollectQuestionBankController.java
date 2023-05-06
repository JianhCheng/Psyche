package com.zcxy.psyche.controller;


import com.zcxy.psyche.entity.UserCollectKnowledge;
import com.zcxy.psyche.entity.UserCollectQuestionBank;
import com.zcxy.psyche.mapper.UserCollectKnowledgeMapper;
import com.zcxy.psyche.mapper.UserCollectQuestionBankMapper;
import com.zcxy.psyche.service.IUserCollectKnowledgeService;
import com.zcxy.psyche.service.IUserCollectQuestionBankService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "用户收藏文章",value = "UserCollectPaper")
@RestController
@RequestMapping("/zcxy/UserCollectQuestionBank")
public class UserCollectQuestionBankController {
    @Autowired
    private IUserCollectQuestionBankService service;

    @Autowired
    private UserCollectQuestionBankMapper mapper;

    @ApiOperation(value = "查询收藏列表")
    @GetMapping("/list")
    private List<UserCollectQuestionBank> list(){
        return service.list();
    }

    @ApiOperation(value = "查询收藏列表")
    @GetMapping("/collect")
    private Integer collect(String username,Integer operation,String qbid){
        return service.collect(username,operation,qbid);
    }

    @ApiOperation(value = "查询收藏列表")
    @GetMapping("/geIstCollect")
    private Integer geIstCollect(String qbid){
        return service.geIstCollect(qbid);
    }

}
