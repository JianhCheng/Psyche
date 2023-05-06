package com.zcxy.psyche.model.VO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserInfoVO {

    private Integer userid;

    private String username;

    private String name;

    private String email;

    private String mobile;

    private String age;

    private LocalDateTime birth;

    private String sex;

    private String intro;

    private String sign;

    private String liketodo;

    private String userhead;

    private String Authority;

    private Integer status;

    private LocalDateTime createTime;
}
