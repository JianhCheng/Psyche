package com.zcxy.psyche.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zcxy.psyche.entity.SysUser;
import com.zcxy.psyche.entity.UserCollectPaper;
import com.zcxy.psyche.entity.UserLikePaper;
import com.zcxy.psyche.mapper.SysUserMapper;
import com.zcxy.psyche.mapper.UserCollectPaperMapper;
import com.zcxy.psyche.service.IUserCollectPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCollectPaperService extends ServiceImpl<UserCollectPaperMapper, UserCollectPaper> implements IUserCollectPaperService {

    @Autowired
    private UserCollectPaperMapper mapper;

    @Override
    public Integer like(String username, Integer operation,String paperid) {
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

    @Override
    public Integer geIstCollect(String paperid) {
        UserCollectPaper like=mapper.geIstCollect(paperid);
        if(like!=null){
            System.out.println(like);
            return 1;
        }else{
            return 0;
        }
    }
}
