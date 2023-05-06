package com.zcxy.psyche.service.impl;

import com.zcxy.psyche.entity.SysRole;
import com.zcxy.psyche.entity.SysUser;
import com.zcxy.psyche.mapper.SysRoleMapper;
import com.zcxy.psyche.service.ISysRoleService;
import com.zcxy.psyche.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 认证校验的方法
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    ISysUserService sysUserService;

    @Autowired
    ISysRoleService sysRoleService;

    @Autowired
    SysRoleMapper sysRoleMapper;

    /**
     * 完成账号的校验
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1.需要根据账号查询
        List<SysUser> list = sysUserService.queryByUserName(username);
        if(list != null && list.size() == 1){
            // 账号是存在的
            SysUser sysUser = list.get(0);

            // 根据当前登录的账号查询到关联的角色信息
//            System.out.println(sysRoleService.queryByUserId(sysUser.getId()));
            List<SysRole> sysRoles = sysRoleMapper.queryByUserId(sysUser.getUserid());
            System.out.println(sysRoles);
            List<GrantedAuthority> listRole = new ArrayList<>();
            if(sysRoles != null && sysRoles.size() > 0){
                for (SysRole sysRole : sysRoles) {
                    listRole.add(new SimpleGrantedAuthority(sysRole.getName()));
                }
            }
            return new User(sysUser.getUsername(),new BCryptPasswordEncoder().encode(sysUser.getPassword()),listRole);
        }
        return null;
    }
}
