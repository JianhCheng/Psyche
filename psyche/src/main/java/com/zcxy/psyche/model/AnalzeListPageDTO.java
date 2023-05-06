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
public class AnalzeListPageDTO extends PageDTO {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("解析")
    private String analyze;

    @ApiModelProperty("创建时间")
    private LocalDateTime createtime;

}
