package com.zcxy.psyche.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "UserLikePaper", description = "")
@TableName("UserLikePaper")
public class UserLikePaper {


    private Integer id;

    private Integer userid;

    private String paperid;

    @Override
    public String toString() {
        return "UserLikePaper{" +
                "id=" + id +
                ", userid=" + userid +
                ", paperid='" + paperid + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPaperid() {
        return paperid;
    }

    public void setPaperid(String paperid) {
        this.paperid = paperid;
    }
}
