package com.zcxy.psyche.model;

import com.zcxy.common.model.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("题库列表查询条件")
public class PaperListPageDTO extends PageDTO {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("文章标题")
    private String title;

    @ApiModelProperty("文章简介")
    private String intro;

    @ApiModelProperty("来源")
    private String srouce;

    @ApiModelProperty("创建时间")
    private LocalDateTime createtime;

}
