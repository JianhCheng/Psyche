package com.zcxy.psyche.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcxy.psyche.entity.AboutUs;
import com.zcxy.psyche.entity.UserCollectPaper;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author suhe
 * @since 2023-03-26
 */
public interface IUserCollectPaperService extends IService<UserCollectPaper> {

    Integer like(String username, Integer operation,String paperid);

    Integer geIstCollect(String knowledgeid);
}
