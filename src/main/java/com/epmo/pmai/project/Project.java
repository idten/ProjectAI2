package com.epmo.pmai.project;


import com.epmo.pmai.product.Product;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue
    private Long id;

    ///1. 개요 ///////////////////////////
    //제목
    private String title;

    // 총 금액
    private Long totalAmount;

    // 개발, 물품
    private String projectType;

    //담당 epmo
    private String epmo;

    //담당자
    private String manager;

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

    //////3. 사업 내용 ///////
    //추진배경(객관식)
    private String background;

    //추진배경(상세)
    private String backgroundDetail;

    // 자본 총합
    private String capitalTotalAmount;

    // 경비 총합
    private String expenseTotalAmount;

    //도입내역
    @OneToMany
    private Set<Product> products;

    //////////4. 사업추진방법
    //업체선정 방법
    private String selectionMethod;

    private Boolean emergency;

    private String emergencyBackground;

    //소요시간
    private String duration;

    //협조부서
    private String cooperationDepartment;


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
