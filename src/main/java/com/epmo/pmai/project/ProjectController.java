package com.epmo.pmai.project;


import com.epmo.pmai.project.form.*;
import com.epmo.pmai.project.form.OutlineForm;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
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

    }
    @GetMapping("/project/register")
    public String registerForm(Model model) {
        //기본 입력페이지를 form으로 등록
        model.addAttribute("registerForm",new RegisterForm());
        return "project/register";
    }


    @GetMapping("/project/contents")
    public String contentsForm(Model model) {
        //기본 입력페이지를 form으로 등록
        model.addAttribute("contentsForm",new ContentsForm());
        return "project/contents";
    }

    @GetMapping("/project/method")
    public String methodForm(Model model) {
        //기본 입력페이지를 form으로 등록
        model.addAttribute("methodForm",new MethodForm());
        return "project/method";
    }
    @GetMapping("/project/etc")
    public String etcForm(Model model) {
        //기본 입력페이지를 form으로 등록
        model.addAttribute("etcForm",new EtcForm());
        return "project/etc";
    }




}
