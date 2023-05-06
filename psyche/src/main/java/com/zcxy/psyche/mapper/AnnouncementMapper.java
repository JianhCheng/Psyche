package com.zcxy.psyche.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcxy.psyche.entity.Announcement;
import com.zcxy.psyche.entity.QuestionBankList;
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
public interface AnnouncementMapper extends BaseMapper<Announcement> {

    @Select("select * from Announcement;")
    List<Announcement> getAList();
}
