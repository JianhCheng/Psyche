package com.zcxy.psyche.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.KnowledgeDetail;
import com.zcxy.psyche.entity.QuestionBankDetail;
import com.zcxy.psyche.mapper.KnowledgeDetailMapper;
import com.zcxy.psyche.model.KnowledgeDetailPageDTO;
import com.zcxy.psyche.service.IKnowledgeDetailService;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class KnowledgeDetailServiceImpl extends ServiceImpl<KnowledgeDetailMapper, KnowledgeDetail> implements IKnowledgeDetailService {

    @Override
    public PageUtils getPageKnowledgeDetail(KnowledgeDetailPageDTO pageDTO) {

        QueryWrapper<KnowledgeDetail> queryWrapper=new QueryWrapper<KnowledgeDetail>().eq(
                StringUtils.isNoneEmpty(pageDTO.getQbid()),"qbid",pageDTO.getQbid()
        );
        Page<KnowledgeDetail> page=this.page(pageDTO.page(),queryWrapper);

        return new PageUtils(page);

    }
}
