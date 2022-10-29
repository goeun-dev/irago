package com.gora.irago.domain;

import lombok.Data;

import java.util.ArrayList;

@Data
public class PriorityVO {

    /** Priority Tbl */
    private String division;
    private String type;
    private Integer priority;
    private String order;

    private Integer kid;


}
