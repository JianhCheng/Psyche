package com.zcxy.psyche.controller;

import com.zcxy.psyche.entity.Announcement;
import com.zcxy.psyche.entity.Journals;
import com.zcxy.psyche.service.IAnnouncementService;
import com.zcxy.psyche.service.IJournalsService;
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
@Api(tags = "系统公告信息表",value = "Journals")
@RequestMapping("/zcxy/Announcement")
public class AnnouncementController {
    @Autowired
    private IAnnouncementService service;

    @ApiOperation(value = "查询公告列表")
    @GetMapping("/getAList")
    private List<Announcement> getAList(){

        return service.getAList();
    }

}
