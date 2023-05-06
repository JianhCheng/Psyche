package com.zcxy.psyche.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value = "Journals对象", description = "")
@TableName("Journals")
public class Journals implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String nameZn;

    private String nameEn;

    private String intro;

    private String coverurl;

    private LocalDateTime createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getNameZn() {
        return nameZn;
    }

    public void setNameZn(String nameZn) {
        this.nameZn = nameZn;
    }
    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }
    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
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
        return "Journals{" +
            "id=" + id +
            ", nameZn=" + nameZn +
            ", nameEn=" + nameEn +
            ", intro=" + intro +
            ", coverurl=" + coverurl +
            ", createtime=" + createtime +
        "}";
    }
}
