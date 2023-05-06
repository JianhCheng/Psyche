package com.zcxy.psyche.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "SysUser对象", description = "")
@TableName("UserCollectPaper")
public class UserCollectPaper {

    private Integer id;

    private Integer userid;

    private String paperid;

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

    @Override
    public String toString() {
        return "UserCollectPaper{" +
                "id=" + id +
                ", userid=" + userid +
                ", paperid='" + paperid + '\'' +
                '}';
    }
}
