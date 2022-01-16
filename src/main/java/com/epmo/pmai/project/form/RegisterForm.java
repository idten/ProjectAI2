package com.epmo.pmai.project.form;

import lombok.Data;
import lombok.RequiredArgsConstructor;

//발의자 정보
@Data
@RequiredArgsConstructor
public class RegisterForm {

    //2. 발의자
    //부서
    private String department;

    //팀장
    private String teamLeader;

    //부서장
    private String depLeader;

    //본부장
    private String generalLeader;

    //부행장
    private String vicePresident;

}
