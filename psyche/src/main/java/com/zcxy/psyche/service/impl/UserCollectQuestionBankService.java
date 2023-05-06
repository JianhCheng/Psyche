package com.zcxy.psyche.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcxy.psyche.entity.UserCollectKnowledge;
import com.zcxy.psyche.entity.UserCollectQuestionBank;
import com.zcxy.psyche.mapper.UserCollectKnowledgeMapper;
import com.zcxy.psyche.mapper.UserCollectQuestionBankMapper;
import com.zcxy.psyche.service.IUserCollectKnowledgeService;
import com.zcxy.psyche.service.IUserCollectQuestionBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCollectQuestionBankService extends ServiceImpl<UserCollectQuestionBankMapper, UserCollectQuestionBank> implements IUserCollectQuestionBankService {

    @Autowired
    private UserCollectQuestionBankMapper mapper;

    @Override
    public Integer collect(String username, Integer operation,String qbid) {
        if(operation==1){
            return mapper.addLike(username,qbid);
        }
        else if(operation==0) {
            return mapper.deleteLike(username,qbid);
        }
        else {
            return null;
        }
    }

    @Override
    public Integer geIstCollect(String qbid) {
        UserCollectQuestionBank collect=mapper.geIstCollect(qbid);
        if(collect!=null){
            System.out.println(collect);
            return 1;
        }else{
            return 0;
        }
    }
}
