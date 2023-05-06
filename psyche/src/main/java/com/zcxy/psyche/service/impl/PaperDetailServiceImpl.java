package com.zcxy.psyche.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.PaperDetail;
import com.zcxy.psyche.entity.QuestionBankDetail;
import com.zcxy.psyche.mapper.PaperDetailMapper;
import com.zcxy.psyche.model.PaperDetailPageDTO;
import com.zcxy.psyche.service.IPaperDetailService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author suhe
 * @since 2023-03-25
 */
@Service
public class PaperDetailServiceImpl extends ServiceImpl<PaperDetailMapper, PaperDetail> implements IPaperDetailService {

    @Override
    public PageUtils getPagePaperDetail(PaperDetailPageDTO pageDTO) {

        QueryWrapper<PaperDetail> queryWrapper=new QueryWrapper<PaperDetail>().like(
                StringUtils.isNoneEmpty(pageDTO.getTitle()),"title",pageDTO.getTitle()
        );
        Page<PaperDetail> page=this.page(pageDTO.page(),queryWrapper);

        return new PageUtils(page);

    }
}
