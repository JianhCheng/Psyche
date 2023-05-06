package com.zcxy.psyche.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcxy.psyche.entity.UserCollectKnowledge;
import com.zcxy.psyche.entity.UserCollectPaper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserCollectKnowledgeMapper extends BaseMapper<UserCollectKnowledge> {

    @Insert("insert into UserCollectKnowledge(userid,knowledgeid) values((select userid from SysUser where username=#{username}),#{knowledgeid});")
    Integer addLike(String username, String knowledgeid);

    @Delete("delete from UserCollectKnowledge where knowledgeid=#{knowledgeid};")
    Integer deleteLike(String username, String knowledgeid);

    @Select("select * from UserCollectKnowledge where knowledgeid=#{knowledgeid};")
    UserCollectKnowledge geIstCollect(String knowledgeid);
}
