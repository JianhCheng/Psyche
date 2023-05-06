package com.zcxy.psyche.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.PaperList;
import com.zcxy.psyche.mapper.PaperListMapper;
import com.zcxy.psyche.model.PaperListPageDTO;
import com.zcxy.psyche.service.IPaperListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author suhe
 * @since 2023-03-25
 */
@RestController
@CrossOrigin //放开跨越请求
@Api(tags = "文章列表",value = "PaperList")
@RequestMapping("/zcxy/paperList")
public class PaperListController {

    @Resource
    private IPaperListService service;

    @Autowired
    private PaperListMapper mapper;

    @ApiOperation(value = "查询文章列表")
    @GetMapping("/list")
    private PageUtils list(PaperListPageDTO pageDTO){
        return service.getPagePaperList(pageDTO);
    }

    @ApiOperation(value = "查询xx来源的列表")
    @GetMapping("/srcList")
    private PageUtils srcList(PaperListPageDTO pageDTO){
        return service.getPageBySrc(pageDTO);
    }

    @ApiOperation(value = "查询本周最新的三篇文章")
    @GetMapping("/latestThreePaper")
    private List<PaperList> latestThreePaper(){

        QueryWrapper<PaperList> queryWrapper=new QueryWrapper<PaperList>();
        //TODO:因为最新爬取的文章配图有问题，显示影响效果，所以暂时显示最早的文章；如有需要，将orderbyasc改为orderbydesc
        queryWrapper.orderByAsc("createtime").last("limit 3");
        System.out.println(queryWrapper);

        List<PaperList> list= service.list(queryWrapper);
        return list;
    }

    @ApiOperation(value = "用户收藏文章")
    @GetMapping("/getCollectPaper")
    private List<PaperList> getCollectPaper(String name){
        return mapper.getCollectPaper(name);
    }

    @ApiOperation(value = "根据关键词模糊查询")
    @GetMapping("/searchByName")
    private PageUtils searchByName(PaperListPageDTO pageDTO){
        return service.searchByName(pageDTO);
    }

    @ApiOperation(value = "根据关键词模糊查询")
    @GetMapping("/deletePaper")
    private Integer deletePaper(String id){
        return service.deletePaper(id);
    }

}
