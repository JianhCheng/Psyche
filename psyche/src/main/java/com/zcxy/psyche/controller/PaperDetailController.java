package com.zcxy.psyche.controller;

import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.PaperList;
import com.zcxy.psyche.mapper.PaperDetailMapper;
import com.zcxy.psyche.model.PaperDetailPageDTO;
import com.zcxy.psyche.model.VO.PaperDetailVO;
import com.zcxy.psyche.service.IPaperDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@Api(tags = "文章详情列表",value = "PaperDetail")
@RequestMapping("/zcxy/paperDetail")
public class PaperDetailController {

    @Autowired
    private IPaperDetailService service;

    @Autowired
    PaperDetailMapper mapper;

    @ApiOperation(value = "查询用户列表")
    @GetMapping("/list")
    private PageUtils list(PaperDetailPageDTO pageDTO){
        return service.getPagePaperDetail(pageDTO);
    }

    @ApiOperation(value = "通过文章id查询文章详情")
    @GetMapping("/getPaperDetailById")
    private PaperDetailVO getPaperDetailById(String id){

        PaperDetailVO paperDetail= mapper.getPaperDetailById(id);

        return paperDetail;
    }

    @ApiOperation(value = "查询某篇文章后的五篇文章")
    @GetMapping("/getNextFivePaper")
    private List<PaperList> getNextFivePaper(String id){

        List<PaperList> paper = mapper.getNextFivePaper(id);

        return paper;
    }

    @ApiOperation(value = "模糊查询")
    @GetMapping("/getByKeywords")
    private List<PaperList> getByKeywords(String filed,String key){

        List<PaperList> paper = mapper.getByKeywords(filed,key);
        return paper;
    }
}
