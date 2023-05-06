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
@ApiModel(value = "PaperList对象", description = "")
@TableName("PaperList")
public class PaperList implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String title;

    private String intro;

    private String srouce;

    private String img;

    private LocalDateTime createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
    public String getSrouce() {
        return srouce;
    }

    public void setSrouce(String srouce) {
        this.srouce = srouce;
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
        return "PaperList{" +
            "id=" + id +
            ", title=" + title +
            ", intro=" + intro +
            ", srouce=" + srouce +
            ", img=" + img +
            ", createtime=" + createtime +
        "}";
    }
}
