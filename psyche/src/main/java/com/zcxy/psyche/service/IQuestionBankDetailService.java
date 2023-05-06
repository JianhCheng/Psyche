package com.zcxy.psyche.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.QuestionBankDetail;
import com.zcxy.psyche.model.QuestionBankDetailPageDTO;
import com.zcxy.psyche.model.UserListPageDTO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author suhe
 * @since 2023-03-25
 */
public interface IQuestionBankDetailService extends IService<QuestionBankDetail> {
    PageUtils getPageQuestionBankDetail(QuestionBankDetailPageDTO pageDTO);

    PageUtils getQBDetailById(QuestionBankDetailPageDTO pageDTO, String qbid);

    List<QuestionBankDetail> getNextQuestion(String qbid, String id, String chapter, Integer operation);
}
