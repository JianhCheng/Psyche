package com.zcxy.psyche.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.SysUser;
import com.zcxy.psyche.model.VO.UserInfoVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author
 * @since 2022-11-18
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    @Select("select * from SysUser where username= #{username};")
    List<SysUser> queryByUserName(String username);

    @Select("select u.userid,u.username,r.`name`,u.email,u.mobile,u.age,u.birth,u.sex,u.intro,u.`liketodo`,u.`sign`,u.userhead,u.`status`,u.createtime from SysUser u , UserToRole t,SysRole r where u.userid=t.uId and t.rId=r.roleid and username= #{name};")
    List<UserInfoVO> getUserInfo(String name);

    @Select("insert into SysUser(username,`password`) values(#{username},#{passwd});")
    Integer register(String username, String passwd);

    @Update("update SysUser set username=#{username},email=#{email},mobile=#{mobile},age=#{age},birth=#{birth},sex=#{sex},liketodo=#{liketodo},sign=#{sign},userhead=#{userhead},intro=#{intro} " +
            "where userid=#{userid};")
    Integer UpdateUser(SysUser user);

    @Insert("insert into SysUser(username,password) values (#{username},#{password})")
    Integer addUser(String username, String password);

    @Delete("delete from SysUser where userid=#{userid};")
    Integer deleteUser(String userid);



//    @Select("select * from SysUser where username = #{username};")
//    PageUtils getUserByName(String name);
}
