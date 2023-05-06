package com.zcxy.psyche.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcxy.psyche.entity.UserCollectPaper;
import com.zcxy.psyche.entity.UserLikePaper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserLikePaperMapper extends BaseMapper<UserLikePaper> {

    @Select("select * from UserLikePaper where paperid=#{paperid};")
    UserLikePaper geIstLike(String paperid);

    @Insert("insert into UserLikePaper(userid,paperid) values((select userid from SysUser where username=#{username}),#{paperid});")
    Integer addLike(String username, String paperid);

    @Delete("delete from UserLikePaper where paperid=#{paperid};")
    Integer deleteLike(String username, String paperid);
}
