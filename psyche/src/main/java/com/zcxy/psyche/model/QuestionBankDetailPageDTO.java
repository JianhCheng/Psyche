package com.zcxy.psyche.model;

import com.zcxy.common.model.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("题库详情查询查询条件")
public class QuestionBankDetailPageDTO extends PageDTO {

    @ApiModelProperty("id")
    private String qbid;

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("学科")
    private String subject;

    @ApiModelProperty("重点")
    private String point;

    @ApiModelProperty("章节")
    private String chapter;

    @ApiModelProperty("正确率")
    private Integer correctRate;

    @ApiModelProperty("刷题次数")
    private Integer brushedCount;

    @ApiModelProperty("是否收藏")
    private Integer collect;

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("题目")
    private String title;

    @ApiModelProperty("选项")
    private String options;

    @ApiModelProperty("创建时间")
    private LocalDateTime createtime;

}
