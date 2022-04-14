package com.epmo.pmai.project.form;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@RequiredArgsConstructor
public class ProjectForm {

    private String title;

    private String department;
    // 개발, 물품
    @NotBlank
    private String projectType;

    private String epmo;
    //담당자
    private String manager;

    private String keyword;

//    private String fullDescription;

}
