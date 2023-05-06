package com.zcxy.psyche.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcxy.psyche.entity.UserCollectKnowledge;
import com.zcxy.psyche.entity.UserCollectQuestionBank;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserCollectQuestionBankMapper extends BaseMapper<UserCollectQuestionBank> {

    @Insert("insert into UserCollectQuestionBank(userid,qbid) values((select userid from SysUser where username=#{username}),#{qbid});")
    Integer addLike(String username, String qbid);

    @Delete("delete from UserCollectQuestionBank where qbid=#{qbid};")
    Integer deleteLike(String username, String qbid);

    @Select("select * from UserCollectQuestionBank where qbid=#{qbid};")
    UserCollectQuestionBank geIstCollect(String qbid);
}
