package com.zcxy.psyche.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcxy.psyche.entity.UserCollectPaper;
import com.zcxy.psyche.entity.UserLikePaper;
import com.zcxy.psyche.mapper.UserCollectPaperMapper;
import com.zcxy.psyche.mapper.UserLikePaperMapper;
import com.zcxy.psyche.service.IUserCollectPaperService;
import com.zcxy.psyche.service.IUserLikePaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLikePaperService extends ServiceImpl<UserLikePaperMapper, UserLikePaper> implements IUserLikePaperService {

    @Autowired
    private UserLikePaperMapper mapper;


    @Override
    public Integer geIstLike(String paperid) {
        UserLikePaper like=mapper.geIstLike(paperid);
        if(like!=null){
            System.out.println(like);
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public Integer like(String username, Integer operation, String paperid) {
        if(operation==1){
            return mapper.addLike(username,paperid);
        }
        else if(operation==0) {
            return mapper.deleteLike(username,paperid);
        }
        else {
            return null;
        }
    }
}
