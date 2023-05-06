package com.zcxy.psyche.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value = "PaperDetail对象", description = "")
@TableName("PaperDetail")
public class PaperDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private Integer category;

    @TableField("`time`")
    private String time;

    private String url;

    private String auth;

    private String title;

    private String content;

    private String keywords;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }


    @Override
    public String toString() {
        return "PaperDetail{" +
            "id=" + id +
            ", category=" + category +
            ", time=" + time +
            ", url=" + url +
            ", auth=" + auth +
            ", title=" + title +
            ", content=" + content +
            ", keywords=" + keywords +
        "}";
    }
}
