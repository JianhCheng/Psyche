package com.zcxy.psyche.controller;

import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.Journals;
import com.zcxy.psyche.model.AnalzeListPageDTO;
import com.zcxy.psyche.service.IAnalzeListService;
import com.zcxy.psyche.service.IJournalsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
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
@Api(tags = "期刊信息表",value = "Journals")
@RequestMapping("/zcxy/journals")
public class JournalsController {
    @Autowired
    private IJournalsService journalsService;

    @ApiOperation(value = "查询用户列表")
    @GetMapping("/list")
    private List<Journals> list(){
        return journalsService.list();
    }

}
