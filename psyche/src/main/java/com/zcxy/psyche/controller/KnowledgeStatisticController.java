package com.zcxy.psyche.controller;


import com.zcxy.psyche.mapper.KnowledgeStatisticMapper;
import com.zcxy.psyche.mapper.PaperStatisticMapper;
import com.zcxy.psyche.model.VO.KowledgeStatisticVO;
import com.zcxy.psyche.model.VO.MostReadVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
@Api(tags = "知识库数据信息",value = "KnowledgeStatistic")
@RequestMapping("/zcxy/KnowledgeStatistic")
public class KnowledgeStatisticController {

    @Resource
    private KnowledgeStatisticMapper mapper;

//    @ApiOperation(value = "查询阅读最多的文章")
//    @GetMapping("/mostReadList")
//    private List<MostReadVO> mostReadList(){
//        List<MostReadVO> list= paperStatisticMapper.getMostReadList();
////        System.out.println( paperStatisticMapper.getMostReadList());
//        return list;
//    }

    @ApiOperation(value = "查询喜欢最多的知识点")
    @GetMapping("/mostLovedList")
    private List<KowledgeStatisticVO> mostLovedList(){
        List<KowledgeStatisticVO> list= mapper.getMostLovedList();
        return list;
    }

//    @ApiOperation(value = "查询收藏最多的文章")
//    @GetMapping("/mostCollectedList")
//    private List<MostReadVO> mostCollectedList(){
//        List<MostReadVO> list= paperStatisticMapper.getMostCollectedList();
//        return list;
//    }

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
