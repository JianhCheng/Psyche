package com.zcxy.psyche.model;

import com.zcxy.common.model.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("系统用户列表查询条件")
public class UserListPageDTO extends PageDTO {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("权限")
    private String authority;

    @ApiModelProperty("创建时间")
    private String createtime;

}
