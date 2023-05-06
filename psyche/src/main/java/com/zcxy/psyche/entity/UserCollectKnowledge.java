package com.zcxy.psyche.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "UserCollectKnowledge", description = "")
@TableName("UserCollectKnowledge")
public class UserCollectKnowledge {

    private Integer id;

    private Integer userid;

    private String knowledgeid;

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
        return knowledgeid;
    }

    public void setPaperid(String paperid) {
        this.knowledgeid = paperid;
    }

    @Override
    public String toString() {
        return "UserCollectPaper{" +
                "id=" + id +
                ", userid=" + userid +
                ", paperid='" + knowledgeid + '\'' +
                '}';
    }
}
