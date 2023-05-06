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
@ApiModel(value = "AnalzeList对象", description = "")
@TableName("AnalzeList")
public class AnalzeList implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @TableField("`analyze`")
    private String analyze;

    private String img;

    private LocalDateTime createtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getAnalyze() {
        return analyze;
    }

    public void setAnalyze(String analyze) {
        this.analyze = analyze;
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
        return "AnalzeList{" +
            "id=" + id +
            ", analyze=" + analyze +
            ", img=" + img +
            ", createtime=" + createtime +
        "}";
    }
}
