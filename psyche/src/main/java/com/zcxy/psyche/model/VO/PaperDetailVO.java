package com.zcxy.psyche.model.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class PaperDetailVO {
    private static final long serialVersionUID = 1L;

    private String id;

    private Integer category;

    private String time;

    private String url;

    private String auth;

    private String title;

    private String content;

    private String img;

    private String keywords;
}
