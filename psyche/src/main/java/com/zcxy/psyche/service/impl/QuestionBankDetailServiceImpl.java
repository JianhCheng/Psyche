package com.zcxy.psyche.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.QuestionBankDetail;
import com.zcxy.psyche.entity.QuestionBankList;
import com.zcxy.psyche.mapper.QuestionBankDetailMapper;
import com.zcxy.psyche.model.QuestionBankDetailPageDTO;
import com.zcxy.psyche.service.IQuestionBankDetailService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author suhe
 * @since 2023-03-25
 */
@Service
public class QuestionBankDetailServiceImpl extends ServiceImpl<QuestionBankDetailMapper, QuestionBankDetail> implements IQuestionBankDetailService {

    @Autowired
    private QuestionBankDetailMapper mapper;

    @Override
    public PageUtils getPageQuestionBankDetail(QuestionBankDetailPageDTO pageDTO) {

        QueryWrapper<QuestionBankDetail> queryWrapper=new QueryWrapper<QuestionBankDetail>().like(
                StringUtils.isNoneEmpty(pageDTO.getTitle()),"title",pageDTO.getTitle()
        );
        Page<QuestionBankDetail> page=this.page(pageDTO.page(),queryWrapper);

        return new PageUtils(page);

    }

    @Override
    public PageUtils getQBDetailById(QuestionBankDetailPageDTO pageDTO, String qbid) {
        QueryWrapper<QuestionBankDetail> queryWrapper=new QueryWrapper<QuestionBankDetail>();
        queryWrapper.eq(
                StringUtils.isNoneEmpty(pageDTO.getQbid()),"qbid",qbid
        );
        Page<QuestionBankDetail> page=this.page(pageDTO.page(),queryWrapper);

        return new PageUtils(page);
    }

    @Override
    public List<QuestionBankDetail> getNextQuestion(String qbid, String id, String chapter, Integer operation) {
        if(operation==1){
           return mapper.preQuestion(qbid,id,chapter);
        }
        else if(operation==-1){
            return mapper.aftQuestion(qbid,id,chapter);
        }
        else {
            return null;
        }
    }

}
