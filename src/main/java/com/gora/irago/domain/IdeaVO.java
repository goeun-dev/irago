package com.gora.irago.domain;

import lombok.Data;

import java.util.Date;

@Data
public class IdeaVO {
    private Integer kid;
    private String title;
    private String content;
    private String stat;
    private String delFl;
    private Date regDt;
}
