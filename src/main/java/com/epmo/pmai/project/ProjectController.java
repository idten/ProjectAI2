package com.epmo.pmai.project;


import com.epmo.pmai.account.Account;
import com.epmo.pmai.account.AccountRepository;
import com.epmo.pmai.config.ProjectType;
import com.epmo.pmai.config.ProjectTypeRepository;
import com.epmo.pmai.keyword.Keyword;
import com.epmo.pmai.keyword.KeywordRepository;
import com.epmo.pmai.project.form.*;
import com.epmo.pmai.project.form.OutlineForm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectRepository projectRepository;
    private final ProjectService projectService;
    private final ModelMapper modelMapper;
    private final AccountRepository accountRepository;
    private final ProjectTypeRepository projectTypeRepository;
    private final KeywordRepository keywordRepository;
    private final ObjectMapper objectMapper;

    @GetMapping("/new-project")
    public String newProjectForm(Model model) throws JsonProcessingException {
    //    model.addAttribute(account);
        model.addAttribute(new ProjectForm());
        List<Account> epmoLists = accountRepository.findByRole("EPMO");
        log.info("epmoList:"+epmoLists.size()+"명");
        model.addAttribute("epmoLists",epmoLists);

        List<ProjectType> projectTypeLists = projectTypeRepository.findAll();
        log.info("projectTypeLists:"+projectTypeLists.size()+"명");


        model.addAttribute("projectTypeLists",projectTypeLists);

        //향후 수정 필요부분
        //현재는 특정 사용자 고정
        Account initiator = accountRepository.findByNickname("d11111");
        model.addAttribute("initiator",initiator);

        return "project/form";
    }
    @PostMapping("/new-project")
    public String newProjectSubmit(@Valid ProjectForm projectForm, Errors errors){
        if(errors.hasErrors()){
            return "project/form";
        }
        log.info("[projectAI]projectForm.toString():"+projectForm.toString());
        Project newProject = projectService.createNewProject(modelMapper.map(projectForm,Project.class));
        log.info("ID:"+newProject.getId());
        return "redirect:/project/"+newProject.getId()+"/detail";
    }

    @GetMapping("/project/{id}/detail")
    public String outlineFormById(Model model,@PathVariable Long id) {
        //기본 입력페이지를 form으로 등록
        //전달된 정보를 화면에 출력
        model.addAttribute("outlineForm",new OutlineForm());
        Project project = projectService.getProjectById(id);
        model.addAttribute("project",project);
        log.info("[projectAI]projectForm.toString():"+project.getTitle());

        return "project/detail";
    }

    @GetMapping("/project/{id}/detail/{productId}/detailProduct")
    public String outlineFormByIdandProductId(Model model,@PathVariable Long id) {
        //기본 입력페이지를 form으로 등록
        //전달된 정보를 화면에 출력
        model.addAttribute("outlineForm",new OutlineForm());
        Project project = projectService.getProjectById(id);
        model.addAttribute("project",project);
        log.info("[projectAI]projectForm.toString():"+project.getTitle());

        return "project/detailProduct";
    }

    @GetMapping("/project/{id}/detail/{productId}/selectMethod")
    public String selectMethodByIdandProductId(Model model,@PathVariable Long id) {
        //기본 입력페이지를 form으로 등록
        //전달된 정보를 화면에 출력
        model.addAttribute("outlineForm",new OutlineForm());
        Project project = projectService.getProjectById(id);
        model.addAttribute("project",project);
        log.info("[projectAI]projectForm.toString():"+project.getTitle());

        return "project/selectMethod";
    }


    @PostMapping("/project/detail")
    public String outlineSubmit(@Valid OutlineForm outlineForm, Errors errors){
        if(errors.hasErrors()){
            return "project/detail";
        }
        Project newProject = projectService.createNewProject(modelMapper.map(outlineForm,Project.class));
        return "redirect:/project/detail";
    }

    //@GetMapping("/project/{id}/outline")
    @GetMapping("/project/{id}/register")
    public String registerFormById(Model model, @PathVariable Long id){
        //기본 입력페이지를 form으로 등록
        model.addAttribute("registerForm",new RegisterForm());
        Project project = projectService.getProjectById(id);
        model.addAttribute("project",project);

        return "project/register";
    }

    @GetMapping("/project/register")
    public String registerForm(Model model) {
        //기본 입력페이지를 form으로 등록
        model.addAttribute("registerForm",new RegisterForm());
        return "project/register";
    }



    @PostMapping("/project/register")
    public String registerSubmit(@Valid RegisterForm registerForm, Errors errors){
        if(errors.hasErrors()){
            return "project/outline";
        }
        //Project project = projectReposotiry.findById
      //  projectService.updateRegister(project)
                //.createNewProject(modelMapper.map(outlineForm,Project.class));
        return "redirect:/project/outline";

    }

    @GetMapping("/project/contents")
    public String contentsForm(Model model) {
        //기본 입력페이지를 form으로 등록
        model.addAttribute("contentsForm",new ContentsForm());
        return "project/contents";
    }

    @GetMapping("/project/{id}/contents")
    public String contentsFormById(Model model,@PathVariable Long id) {
        //기본 입력페이지를 form으로 등록
        model.addAttribute("contentsForm",new ContentsForm());
        Project project = projectService.getProjectById(id);
        model.addAttribute("project",project);

        return "project/contents";
    }

    @GetMapping("/project/method")
    public String methodForm(Model model) {
        //기본 입력페이지를 form으로 등록
        model.addAttribute("methodForm",new MethodForm());
        return "project/method";
    }

    @GetMapping("/project/{id}/method")
    public String methodFormById(Model model,@PathVariable Long id) {
        //기본 입력페이지를 form으로 등록
        model.addAttribute("methodForm",new MethodForm());
        Project project = projectService.getProjectById(id);
        model.addAttribute("project",project);

        return "project/method";
    }

    @GetMapping("/project/etc")
    public String etcForm(Model model) {
        //기본 입력페이지를 form으로 등록
        model.addAttribute("etcForm",new EtcForm());
        return "project/etc";
    }

    @GetMapping("/project/{id}")
    public String viewProject(@PathVariable Long id, Model model) {
        Project project = projectService.getProjectById(id);
        model.addAttribute(project);
        return "project/view";
    }
}
