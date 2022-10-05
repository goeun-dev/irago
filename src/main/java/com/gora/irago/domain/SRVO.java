package com.gora.irago.domain;

import lombok.Data;

import java.util.Date;

@Data
public class SRVO {

    /* SR 식별값 */
    private int kid;
    /* SR 제목 */
    private String title;
    /* SR 내용 */
    private String content;
    /* SR 요청 분류 */
    private String type;
    /* SR 처리 상태 */
    private String statFl;
    /* SR 등록일 */
    private Date regDt;

    /* SR 등록자 식별값 */
    private int regKid;
    /* SR 등록자 이름 */
    private String regName;
    /* SR 등록자 아이디 */
    private String regId;

    /* SR 처리자 식별값 */
    private int charKid;
    /* SR 처리자 이름 */
    private String charName;
    /* SR 처리자 아이디 */
    private String charId;
}
