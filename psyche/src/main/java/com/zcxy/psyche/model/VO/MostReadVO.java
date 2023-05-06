package com.zcxy.psyche.model.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MostReadVO {
    private String id;

    private String title;

    private String intro;

    private String img;


    private Integer collectnum;

    private Integer likenum;

    private Integer readnum;

}
