package com.epmo.pmai.project.form;

import com.epmo.pmai.project.ProjectStep;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class EtcForm {

    ///////////5. 기타

    //등록일자
    private LocalDateTime publishedDateTime;

    //epmo 확인 일자
    private LocalDateTime approvaledDateTime;


    //현재 단계(임시저장 - 저장 - 승인(epmo)
    private ProjectStep step;

    @Column(unique = true)
    private String path;


}
