package com.zcxy.psyche.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.KnowledgeDetail;
import com.zcxy.psyche.model.KnowledgeDetailPageDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author suhe
 * @since 2023-03-25
 */
public interface IKnowledgeDetailService extends IService<KnowledgeDetail> {
    PageUtils getPageKnowledgeDetail(KnowledgeDetailPageDTO pageDTO);
}
