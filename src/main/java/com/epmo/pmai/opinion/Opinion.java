package com.epmo.pmai.opinion;

import com.epmo.pmai.account.Account;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Opinion {
    @Id
    @GeneratedValue
    private String id;

    private String title;
}
