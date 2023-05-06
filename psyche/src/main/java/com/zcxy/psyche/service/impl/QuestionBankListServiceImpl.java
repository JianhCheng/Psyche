package com.zcxy.psyche.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.QuestionBankList;
import com.zcxy.psyche.mapper.QuestionBankListMapper;
import com.zcxy.psyche.model.QuestionBankListPageDTO;
import com.zcxy.psyche.service.IQuestionBankListService;
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
public class QuestionBankListServiceImpl extends ServiceImpl<QuestionBankListMapper, QuestionBankList> implements IQuestionBankListService {

    @Override
    public PageUtils getPageQuestionBankList(QuestionBankListPageDTO pageDTO) {
        QueryWrapper<QuestionBankList> queryWrapper=new QueryWrapper<QuestionBankList>().like(
                StringUtils.isNoneEmpty(pageDTO.getTitle()),"title",pageDTO.getTitle()
        );
        Page<QuestionBankList> page=this.page(pageDTO.page(),queryWrapper);

        return new PageUtils(page);

    }

    @Override
    public PageUtils getCategoryPaperList(QuestionBankListPageDTO pageDTO,String key) {
        QueryWrapper<QuestionBankList> queryWrapper=new QueryWrapper<QuestionBankList>();
        queryWrapper.like(StringUtils.isNotBlank(key),"title",key);
        Page<QuestionBankList> page=this.page(pageDTO.page(),queryWrapper);

        return new PageUtils(page);

    }

    @Override
    public PageUtils getDataByKeyAndCategory(QuestionBankListPageDTO pageDTO, String category, String key) {
        QueryWrapper<QuestionBankList> queryWrapper=new QueryWrapper<QuestionBankList>();
        queryWrapper.like(StringUtils.isNotBlank(key),category,key);
        Page<QuestionBankList> page=this.page(pageDTO.page(),queryWrapper);

        return new PageUtils(page);
    }
}
