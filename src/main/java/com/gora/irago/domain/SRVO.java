package com.gora.irago.domain;

import lombok.Data;

import java.util.Date;

@Data
public class SRVO {
    private int kid;
    private String title;
    private String content;
    private String type;
    private int regKid;
    private Date regDt;
    private String statFl;
    private int charKid;
}
