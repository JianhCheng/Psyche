package com.zcxy.psyche.controller;

import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.KnowledgeDetail;
import com.zcxy.psyche.entity.KnowledgeList;
import com.zcxy.psyche.mapper.KnowledgeDetailMapper;
import com.zcxy.psyche.model.KnowledgeDetailPageDTO;
import com.zcxy.psyche.service.IKnowledgeDetailService;
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
@Api(tags = "知识点详情列表",value = "KonwledgeDetail")
@RequestMapping("/zcxy/konwledgeDetail")
public class KnowledgeDetailController {

    @Autowired
    private IKnowledgeDetailService knowledgeDetailService;

    @Autowired
    private KnowledgeDetailMapper mapper;

    @ApiOperation(value = "分页查询")
    @GetMapping("/list")
    private PageUtils list(KnowledgeDetailPageDTO pageDTO){
        return knowledgeDetailService.getPageKnowledgeDetail(pageDTO);
    }

    @ApiOperation(value = "查询知识点详情")
    @GetMapping("/getKnowledgeDetail")
    private List<KnowledgeDetail> getKnowledgeDetail(String id){
        return mapper.getKnowledgeDetail(id);
    }

    @ApiOperation(value = "更新")
    @PostMapping("/updateKDetail")
    private Integer updateKDetail(@RequestBody KnowledgeDetail detail){
        System.out.println(detail);
        return mapper.updateKDetail(detail);
    }


}
