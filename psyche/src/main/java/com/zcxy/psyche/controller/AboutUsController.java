package com.zcxy.psyche.controller;

import com.zcxy.psyche.entity.AboutUs;
import com.zcxy.psyche.service.IAboutUsService;
import io.swagger.annotations.Api;
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
 * @since 2023-03-26
 */
@RestController
@CrossOrigin
@Api(tags = "关于我们文本信息",value = "AboutUs")
@RequestMapping("/zcxy/aboutUs")
public class AboutUsController {

    @Autowired
    private IAboutUsService aboutUsService;

    @GetMapping("/list")
    public List<AboutUs> list(){
        return aboutUsService.list();
    }

}
