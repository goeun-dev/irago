package com.gora.irago.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class IdeaVO {
    private Integer kid;
    private String name;
    private String description;
    private String stat;
    private String delFl;
    private Date regDt;

    private List<IdeaFNVO> ideaFNList;

}
