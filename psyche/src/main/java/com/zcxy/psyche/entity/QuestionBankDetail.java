package com.zcxy.psyche.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
@ApiModel(value = "QuestionBankDetail对象", description = "")
@TableName("QuestionBankDetail")
public class QuestionBankDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private String qbid;

    private String id;

    @TableField("`subject`")
    private String subject;

    @TableField("`point`")
    private String point;

    private String chapter;

    @TableField("`type`")
    private String type;

    private String title;

    @TableField("`options`")
    private String options;

    private String img;

    private LocalDateTime createtime;

    public String getQbid() {
        return qbid;
    }

    public void setQbid(String qbid) {
        this.qbid = qbid;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "QuestionBankDetail{" +
                "qbid='" + qbid + '\'' +
                ", id='" + id + '\'' +
                ", subject='" + subject + '\'' +
                ", point='" + point + '\'' +
                ", chapter='" + chapter + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", options='" + options + '\'' +
                ", img='" + img + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
