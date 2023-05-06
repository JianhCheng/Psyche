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
public class KnowledgeListPageDTO extends PageDTO {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("分类")
    private String category;

    @ApiModelProperty("用户头像")
    private String userhead;

    @ApiModelProperty("用户id")
    private Integer userid;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("是否公开")
    private Integer isopen;

    @ApiModelProperty("创建时间")
    private LocalDateTime createtime;

}
