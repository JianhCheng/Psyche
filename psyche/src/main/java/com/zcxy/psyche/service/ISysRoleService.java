package com.zcxy.psyche.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.SysRole;
import com.zcxy.psyche.model.QuestionBankListPageDTO;
import com.zcxy.psyche.model.SysRolePageDTO;

import java.util.List;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author suhe
 * @since 2022-11-18
 */
public interface ISysRoleService extends IService<SysRole> {

    List<SysRole> queryByUserId(Integer userId);


    PageUtils getSysRoleList(SysRolePageDTO pageDTO);

    PageUtils getRoleById(SysRolePageDTO pageDTO, String name);
}
