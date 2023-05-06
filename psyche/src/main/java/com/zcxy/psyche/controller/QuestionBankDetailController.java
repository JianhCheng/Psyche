package com.zcxy.psyche.controller;

import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.QuestionBankDetail;
import com.zcxy.psyche.mapper.QuestionBankDetailMapper;
import com.zcxy.psyche.model.QuestionBankDetailPageDTO;
import com.zcxy.psyche.service.IQuestionBankDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "题库详情列表",value = "QuestionBankDetail")
@RequestMapping("/zcxy/questionBankDetail")
public class QuestionBankDetailController {

    @Autowired
    private IQuestionBankDetailService service;

    @Autowired
    private QuestionBankDetailMapper mapper;

    @ApiOperation(value = "查询用户列表")
    @GetMapping("/list")
    private PageUtils list(QuestionBankDetailPageDTO pageDTO){
        return service.getPageQuestionBankDetail(pageDTO);
    }

    @ApiOperation(value = "根据id查询对应题库内容")
    @GetMapping("/getQBDetailById")
    private PageUtils getQBDetailById(QuestionBankDetailPageDTO pageDTO,String qbid){
        return service.getQBDetailById(pageDTO,qbid);
    }

    @ApiOperation(value = "根据id查询题库内章节结构")
    @GetMapping("/getQBDetailStructure")
    private List<String> getQBDetailStructure(String id){
        return mapper.getQBDetailStructure(id);
    }

    @ApiOperation(value = "根据structure查询题库内容")
    @GetMapping("/getQBDetail")
    private List<QuestionBankDetail> getQBDetail(String struct,String id){
        return mapper.getQBDetail(struct,id);
    }

    @ApiOperation(value = "获取十个一组的题目内容")
    @GetMapping("/getTenQuestion")
    private List<QuestionBankDetail> getTenQuestion(String qbid,String id,String chapter){
        return mapper.getTenQuestion(qbid,id,chapter);
    }

    @ApiOperation(value = "获取下一个的题目内容")
    @GetMapping("/getNextQuestion")
    private List<QuestionBankDetail> getNextQuestion(String qbid,String id,String chapter,Integer operation){

        return service.getNextQuestion(qbid,id,chapter,operation);
    }

    @ApiOperation(value = "获取一个题目内容")
    @GetMapping("/getQuestion")
    private List<QuestionBankDetail> getQuestion(String id){
        return mapper.getQuestion(id);
    }

    @ApiOperation(value = "获取一个题目内容")
    @PostMapping("/updateQBDetail")
    private Integer updateQBDetail(@RequestBody QuestionBankDetail detail){
        return mapper.updateQBDetail(detail);
    }
}
