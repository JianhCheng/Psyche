package com.zcxy.psyche.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcxy.psyche.entity.SysUser;
import com.zcxy.psyche.entity.UserCollectPaper;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserCollectPaperMapper extends BaseMapper<UserCollectPaper> {

    @Insert("insert into UserCollectPaper(userid,paperid) values((select userid from SysUser where username=#{username}),#{paperid});")
    Integer addLike(String username, String paperid);

    @Delete("delete from UserCollectPaper where paperid=#{paperid};")
    Integer deleteLike(String username, String paperid);

    @Select("select * from UserCollectPaper where paperid=#{paperid};")
    UserCollectPaper geIstCollect(String paperid);
}
