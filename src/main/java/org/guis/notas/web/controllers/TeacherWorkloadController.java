package org.guis.notas.web.controllers;

import java.util.Optional;

import org.guis.notas.web.entities.TeacherWorkload;
import org.guis.notas.web.models.TeacherWorkloadModel;
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
    @Autowired
    private TeacherWorkloadService teacherWorkloadService;
    @GetMapping("/assigned")
    public ModelAndView assigned() {
        ModelAndView modelAndView = new ModelAndView("/workloads/assigned.html");
        return modelAndView;
    }

    @GetMapping("/assigned/enrollments/{gradeId}/{sectionId}")
    public ModelAndView assigned(@PathVariable int gradeId, @PathVariable int sectionId) {
        ModelAndView modelAndView = new ModelAndView("/workloads/enrollments.html");
        modelAndView.addObject("gradeId", gradeId);
        modelAndView.addObject("sectionId", sectionId);
        return modelAndView;
    }
    
    @GetMapping("/assigned/upload-notes/{workloadId}")
    public ModelAndView uploadNotes(Authentication authentication, @PathVariable int workloadId) {
        ModelAndView modelAndView = new ModelAndView("/workloads/upload-notes.html");
        
        String teacherUser = authentication.getName();
        TeacherWorkloadModel workload = teacherWorkloadService.findWorkloadlByTeacherUser(teacherUser, workloadId)
        		.orElseThrow(() -> new RuntimeException("La carga académica no existe"));
        
        modelAndView.addObject("workloadId", workloadId);
        modelAndView.addObject("gradeId", workload.getGradeId());
        modelAndView.addObject("sectionId", workload.getSectionId());
        return modelAndView;
    }
}
