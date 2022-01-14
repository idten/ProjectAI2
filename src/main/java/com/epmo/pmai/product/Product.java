package com.epmo.pmai.product;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    private ProductType ProductType;

    //상세 목록(서버, 스토리지, 등 )
    private String productDetail;

    //수량
    private String count;

    //단위
    private String unit;

    //가격
    private Long amount ;

    //근거
    private String evidence;

}
