package com.zcxy.psyche.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcxy.psyche.entity.Announcement;
import com.zcxy.psyche.entity.QuestionBankStatistic;

import java.util.List;

/**
 * <p>
 * 文章数据表 服务类
 * </p>
 *
 * @author suhe
 * @since 2023-03-28
 */
public interface IAnnouncementService extends IService<Announcement> {

    List<Announcement> getAList();
}
