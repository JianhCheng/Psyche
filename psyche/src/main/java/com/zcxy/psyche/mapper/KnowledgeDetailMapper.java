package com.zcxy.psyche.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcxy.psyche.entity.KnowledgeDetail;
import org.apache.ibatis.annotations.Mapper;
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
public interface KnowledgeDetailMapper extends BaseMapper<KnowledgeDetail> {

    @Select("select * from KonwledgeDetail where qbid=#{id};")
    List<KnowledgeDetail> getKnowledgeDetail(String id);

    @Update("update KonwledgeDetail set `subject`=#{subject},`point`=#{point},chapter=#{chapter},`type`=#{type},title=#{title},explanation=#{explanation},img=#{img} where id=#{id};")
    Integer updateKDetail(KnowledgeDetail detail);
}
