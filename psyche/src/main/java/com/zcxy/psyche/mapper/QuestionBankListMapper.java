package com.zcxy.psyche.mapper;

import com.zcxy.psyche.entity.KnowledgeList;
import com.zcxy.psyche.entity.PaperList;
import com.zcxy.psyche.entity.QuestionBankDetail;
import com.zcxy.psyche.entity.QuestionBankList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author suhe
 * @since 2023-03-25
 */
@Mapper
public interface QuestionBankListMapper extends BaseMapper<QuestionBankList> {

    @Delete("delete from ${table} where id=#{id};")
    Integer deleteItem(String table, String id);

    @Select("select * from UserCollectQuestionBank c,QuestionBankList l,SysUser s where l.id=c.qbid and c.userid=s.userid and s.username=#{name} ;")
    List<QuestionBankList> getCollectQuestionBankList(String name);

    @Select("select * from QuestionBankList where id=#{id};")
    QuestionBankList getListById(String id);

    @Update("update KonwledgeList set title=#{title},category=#{category},isopen=#{isopen},coverurl=#{coverurl} where id=#{id};")
    Integer updateQBList(KnowledgeList list);

//    @Insert("insert into QuestionBankList() values()")
//    Integer addQBList(QuestionBankList list);
}
