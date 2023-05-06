package com.zcxy.psyche.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcxy.psyche.entity.QuestionBankDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
public interface QuestionBankDetailMapper extends BaseMapper<QuestionBankDetail> {

    @Select("select distinct chapter from QuestionBankDetail  where qbid = #{id};")
    List<String> getQBDetailStructure(String id);

    @Select("select * from QuestionBankDetail  where chapter = #{struct} and qbid=#{id};")
    List<QuestionBankDetail> getQBDetail(String struct,String id);

    @Select("select * from QuestionBankDetail where qbid=#{qbid} and chapter=#{chapter} and id> #{id} limit 1;")
    List<QuestionBankDetail> getNextQuestion(String qbid, String id, String chapter);

    @Select("select * from QuestionBankDetail where id=#{id};")
    List<QuestionBankDetail> getQuestion(String id);

    @Select("select * from QuestionBankDetail where qbid=#{qbid} and chapter=#{chapter} and id>= #{id} limit 10;")
    List<QuestionBankDetail> getTenQuestion(String qbid, String id, String chapter);


    @Select("select * from QuestionBankDetail where qbid=#{qbid} and chapter=#{chapter} and id> #{id} limit 1;")
    List<QuestionBankDetail> preQuestion(String qbid, String id, String chapter);

    @Select("select * from QuestionBankDetail where qbid=#{qbid} and chapter=#{chapter} and id< #{id} limit 1;")
    List<QuestionBankDetail> aftQuestion(String qbid, String id, String chapter);

    @Update("update QuestionBankDetail set title=#{title},`subject`=#{subject},chapter=#{chapter},`point`=#{point},`type`=#{type},img=#{img},`options`=#{options} where id=#{id};")
    Integer updateQBDetail(QuestionBankDetail detail);
}
