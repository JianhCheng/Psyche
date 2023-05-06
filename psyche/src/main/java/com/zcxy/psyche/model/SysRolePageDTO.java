package com.zcxy.psyche.model;


import com.zcxy.common.model.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("系统角色列表查询条件")
public class SysRolePageDTO extends PageDTO {

    @ApiModelProperty("角色id")
    private Integer roleid;

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建者ID")
    private Long createUserId;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
}
