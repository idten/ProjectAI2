package com.epmo.pmai.cooperation;


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
public class Cooperation {

    @Id
    @GeneratedValue
    private Long id;

    //부서명
    private String departmentName;

    private String detail;

    private String negotiator;

}
