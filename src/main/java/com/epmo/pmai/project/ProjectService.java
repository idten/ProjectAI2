package com.epmo.pmai.project;

import com.epmo.pmai.project.form.ContentsForm;
import com.epmo.pmai.project.form.MethodForm;
import com.epmo.pmai.project.form.RegisterForm;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository repository;
    private final ModelMapper modelMapper;


    public Project createNewProject(Project project) {
        Project newProject = repository.save(project);
        //newStudy.addManager(account);
        return newProject;
    }

    public void updateRegister(Project project, RegisterForm registerForm) {
        //이름이 일치할 경우에 매핑
        modelMapper.map(registerForm, project);
        repository.save(project);
    }

    public void updateMethod(Project project, MethodForm methodForm) {
        modelMapper.map(methodForm, project);
        repository.save(project);
    }

    public void updateContents(Project project, ContentsForm contentsForm) {
        modelMapper.map(contentsForm, project);
        repository.save(project);
    }

}