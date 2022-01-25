package com.epmo.pmai;

import com.epmo.pmai.account.Account;
import com.epmo.pmai.account.AccountRepository;
import com.epmo.pmai.keyword.Keyword;
import com.epmo.pmai.keyword.KeywordRepository;
import com.epmo.pmai.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectMAanagerAiApplication {

    @Autowired AccountRepository accountRepository;
    @Autowired
    KeywordRepository keywordRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjectMAanagerAiApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner2() {
        return args -> {
//            private Long id;
//            //email과 nickname으로 로그인 기능 제공할 예정이므로 unique
//
//            private String email;
//
//            private String password;
//
//            //EPMO, 계약, 검토자
//            private String role;
//

            //Project newProject = Project.builder().
            Account epmo1 = Account.builder().nickname("d23358").email("").name("박현조").role("EPMO").build();
            Account epmo2 = Account.builder().nickname("d00001").email("").name("김정완").role("EPMO").build();
            Account epmo3 = Account.builder().nickname("d00002").email("").name("김현수").role("EPMO").build();
            Account epmo4 = Account.builder().nickname("d00003").email("").name("전예지").role("EPMO").build();
            Account epmo5 = Account.builder().nickname("d00004").email("").name("송병훈").role("EPMO").build();
            Account epmo6 = Account.builder().nickname("d00005").email("").name("박원걸").role("EPMO").build();

            accountRepository.save(epmo1);
            accountRepository.save(epmo2);
            accountRepository.save(epmo3);
            accountRepository.save(epmo4);
            accountRepository.save(epmo5);
            accountRepository.save(epmo6);

            Keyword keyword = Keyword.builder().title("스토리지").build();
            keywordRepository.save(keyword);
        };
    }
}