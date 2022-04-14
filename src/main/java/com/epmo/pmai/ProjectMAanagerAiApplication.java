package com.epmo.pmai;

import com.epmo.pmai.account.Account;
import com.epmo.pmai.account.AccountRepository;
import com.epmo.pmai.config.ProjectType;
import com.epmo.pmai.config.ProjectTypeRepository;
import com.epmo.pmai.keyword.Keyword;
import com.epmo.pmai.keyword.KeywordRepository;
import com.epmo.pmai.project.Project;
import com.epmo.pmai.project.ProjectService;
import com.epmo.pmai.project.form.ProjectForm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.validation.constraints.NotBlank;

@SpringBootApplication
public class ProjectMAanagerAiApplication {

    @Autowired AccountRepository accountRepository;
    @Autowired KeywordRepository keywordRepository;
    @Autowired ProjectTypeRepository projectTypeRepository;
    @Autowired ProjectService projectService;


    public static void main(String[] args) {
        SpringApplication.run(ProjectMAanagerAiApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner2() {
        return args -> {

            //Project newProject = Project.builder().
            Account epmo1 = Account.builder().nickname("d23358")
                    .email("luel83@ibk.co.kr").name("박현조").role("EPMO")
                    .department("IT기획부").build();
            Account epmo2 = Account.builder().nickname("d23325")
                    .email("lemonbom2@gmail.com").name("김정완").role("EPMO")
                    .department("IT기획부").build();
            Account epmo3 = Account.builder().nickname("d44491")
                    .email("chris.hskim@ibk.co.kr").name("김현수").role("EPMO")
                    .department("IT기획부").build();
            Account epmo4 = Account.builder().nickname("d43131")
                    .email("jeonyeji@ibk.co.kr").name("전예지").role("EPMO")
                    .department("IT기획부").build();
            Account epmo5 = Account.builder().nickname("d42477").email("").name("송병훈").role("EPMO")
                    .department("IT기획부").build();
            Account epmo6 = Account.builder().nickname("d23564").email("").name("박원걸").role("EPMO")
                    .department("IT기획부").build();
            Account epmo7 = Account.builder().nickname("d20047").email("").name("김상백").role("EPMO")
                    .department("IT기획부").build();

            //발의자
            Account initiator1 = Account.builder().nickname("d11111").email("")
                    .name("송태일").role("INITIATOR")
                    .department("자금세탁방지부").build();

            accountRepository.save(epmo1);
            accountRepository.save(epmo2);
            accountRepository.save(epmo3);
            accountRepository.save(epmo4);
            accountRepository.save(epmo5);
            accountRepository.save(epmo6);
            accountRepository.save(epmo7);

            accountRepository.save(initiator1);


            Keyword keyword = Keyword.builder().title("스토리지").build();
            keywordRepository.save(keyword);


            ProjectType projectType1 = ProjectType.builder()
                    .id("storage").title("스토리지").build();
            ProjectType projectType2 = ProjectType.builder()
                    .id("network").title("네트워크").build();
            ProjectType projectType3 = ProjectType.builder()
                    .id("security").title("보안").build();

            projectTypeRepository.save(projectType1);
            projectTypeRepository.save(projectType2);
            projectTypeRepository.save(projectType3);

//            private String title;
//
//            private String department;
//            // 개발, 물품
//            @NotBlank
//            private String projectType;
//
//            private String epmo;
//            //담당자
//            private String manager;
//
//            private String keyword;
//
            //ModelMapper modelMapper = new ModelMapper();

            Project initProject = Project.builder()
                    .title("자금세탁방지시스템 스토리지 증설")
                    .department("자금세탁방지부")
                    .projectType("스토리지")
                    .epmo("박현조")
                    .manager("송태일")
                    .keyword("자금세탁방지시스템, 스토리지, 증설")
                    .build();
            Project newProject = projectService.createNewProject(initProject);

        };
    }
}