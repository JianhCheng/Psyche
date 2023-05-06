package com.zcxy.psyche.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcxy.psyche.entity.UserCollectKnowledge;
import com.zcxy.psyche.entity.UserCollectPaper;
import com.zcxy.psyche.mapper.UserCollectKnowledgeMapper;
import com.zcxy.psyche.mapper.UserCollectPaperMapper;
import com.zcxy.psyche.service.IUserCollectKnowledgeService;
import com.zcxy.psyche.service.IUserCollectPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCollectKnowledgeService extends ServiceImpl<UserCollectKnowledgeMapper, UserCollectKnowledge> implements IUserCollectKnowledgeService {

    @Autowired
    private UserCollectKnowledgeMapper mapper;

    @Override
    public Integer collect(String username, Integer operation,String knowledgeid) {
        if(operation==1){
            return mapper.addLike(username,knowledgeid);
        }
        else if(operation==0) {
            return mapper.deleteLike(username,knowledgeid);
        }
        else {
            return null;
        }
    }

    @Override
    public Integer geIstCollect(String knowledgeid) {
        UserCollectKnowledge collect=mapper.geIstCollect(knowledgeid);
        if(collect!=null){
            System.out.println(collect);
            return 1;
        }else{
            return 0;
        }
    }
}
