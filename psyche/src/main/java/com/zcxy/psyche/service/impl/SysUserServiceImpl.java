package com.zcxy.psyche.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zcxy.common.constant.SystemConstant;
import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.SysRole;
import com.zcxy.psyche.entity.SysUser;
import com.zcxy.psyche.mapper.SysUserMapper;
import com.zcxy.psyche.model.SysUserPageDTO;
import com.zcxy.psyche.service.ISysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author 波哥
 * @since 2022-11-18
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {


    @Override
    public List<SysUser> queryByUserName(String username) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();

        wrapper.eq(StringUtils.isNotBlank(username),"username",username);
//        wrapper.eq("status", SystemConstant.USER_STATUS_NORMAL);
        System.out.println(this.baseMapper.selectList(wrapper));
        return this.baseMapper.selectList(wrapper);
    }

    @Override
    public PageUtils getUserByName(SysUserPageDTO pageDTO, String username) {
        QueryWrapper<SysUser> queryWrapper=new QueryWrapper<SysUser>().like(
                StringUtils.isNoneEmpty(pageDTO.getUsername()),"username",username
        );
        Page<SysUser> page=this.page(pageDTO.page(),queryWrapper);
        return new PageUtils(page);
    }
}
