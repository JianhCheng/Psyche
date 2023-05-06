package com.zcxy.psyche.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zcxy.psyche.entity.UserCollectPaper;
import com.zcxy.psyche.entity.UserLikePaper;

public interface IUserLikePaperService  extends IService<UserLikePaper> {
    Integer geIstLike(String paperid);

    Integer like(String username, Integer operation, String paperid);
}
