package com.zcxy.psyche.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcxy.psyche.entity.UserCollectKnowledge;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author suhe
 * @since 2023-03-26
 */
public interface IUserCollectKnowledgeService extends IService<UserCollectKnowledge> {


    Integer geIstCollect(String knowledgeid);

    Integer collect(String username, Integer operation, String knowledgeid);
}
