package com.zcxy.psyche.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcxy.psyche.entity.AnalzeList;
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
public interface AnalzeListMapper extends BaseMapper<AnalzeList> {

    @Select("select * from AnalzeList where id=#{id};")
    List<AnalzeList> getAnalzeList(String id);

    @Update("update AnalzeList set `analyze`=#{analyze},img=#{img} where id=#{id};")
    Integer updateAnalze(AnalzeList analze);
}
