package com.zcxy.psyche.controller;

import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.KnowledgeList;
import com.zcxy.psyche.entity.PaperList;
import com.zcxy.psyche.entity.QuestionBankList;
import com.zcxy.psyche.mapper.KnowledgeListMapper;
import com.zcxy.psyche.model.KnowledgeListPageDTO;
import com.zcxy.psyche.service.IKnowledgeDetailService;
import com.zcxy.psyche.service.IKonwledgeListService;
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
@Api(tags = "知识点列表",value = "KonwledgeList")
@RequestMapping("/zcxy/konwledgeList")
public class KnowledgeListController {

    @Autowired
    private IKonwledgeListService konwledgeListService;

    @Autowired
    private KnowledgeListMapper mapper;

    @ApiOperation(value = "查询知识点列表")
    @GetMapping("/list")
    private PageUtils list(KnowledgeListPageDTO pageDTO){
        return konwledgeListService.getPageKnowledgeList(pageDTO);
    }

    @ApiOperation(value = "用户收藏文章")
    @GetMapping("/getCollectKnowledge")
    private List<KnowledgeList> getCollectKnowledge(String name){
        return mapper.getCollectKnowledge(name);
    }

    @ApiOperation(value = "知识点详情")
    @GetMapping("/getKnowledge")
    private KnowledgeList getKnowledge(String id){
        return mapper.getKnowledge(id);
    }

    @ApiOperation(value = "删除指定表、id的内容")
    @GetMapping("/deleteItem")
    private Integer deleteItem(String table,String id){
        System.out.println(table+id);
        return mapper.deleteItem(table,id);
    }

    @ApiOperation(value = "更新列表")
    @PostMapping("/updateKList")
    private Integer updateKList(@RequestBody KnowledgeList list){
        System.out.println(list);
        return mapper.updateKList(list);
    }

}
