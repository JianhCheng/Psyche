package com.zcxy.psyche.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.QuestionBankList;
import com.zcxy.psyche.entity.SysRole;
import com.zcxy.psyche.mapper.SysRoleMapper;
import com.zcxy.psyche.model.SysRolePageDTO;
import com.zcxy.psyche.service.ISysRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author suhe
 * @since 2022-11-18
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Autowired
    private ISysRoleService sysRoleMapper;

    public List<SysRole> queryByUserId(Integer userId) {
        return sysRoleMapper.queryByUserId(userId);
    }

    @Override
    public PageUtils getSysRoleList(SysRolePageDTO pageDTO) {
        QueryWrapper<SysRole> queryWrapper=new QueryWrapper<SysRole>().like(
                StringUtils.isNoneEmpty(pageDTO.getName()),"name",pageDTO.getName()
        );
        Page<SysRole> page=this.page(pageDTO.page(),queryWrapper);
        return new PageUtils(page);
    }

    @Override
    public PageUtils getRoleById(SysRolePageDTO pageDTO, String name) {
        QueryWrapper<SysRole> queryWrapper=new QueryWrapper<SysRole>().eq(
                StringUtils.isNoneEmpty(pageDTO.getName()),"name",name
        );
        Page<SysRole> page=this.page(pageDTO.page(),queryWrapper);
        return new PageUtils(page);
    }
}
