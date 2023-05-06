package com.zcxy.psyche.controller;

import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.KnowledgeList;
import com.zcxy.psyche.entity.PaperList;
import com.zcxy.psyche.entity.QuestionBankDetail;
import com.zcxy.psyche.entity.QuestionBankList;
import com.zcxy.psyche.mapper.QuestionBankListMapper;
import com.zcxy.psyche.model.QuestionBankListPageDTO;
import com.zcxy.psyche.service.IQuestionBankListService;
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
@Api(tags = "题库列表",value = "QuestionBankList")
@RequestMapping("/zcxy/questionBankList")
public class QuestionBankListController {

    @Autowired
    private IQuestionBankListService questionBankListService;

    @Autowired
    private QuestionBankListMapper mapper;

    @ApiOperation(value = "查询题库列表")
    @GetMapping("/list")
    private PageUtils list(QuestionBankListPageDTO pageDTO){
        return questionBankListService.getPageQuestionBankList(pageDTO);
    }


    @ApiOperation(value = "查询题库对应分类内容")
    @GetMapping("/getCategoryPaperList")
    private PageUtils getCategoryPaperList(QuestionBankListPageDTO pageDTO,String key){
        return questionBankListService.getCategoryPaperList(pageDTO,key);
    }

    @ApiOperation(value = "根据指定列和指定列的值模糊查询")
    @GetMapping("/getDataByKeyAndCategory")
    private PageUtils getDataByKeyAndCategory(QuestionBankListPageDTO pageDTO,String category,String key){
        return questionBankListService.getDataByKeyAndCategory(pageDTO,category,key);
    }

    @ApiOperation(value = "删除指定表、id的内容")
    @GetMapping("/deleteItem")
    private Integer deleteItem(String table,String id){
        return mapper.deleteItem(table,id);
    }

    @ApiOperation(value = "用户收藏题库")
    @GetMapping("/getCollectQuestionBankList")
    private List<QuestionBankList> getCollectQuestionBankList(String name){
        return mapper.getCollectQuestionBankList(name);
    }

    @ApiOperation(value = "根据id获取list")
    @GetMapping("/getListById")
    private QuestionBankList getListById(String id){
        return mapper.getListById(id);
    }

    @ApiOperation(value = "更新列表")
    @PostMapping("/updateQBList")
    private Integer updateQBList(@RequestBody KnowledgeList list){
        System.out.println(list);
        return mapper.updateQBList(list);
    }




}
