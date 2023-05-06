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
public class KnowledgeDetailPageDTO extends PageDTO {

    @ApiModelProperty("知识库id")
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

    @ApiModelProperty("是否收集")
    private Integer collect;

    @ApiModelProperty("类型")
    private String type;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("答案")
    private String explanation;

    @ApiModelProperty("创建时间")
    private LocalDateTime createtime;

}
