package org.guis.notas.web.controllers;

import org.guis.notas.web.entities.TeacherWorkload;
import org.guis.notas.web.services.TeacherWorkloadService;
import org.guis.notas.web.utils.PageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/workloads")
public class TeacherWorkloadController {

    @GetMapping("/assigned")
    public ModelAndView assigned() {
        ModelAndView modelAndView = new ModelAndView("/workloads/assigned.html");
        return modelAndView;
    }

    @GetMapping("/assigned/enrollments/{gradeId}/{sectionId}")
    public ModelAndView assigned(@PathVariable int gradeId, @PathVariable int sectionId) {
        ModelAndView modelAndView = new ModelAndView("/workloads/enrrolments.html");
        modelAndView.addObject("gradeId", gradeId);
        modelAndView.addObject("sectionId", sectionId);
        return modelAndView;
    }
}
