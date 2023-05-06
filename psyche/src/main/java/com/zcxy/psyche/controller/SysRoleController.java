package com.zcxy.psyche.controller;

import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.SysRole;
import com.zcxy.psyche.entity.SysUser;
import com.zcxy.psyche.mapper.QuestionBankDetailMapper;
import com.zcxy.psyche.mapper.SysRoleMapper;
import com.zcxy.psyche.model.QuestionBankDetailPageDTO;
import com.zcxy.psyche.model.QuestionBankListPageDTO;
import com.zcxy.psyche.model.SysRolePageDTO;
import com.zcxy.psyche.service.ISysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author suhe
 * @since 2022-11-18
 */

@Api(tags = "系统角色",value = "SysRole")
@RestController
@RequestMapping("/zcxy/sysRole")
public class SysRoleController {

    @Autowired
    private ISysRoleService service;

    @Autowired
    private SysRoleMapper mapper;

    @ApiOperation(value = "查询角色列表")
    @GetMapping("/list")
    private PageUtils list(SysRolePageDTO pageDTO){
        return service.getSysRoleList(pageDTO);
    }

    @ApiOperation(value = "更新用户信息")
    @GetMapping("/UpdateRole")
    private Integer UpdateRole(Integer roleid,String name,String remark){
        System.out.println(roleid+name+remark);
        return mapper.UpdateRole(roleid,name,remark);
    }

    @ApiOperation(value = "删除角色")
    @GetMapping("/deleteRole")
    private Integer deleteRole(Integer roleid){
        return mapper.deleteRole(roleid);
    }

    @ApiOperation(value = "新增角色")
    @GetMapping("/addRole")
    private Integer addRole(String name,String remark){
        return mapper.addRole(name,remark);
    }

    @ApiOperation(value = "新增角色")
    @GetMapping("/getRoleById")
    private PageUtils getRoleById(SysRolePageDTO pageDTO,String name){
        return service.getRoleById(pageDTO,name);
    }


}
