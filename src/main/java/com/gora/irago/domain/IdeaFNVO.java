package com.gora.irago.domain;

import lombok.Data;

@Data
public class IdeaFNVO {

    private Integer kid;
    
    private String title;
    private String content;
    private String stat;

    private IdeaVO idea;
    private Integer charger;
    
}
