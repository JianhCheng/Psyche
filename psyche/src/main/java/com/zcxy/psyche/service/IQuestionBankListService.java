package com.zcxy.psyche.service;

import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.QuestionBankList;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zcxy.psyche.model.QuestionBankListPageDTO;
import com.zcxy.psyche.model.UserListPageDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author suhe
 * @since 2023-03-25
 */
public interface IQuestionBankListService extends IService<QuestionBankList> {
    PageUtils getPageQuestionBankList(QuestionBankListPageDTO pageDTO);

    PageUtils getCategoryPaperList(QuestionBankListPageDTO pageDTO,String key);

    PageUtils getDataByKeyAndCategory(QuestionBankListPageDTO pageDTO,String category, String key);
}
