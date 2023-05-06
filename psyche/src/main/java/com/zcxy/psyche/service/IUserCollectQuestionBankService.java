package com.zcxy.psyche.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcxy.psyche.entity.UserCollectKnowledge;
import com.zcxy.psyche.entity.UserCollectQuestionBank;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author suhe
 * @since 2023-03-26
 */
public interface IUserCollectQuestionBankService extends IService<UserCollectQuestionBank> {


    Integer geIstCollect(String qbid);

    Integer collect(String username, Integer operation, String qbid);
}
