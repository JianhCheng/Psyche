package com.zcxy.psyche.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 文章数据表
 * </p>
 *
 * @author suhe
 * @since 2023-03-28
 */
@ApiModel(value = "PaperStatistic对象", description = "文章数据表")
@TableName("PaperStatistic")
public class PaperStatistic implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("文章id")
    private String id;

    @ApiModelProperty("收藏数量")
    private Integer collectnum;

    @ApiModelProperty("点赞数量")
    private Integer likenum;

    @ApiModelProperty("阅读数量")
    private Integer readnum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Integer getCollectNum() {
        return collectnum;
    }

    public void setCollectNum(Integer collectNum) {
        this.collectnum = collectNum;
    }
    public Integer getLikeNum() {
        return likenum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likenum = likeNum;
    }
    public Integer getReadNum() {
        return readnum;
    }

    public void setReadNum(Integer readNum) {
        this.readnum = readNum;
    }

    @Override
    public String toString() {
        return "PaperStatistic{" +
            "id=" + id +
            ", collectNum=" + collectnum +
            ", likeNum=" + likenum +
            ", readNum=" + readnum +
        "}";
    }
}
