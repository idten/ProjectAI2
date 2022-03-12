package com.epmo.pmai.config;


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
public class ProjectType {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    //향후 관련해서 Type 별 가이드 내용 등 추가 하면 될 것으로 보임


}
