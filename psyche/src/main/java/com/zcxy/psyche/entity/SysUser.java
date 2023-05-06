package com.zcxy.psyche.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
@ApiModel(value = "SysUser对象", description = "")
@TableName("SysUser")
public class SysUser {

    private static final long serialVersionUID = 1L;

//    @TableId(value = "userid", type = IdType.AUTO)
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
    @TableField("`status`")
    private Integer status;

    @ApiModelProperty("创建者ID")
    @TableField("`createUserId`")
    private Long createUserId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty("创建时间")
    @TableField("`createtime`")
    private LocalDateTime createTime;

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getLiketodo() {
        return liketodo;
    }

    public void setLiketodo(String liketodo) {
        this.liketodo = liketodo;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getUserhead() {
        return userhead;
    }

    public void setUserhead(String userhead) {
        this.userhead = userhead;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "SysUser{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", age='" + age + '\'' +
                ", birth='" + birth + '\'' +
                ", sex='" + sex + '\'' +
                ", liketodo='" + liketodo + '\'' +
                ", sign='" + sign + '\'' +
                ", intro='" + intro + '\'' +
                ", userhead='" + userhead + '\'' +
                ", status=" + status +
                ", createUserId=" + createUserId +
                ", createTime=" + createTime +
                '}';
    }
}
