package com.gora.irago.domain;

import lombok.Data;

import java.util.Date;

@Data
public class UserVO {

    private String name;
    private String auth;
    private Date regDt;
    private String delFl;
    private Date delDt;
    private int kid;
    private String id;
    private String pw;

}
