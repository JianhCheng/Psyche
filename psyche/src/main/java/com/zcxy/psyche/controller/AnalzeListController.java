package com.zcxy.psyche.controller;

import com.zcxy.psyche.entity.AnalzeList;
import com.zcxy.psyche.mapper.AnalzeListMapper;
import com.zcxy.psyche.service.IAnalzeListService;
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
@Api(tags = "解析详情列表",value = "AnalzeList")
@RequestMapping("/zcxy/analzeList")
public class AnalzeListController {

    @Autowired
    private IAnalzeListService analzeListService;

    @Autowired
    private AnalzeListMapper mapper;

    @ApiOperation(value = "查询解析")
    @GetMapping("/getAnalzeList")
    private List<AnalzeList> getAnalzeList(String id){
        return mapper.getAnalzeList(id);
    }

    @ApiOperation(value = "查询解析")
    @PostMapping("/updateAnalze")
    private Integer updateAnalze(@RequestBody AnalzeList analze){
        System.out.println(analze);
        return mapper.updateAnalze(analze);
    }

}
