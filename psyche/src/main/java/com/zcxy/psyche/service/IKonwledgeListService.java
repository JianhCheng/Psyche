package com.zcxy.psyche.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.KnowledgeList;
import com.zcxy.psyche.model.KnowledgeListPageDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author suhe
 * @since 2023-03-25
 */
public interface IKonwledgeListService extends IService<KnowledgeList> {
    PageUtils getPageKnowledgeList(KnowledgeListPageDTO pageDTO);
}
