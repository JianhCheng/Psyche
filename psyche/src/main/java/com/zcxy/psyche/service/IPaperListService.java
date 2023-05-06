package com.zcxy.psyche.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.PaperList;
import com.zcxy.psyche.model.PaperListPageDTO;
import com.zcxy.psyche.model.QuestionBankDetailPageDTO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author suhe
 * @since 2023-03-25
 */
public interface IPaperListService extends IService<PaperList> {
    PageUtils getPagePaperList(PaperListPageDTO pageDTO);

    PageUtils getPageBySrc(PaperListPageDTO pageDTO);

    List<PaperList> getlatestThreePaper();

    PageUtils searchByName(PaperListPageDTO pageDTO);

    Integer deletePaper(String id);
}
