package com.epmo.pmai.account;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of="id")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    //Entity: 독자적인 식별자가 존재
    //Value : 그외
    //Entity 삭제 되면 Value도 삭제됨, value의 lifecycle은 종속적임
    @Id
    @GeneratedValue
    private Long id;
    //email과 nickname으로 로그인 기능 제공할 예정이므로 unique

    @Column(unique = true)
    private String email;

    private String password;


}
