package com.zcxy.psyche.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.SysRole;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author
 * @since 2022-11-18
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    @Select("SELECT * FROM SysRole s WHERE s.roleid IN ( SELECT rId FROM UserToRole s2 WHERE s2.uId = #{userId} );")
    List<SysRole> queryByUserId(Integer userId);

    @Update("update SysRole set `name`=#{name}, remark=#{remark} where roleid = #{roleid};")
    Integer UpdateRole(Integer roleid,String name,String remark);

    @Delete("delete from SysRole where roleid=#{roleid};")
    Integer deleteRole(Integer roleid);

    @Insert("insert  into `SysRole`(`name`,`remark`) values (#{name},#{remark})")
    Integer addRole(String name, String remark);
}
