package com.zcxy.psyche.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.SysUser;
import com.zcxy.psyche.model.SysUserPageDTO;

import java.util.List;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author 波哥
 * @since 2022-11-18
 */
public interface ISysUserService extends IService<SysUser> {

    List<SysUser> queryByUserName(String username);

    PageUtils getUserByName(SysUserPageDTO pageDTO, String username);
}
