package com.zcxy.psyche.controller;


import com.zcxy.psyche.service.IUserLikePaperService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户点赞文章",value = "UserLikePaper")
@RestController
@RequestMapping("/zcxy/UserLikePaperController")
public class UserLikePaperController {

    @Autowired
    private IUserLikePaperService service;

    @ApiOperation(value = "查询收藏列表")
    @GetMapping("/geIstLike")
    private Integer geIstLike(String paperid){
        return service.geIstLike(paperid);
    }

    @ApiOperation(value = "查询收藏列表")
    @GetMapping("/like")
    private Integer like(String username,Integer operation,String paperid){
        return service.like(username,operation,paperid);
    }
}
