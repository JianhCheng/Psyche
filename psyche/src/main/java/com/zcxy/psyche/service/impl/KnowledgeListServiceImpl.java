package com.zcxy.psyche.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.KnowledgeList;
import com.zcxy.psyche.mapper.KnowledgeListMapper;
import com.zcxy.psyche.model.KnowledgeListPageDTO;
import com.zcxy.psyche.service.IKonwledgeListService;
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
public class KnowledgeListServiceImpl extends ServiceImpl<KnowledgeListMapper, KnowledgeList> implements IKonwledgeListService {


    @Override
    public PageUtils getPageKnowledgeList(KnowledgeListPageDTO pageDTO) {

        QueryWrapper<KnowledgeList> queryWrapper=new QueryWrapper<KnowledgeList>().like(
                StringUtils.isNoneEmpty(pageDTO.getTitle()),"title",pageDTO.getTitle()
        );
        Page<KnowledgeList> page=this.page(pageDTO.page(),queryWrapper);

        return new PageUtils(page);

    }
}
