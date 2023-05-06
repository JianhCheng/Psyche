package com.zcxy.psyche.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

@ApiModel(value = "SysRole对象", description = "")
@TableName("SysRole")
public class SysRole {

    @TableId(value = "roleid", type = IdType.AUTO)
    private Integer roleid;

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("创建者ID")
    @TableField("`createUserId`")
    private Long createUserId;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("`createtime`")
    private LocalDateTime createTime;

    public Integer getId() {
        return roleid;
    }

    public void setId(Integer id) {
        this.roleid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "roleid=" + roleid +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", createUserId=" + createUserId +
                ", createTime=" + createTime +
                '}';
    }
}
