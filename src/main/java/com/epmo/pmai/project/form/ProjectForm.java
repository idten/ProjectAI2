package com.epmo.pmai.project.form;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProjectForm {
    private String title;
    //부서
    private String department;
    //담당자
    private String manager;

    //팀장
    private String teamLeader;

    //부서장
    private String depLeader;

}
