package com.epmo.pmai.project.form;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@RequiredArgsConstructor
public class OutlineForm {

    ///1. 개요 ///////////////////////////
    //제목
    private String title;

    // 총 금액
    private Long totalAmount;

    // 개발, 물품
    @NotBlank
    private String projectType;

    //담당 epmo
    private String epmo;

    //담당자
    private String manager;

}
