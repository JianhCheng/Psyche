package com.zcxy.psyche.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.PaperList;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
public interface PaperListMapper extends BaseMapper<PaperList> {

    List<PaperList> getlatestThreePaper();

    @Select("select l.* from UserCollectPaper c,PaperList l,SysUser s where l.id=c.paperid and c.userid=s.userid and s.username=#{name};")
    List<PaperList> getCollectPaper(String name);

    @Delete("delete from PaperList where id=#{id};")
    Integer deletePaperList(String id);

    @Delete("delete from PaperDetail where id=#{id};")
    Integer deletePaperDetail(String id);
}
