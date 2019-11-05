package org.guis.notas.web.controllers;

import org.guis.notas.web.entities.TeacherWorkload;
import org.guis.notas.web.services.TeacherWorkloadService;
import org.guis.notas.web.utils.PageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/workloads")
public class TeacherWorkloadController {

    @GetMapping("/assigned")
    public ModelAndView assigned() {
        ModelAndView modelAndView = new ModelAndView("/workloads/assigned.html");
        return modelAndView;
    }
}
