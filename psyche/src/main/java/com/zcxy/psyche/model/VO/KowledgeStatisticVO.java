package com.zcxy.psyche.model.VO;

import lombok.Data;

@Data
public class KowledgeStatisticVO {
    private String id;

    private String title;

    private Integer collectnum;

    private Integer likenum;

    private Integer readnum;
}
