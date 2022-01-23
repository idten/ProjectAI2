package com.epmo.pmai.keyword;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface KeywordRepository extends JpaRepository<Keyword,Long> {

    Keyword findByTitle(String title);

}
