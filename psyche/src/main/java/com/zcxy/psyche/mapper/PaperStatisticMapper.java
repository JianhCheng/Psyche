package com.zcxy.psyche.mapper;

import com.zcxy.psyche.entity.PaperStatistic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zcxy.psyche.model.VO.MostReadVO;
import com.zcxy.psyche.model.VO.PaperDetailVO;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
public interface PaperStatisticMapper extends BaseMapper<PaperStatistic> {

    @Select("select s.*,l.title,l.intro,l.srouce,l.img " +
            "from PaperList l,PaperStatistic s " +
            "where s.id = l.id " +
            "order by readnum desc limit 6;")
    List<MostReadVO> getMostReadList();

    @Select("select s.*,l.title,l.intro,l.srouce,l.img " +
            "from PaperList l,PaperStatistic s " +
            "where s.id = l.id " +
            "order by collectnum desc limit 6;")
    List<MostReadVO> getMostCollectedList();

    @Select("select s.*,l.title,l.intro,l.srouce,l.img " +
            "from PaperList l,PaperStatistic s " +
            "where s.id = l.id " +
            "order by likenum desc limit 6;")
    List<MostReadVO> getMostLovedList();

    @Select("select s.*,l.title,l.intro,l.srouce,l.img from PaperList l,PaperStatistic s where s.id = l.id and s.recommend=1;")
    List<MostReadVO> getRecommendList();


    @Update("update PaperStatistic set likenum=likenum+(${operation})  where id=#{id};")
    Integer like(String id, Integer operation);

    @Update("update PaperStatistic set collectnum=collectnum+(${operation})  where id=#{id};")
    Integer collect(String id, Integer operation);
}
