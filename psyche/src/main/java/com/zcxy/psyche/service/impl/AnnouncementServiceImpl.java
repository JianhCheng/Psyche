package com.zcxy.psyche.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.Announcement;
import com.zcxy.psyche.entity.QuestionBankList;
import com.zcxy.psyche.mapper.AnnouncementMapper;
import com.zcxy.psyche.mapper.QuestionBankListMapper;
import com.zcxy.psyche.model.QuestionBankListPageDTO;
import com.zcxy.psyche.service.IAnnouncementService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author suhe
 * @since 2023-03-25
 */
@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements IAnnouncementService {

    @Autowired
    private AnnouncementMapper mapper;

    @Override
    public List<Announcement> getAList() {
        return mapper.getAList();
    }
}
