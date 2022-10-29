package com.gora.irago.domain;

import lombok.Data;

import java.util.Date;

@Data
public class IdeaFNVO {

    private Integer kid;
    
    private String name;
    private String description;
    private String stat;

    private Integer ideaKid;
    private Integer charger;

    private Date regDate;

    private Integer priority;
    /* order by */
    private String order;
    
}
