package com.zcxy.psyche.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcxy.psyche.entity.PaperStatistic;
import com.zcxy.psyche.entity.QuestionBankStatistic;
import com.zcxy.psyche.model.VO.KowledgeStatisticVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 文章数据表 Mapper 接口
 * </p>
 *
 * @author suhe
 * @since 2023-03-28
 */
@Repository
public interface QuestionBankStatisticMapper extends BaseMapper<QuestionBankStatistic> {




    @Select("update QuestionBankStatistic set collectnum=collectnum+(${operation})  where id=#{id};")
    Integer collect(String id, Integer operation);
}
