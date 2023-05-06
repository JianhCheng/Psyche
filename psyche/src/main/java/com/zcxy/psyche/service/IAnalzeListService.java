package com.zcxy.psyche.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.AnalzeList;
import com.zcxy.psyche.model.AnalzeListPageDTO;
import com.zcxy.psyche.model.QuestionBankDetailPageDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author suhe
 * @since 2023-03-25
 */
public interface IAnalzeListService extends IService<AnalzeList> {
    PageUtils getPageAnalzeList(AnalzeListPageDTO pageDTO);
}
