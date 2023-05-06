package com.zcxy.psyche.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.zcxy.common.model.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("题库详情查询查询条件")
public class PaperDetailPageDTO extends PageDTO {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("类型")
    private Integer category;

    @ApiModelProperty("出版时间")
    private String time;

    @ApiModelProperty("文章网页地址")
    private String url;

    @ApiModelProperty("作者")
    private String auth;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("关键词")
    private String keywords;

    @ApiModelProperty("创建时间")
    private LocalDateTime createtime;
}
