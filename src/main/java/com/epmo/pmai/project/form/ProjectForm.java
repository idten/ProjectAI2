package com.epmo.pmai.project.form;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@RequiredArgsConstructor
public class ProjectForm {

    private String title;
    // 총 금액
    private Long totalAmount;

    // 개발, 물품
    @NotBlank
    private String projectType;

    //담당자
    private String manager;

    private String shortDescription;

    private String fullDescription;

}
