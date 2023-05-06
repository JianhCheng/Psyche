package com.zcxy.psyche.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcxy.common.util.ListUtil;
import com.zcxy.common.util.PageUtils;
import com.zcxy.psyche.entity.PaperList;


import com.zcxy.psyche.mapper.PaperListMapper;
import com.zcxy.psyche.model.PaperListPageDTO;
import com.zcxy.psyche.service.IPaperListService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
public class PaperListServiceImpl extends ServiceImpl<PaperListMapper, PaperList> implements IPaperListService {

    @Resource
    private PaperListMapper mapper;

    @Override
    public PageUtils getPagePaperList(PaperListPageDTO pageDTO) {

        QueryWrapper<PaperList> queryWrapper=new QueryWrapper<PaperList>().like(
                StringUtils.isNoneEmpty(pageDTO.getTitle()),"title",pageDTO.getTitle()
        );
        Page<PaperList> page=this.page(pageDTO.page(),queryWrapper);

        return new PageUtils(page);

    }

    @Override
    public PageUtils getPageBySrc(PaperListPageDTO pageDTO) {
        QueryWrapper<PaperList> queryWrapper=new QueryWrapper<PaperList>().like(
                StringUtils.isNoneEmpty(pageDTO.getSrouce()),"srouce",pageDTO.getSrouce()
        );
        Page<PaperList> page=this.page(pageDTO.page(),queryWrapper);

        return new PageUtils(page);
    }

    @Override
    public List<PaperList> getlatestThreePaper() {
        return mapper.getlatestThreePaper();

    }

    @Override
    public PageUtils searchByName(PaperListPageDTO pageDTO) {
        System.out.println(pageDTO);
        QueryWrapper<PaperList> queryWrapper=new QueryWrapper<PaperList>();
        queryWrapper.like(
                StringUtils.isNoneEmpty(pageDTO.getTitle()),"title",pageDTO.getTitle()
        );
        Page<PaperList> page=this.page(pageDTO.page(),queryWrapper);
        System.out.println(page.getRecords());
        return new PageUtils(page);
    }

    @Override
    public Integer deletePaper(String id) {
        System.out.println("id:"+id);
        Integer list=mapper.deletePaperList(id);
        Integer detail=mapper.deletePaperDetail(id);
        System.out.println(list+"  "+detail);
        if(list==1 && detail ==1){
            return 1;
        }
        else{
            return 0;
        }
    }
}
