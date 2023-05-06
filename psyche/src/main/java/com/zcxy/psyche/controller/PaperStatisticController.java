package com.zcxy.psyche.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zcxy.psyche.entity.PaperStatistic;
import com.zcxy.psyche.mapper.PaperStatisticMapper;
import com.zcxy.psyche.model.VO.MostReadVO;
import com.zcxy.psyche.service.IPaperStatisticService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 文章数据表 前端控制器
 * </p>
 *
 * @author suhe
 * @since 2023-03-28
 */
@RestController
@CrossOrigin
@Api(tags = "文章数据信息",value = "PaperStatistic")
@RequestMapping("/zcxy/paperStatistic")
public class PaperStatisticController {

    @Resource
    private PaperStatisticMapper mapper;

    @ApiOperation(value = "查询阅读最多的文章")
    @GetMapping("/mostReadList")
    private List<MostReadVO> mostReadList(){
        List<MostReadVO> list= mapper.getMostReadList();
//        System.out.println( paperStatisticMapper.getMostReadList());
        return list;
    }

    @ApiOperation(value = "查询喜欢最多的文章")
    @GetMapping("/mostLovedList")
    private List<MostReadVO> mostLovedList(){
        List<MostReadVO> list= mapper.getMostLovedList();
        return list;
    }

    @ApiOperation(value = "查询收藏最多的文章")
    @GetMapping("/mostCollectedList")
    private List<MostReadVO> mostCollectedList(){
        List<MostReadVO> list= mapper.getMostCollectedList();
        return list;
    }

    @ApiOperation(value = "查询主编文章")
    @GetMapping("/recommendList")
    private List<MostReadVO> recommendList(){
        List<MostReadVO> list= mapper.getRecommendList();
        return list;
    }

    @ApiOperation(value = "文章点赞")
    @GetMapping("/like")
    private Integer like(String id,Integer operation){
        if(operation==0){
            operation=-1;
        }
        Integer l= mapper.like(id,operation);
        return l;
    }

    @ApiOperation(value = "文章收藏")
    @GetMapping("/collect")
    private Integer collect(String id,Integer operation){
        if(operation==0){
            operation=-1;
        }
        Integer l= mapper.collect(id,operation);
        return l;
    }
}
