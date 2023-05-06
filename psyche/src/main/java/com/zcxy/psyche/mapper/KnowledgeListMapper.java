package com.zcxy.psyche.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcxy.psyche.entity.KnowledgeList;
import org.apache.ibatis.annotations.Delete;
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
public interface KnowledgeListMapper extends BaseMapper<KnowledgeList> {

    @Select("select l.* from UserCollectKnowledge c,KonwledgeList l,SysUser s where l.id=c.knowledgeid and c.userid=s.userid and s.username=#{name};")
    List<KnowledgeList> getCollectKnowledge(String name);

    @Select("select * from KonwledgeList where id=#{id};")
    KnowledgeList getKnowledge(String id);

    @Delete("delete from ${table} where id=#{id};")
    Integer deleteItem(String table, String id);

    @Update("")
    Integer updateKList(KnowledgeList list);
}
