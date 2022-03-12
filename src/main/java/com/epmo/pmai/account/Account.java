package com.epmo.pmai.account;

import lombok.*;

import javax.persistence.Column;
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
public class Account {
    //Entity: 독자적인 식별자가 존재
    //Value : 그외
    //Entity 삭제 되면 Value도 삭제됨, value의 lifecycle은 종속적임
    @Id
    @GeneratedValue
    private Long id;

    private String department;

    private String nickname;
    //email과 nickname으로 로그인 기능 제공할 예정이므로 unique

    private String name;

    private String email;

    private String password;

    //EPMO, 계약, 검토자
    private String role;


}
