package com.zcxy.psyche.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.PaperDetail;
import com.zcxy.psyche.model.PaperDetailPageDTO;
import com.zcxy.psyche.model.QuestionBankDetailPageDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author suhe
 * @since 2023-03-25
 */
public interface IPaperDetailService extends IService<PaperDetail> {
    PageUtils getPagePaperDetail(PaperDetailPageDTO pageDTO);
}
