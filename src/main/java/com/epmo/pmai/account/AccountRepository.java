package com.epmo.pmai.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly=true)
public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByName(String name);

    List<Account> findByRole(String role);
}
