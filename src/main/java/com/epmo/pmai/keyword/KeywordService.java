package com.epmo.pmai.keyword;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class KeywordService {
    private final KeywordRepository keywordRepository;

    public Keyword findOrCreateNew(String keywordTitle){
        Keyword keyword = keywordRepository.findByTitle(keywordTitle);
        if(keyword == null){
            keyword = keywordRepository.save(Keyword.builder().title(keywordTitle).build());
        }
        return keyword;
    }

    public Keyword findByTitle(String keywordTitle){
        return null;
    }
}
