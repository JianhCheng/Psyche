package com.zcxy.psyche.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author suhe
 * @since 2023-03-25
 */
@ApiModel(value = "KonwledgeList对象", description = "")
@TableName("KonwledgeList")
public class KnowledgeList implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String title;

    private String category;

    private String userhead;

    private Integer userid;

    private String username;

    private Integer isopen;

    private String coverurl;

    private LocalDateTime createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getUserhead() {
        return userhead;
    }

    public void setUserhead(String userhead) {
        this.userhead = userhead;
    }
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public Integer getIsopen() {
        return isopen;
    }

    public void setIsopen(Integer isopen) {
        this.isopen = isopen;
    }
    public String getCoverurl() {
        return coverurl;
    }

    public void setCoverurl(String coverurl) {
        this.coverurl = coverurl;
    }
    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "KonwledgeList{" +
            "id=" + id +
            ", title=" + title +
            ", category=" + category +
            ", userhead=" + userhead +
            ", userid=" + userid +
            ", username=" + username +
            ", isopen=" + isopen +
            ", coverurl=" + coverurl +
            ", createtime=" + createtime +
        "}";
    }
}
