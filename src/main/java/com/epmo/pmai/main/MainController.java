package com.epmo.pmai.main;

import com.epmo.pmai.project.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
//시작화면 dashboard
public class MainController {
    private final ProjectRepository projectRepository;

    @GetMapping("/")
    public String home(Model model){

        return "form";
    }
}
