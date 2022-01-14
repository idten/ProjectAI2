package com.epmo.pmai.project;


import com.epmo.pmai.project.form.OutlineForm;
import com.epmo.pmai.project.form.OutlineForm;

import com.epmo.pmai.project.form.ProjectForm;
import com.epmo.pmai.project.form.RegisterForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectRepository projectRepository;
    private final ProjectService projectService;
    private final ModelMapper modelMapper;

    @GetMapping("/project/outline")
    public String outlineForm(Model model) {
        //기본 입력페이지를 form으로 등록
        model.addAttribute("outlineForm",new OutlineForm());
        return "project/outline";
    }

    @PostMapping("/project/outline")
    public String outlineSubmit(@Valid OutlineForm outlineForm, Errors errors){
        if(errors.hasErrors()){
            return "project/outline";
        }
        Project newProject = projectService.createNewProject(modelMapper.map(outlineForm,Project.class));
        return "redirect:/project/outline";
        tst
    }
    @GetMapping("/project/register")
    public String registerForm(Model model) {
        //기본 입력페이지를 form으로 등록
        model.addAttribute("registerForm",new RegisterForm());
        return "project/register";
    }


}
