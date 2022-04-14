package com.epmo.pmai.product;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    //타입(개발, s/w, h/w)
    private ProductType productType;

    //도입항목
    private String productName ;

    //수량
    private Integer quantity;

    //단위
    private String unit;

    //유지보수 요율
    private String maintenanceRate;

    //등록일자
    private LocalDateTime publishedDateTime;

    //변경 일자
    private LocalDateTime modifiedDateTime;

    //상태
    private String status;

    //도입방식(신규/증설/교체)
    private String purchaseMethod;

    //도입사유
    //(신규)
    //1. 신규시스템 구축
    //2. 시스템 이전
    //3. DR 시스템 구축
    //(증설)
    //1. 용량증설
    //2. 업무 거래량 증가
    //(교체)
    //1. EOS
    //2. 장애
    private String purchaseReason;

    //도입사유 상세
    private String purchaseReasonDetail;

    //현재 용량
    private String currentCapacity;
    //현재 사용량
    private String currentUsage;
    //현재 사용률
    private String currentUsageRate;

    //도입(구입) 수량
    private String purchaseCapacity;

    //용량산정근기
    private String basisCalculation;

    //도입방식(이기종/동일기종/동일제조사)
    private String purchaseMethod2;

    // 제품지정사유(if 동일기종 or 동일 제조사)
    private String reasonDesignation;

    // 기존 장비 처리 방법(if 교체)
    private String handlingMethodCurrentEquipment;

    // 판로지원법 대상
    private String lawForSmallCompany;

    // 랙필요 여부
    private String rackRequired;

    //면진장비 여부
    private String earthquakePreventionEquipmentRequired;

    //요구사항 명세(if 이기종)
    private String RequirementSpecification;

    //계약 방법(수의계약..)
    private String contractMethod;

    //긴급여부
    private String emergency;

    //통합발주여부
    private String combinedOrder;

    //설치담당
    private String installManager;

    //운영담당
    private String operateManager;

}
