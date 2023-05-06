package com.zcxy.psyche.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.AnalzeList;
import com.zcxy.psyche.entity.QuestionBankDetail;
import com.zcxy.psyche.mapper.AnalzeListMapper;
import com.zcxy.psyche.model.AnalzeListPageDTO;
import com.zcxy.psyche.service.IAnalzeListService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author suhe
 * @since 2023-03-25
 */
@Service
public class AnalzeListServiceImpl extends ServiceImpl<AnalzeListMapper, AnalzeList> implements IAnalzeListService {

    @Override
    public PageUtils getPageAnalzeList(AnalzeListPageDTO pageDTO) {

        QueryWrapper<AnalzeList> queryWrapper=new QueryWrapper<AnalzeList>().like(
                StringUtils.isNoneEmpty(pageDTO.getId()),"id",pageDTO.getId()
        );
        Page<AnalzeList> page=this.page(pageDTO.page(),queryWrapper);

        return new PageUtils(page);

    }
}
