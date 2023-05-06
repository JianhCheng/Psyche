package com.zcxy.psyche.model;


import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.zcxy.common.model.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel("系统角色列表查询条件")
public class SysUserPageDTO extends PageDTO {

    @ApiModelProperty("用户id")
    private Integer userid;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("年龄")
    private String age;

    @ApiModelProperty("生日")
    private String birth;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("爱好")
    private String liketodo;

    @ApiModelProperty("个人签名")
    private String sign;

    @ApiModelProperty("介绍")
    private String intro;

    @ApiModelProperty("头像")
    private String userhead;

    @ApiModelProperty("状态  0：禁用   1：正常")
    private Integer status;

    @ApiModelProperty("创建者ID")
    private Long createUserId;

    @ApiModelProperty("创建时间")
    private LocalDateTime createtime;
}
