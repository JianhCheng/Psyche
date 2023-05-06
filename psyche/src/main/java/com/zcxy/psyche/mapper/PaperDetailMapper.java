package com.zcxy.psyche.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcxy.psyche.entity.PaperDetail;
import com.zcxy.psyche.entity.PaperList;
import com.zcxy.psyche.model.VO.PaperDetailVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author suhe
 * @since 2023-03-25
 */
@Repository
public interface PaperDetailMapper extends BaseMapper<PaperDetail> {

    @Select("select d.*,l.img " +
            "from PaperDetail d,PaperList l " +
            "where d.id=l.id " +
            "and d.id=#{id}")
    PaperDetailVO getPaperDetailById(String id);

    @Select("select * from PaperList where id > #{id} limit 5;")
    List<PaperList> getNextFivePaper(String id);

    @Select("select * from PaperList where title like #{key};")
    List<PaperList> getByKeywords(String filed, String key);
}
