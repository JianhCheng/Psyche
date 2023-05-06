package com.zcxy.psyche.controller;

import com.zcxy.common.model.PageDTO;
import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.SysRole;
import com.zcxy.psyche.entity.SysUser;
import com.zcxy.psyche.mapper.SysUserMapper;
import com.zcxy.psyche.model.SysRolePageDTO;
import com.zcxy.psyche.model.SysUserPageDTO;
import com.zcxy.psyche.model.VO.UserInfoVO;
import com.zcxy.psyche.service.ISysRoleService;
import com.zcxy.psyche.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author
 * @since 2022-11-18
 */
@Api(tags = "系统用户",value = "SysUser")
@RestController
@RequestMapping("/sys/sysUser")
public class SysUserController {
    @Autowired
    private ISysUserService service;

    @Autowired
    private SysUserMapper mapper;

    @ApiOperation(value = "查询列表")
    @GetMapping("/register")
    private Integer register(String username,String passwd){
        return mapper.register(username,passwd);
    }

    @ApiOperation(value = "查询列表")
    @GetMapping("/list")
    private List<SysUser> list(){
        return service.list();
    }

    @ApiOperation(value = "查询用户信息")
    @GetMapping("/getUserInfo")
    private List<UserInfoVO> getUserInfo(String name){
        return mapper.getUserInfo(name);
    }

    @ApiOperation(value = "更新用户信息")
    @PostMapping("/UpdateUser")
    private Integer UpdateUser(@RequestBody SysUser user){
        System.out.println(user);
        return mapper.UpdateUser(user);
    }

    @ApiOperation(value = "根据用户名获取用户")
    @GetMapping("/getUserByName")
    private PageUtils getUserByName(SysUserPageDTO pageDTO, String username){
        System.out.println(username);
        return service.getUserByName(pageDTO,username);
    }

    @ApiOperation(value = "新增用户")
    @GetMapping("/addUser")
    private Integer addUser(String username,String password){
        System.out.println(username);
        return mapper.addUser(username,password);
    }

    @ApiOperation(value = "删除用户")
    @GetMapping("/deleteUser")
    private Integer deleteUser(String userid){
        System.out.println(userid);
        return mapper.deleteUser(userid);
    }



}
