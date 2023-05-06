package com.zcxy.psyche.controller;


import com.zcxy.psyche.mapper.KnowledgeStatisticMapper;
import com.zcxy.psyche.mapper.QuestionBankStatisticMapper;
import com.zcxy.psyche.model.VO.KowledgeStatisticVO;
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
@Api(tags = "知识库数据信息",value = "QuestionBankStatistic")
@RequestMapping("/zcxy/QuestionBankStatistic")
public class QuestionBankStatisticController {

    @Resource
    private QuestionBankStatisticMapper mapper;

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
