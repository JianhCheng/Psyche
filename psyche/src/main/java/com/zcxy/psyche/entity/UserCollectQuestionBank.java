package com.zcxy.psyche.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "UserCollectQuestionBank", description = "")
@TableName("UserCollectQuestionBank")
public class UserCollectQuestionBank {

    private Integer id;

    private Integer userid;

    private String qbid;

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
        return qbid;
    }

    public void setPaperid(String paperid) {
        this.qbid = paperid;
    }

    @Override
    public String toString() {
        return "UserCollectPaper{" +
                "id=" + id +
                ", userid=" + userid +
                ", paperid='" + qbid + '\'' +
                '}';
    }
}
