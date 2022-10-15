package com.gora.irago.service;

import com.gora.irago.domain.SRVO;

import java.util.List;

public interface SRService {
    List<SRVO> findSrList();

    SRVO findSR(SRVO srVO);

    int addSR(SRVO srVO);

    int modifySR(SRVO srVO);

    int removeSR(SRVO srVO);
}
