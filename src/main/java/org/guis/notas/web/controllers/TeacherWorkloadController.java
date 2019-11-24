package org.guis.notas.web.controllers;

import java.util.Optional;

import org.guis.notas.web.entities.TeacherWorkload;
import org.guis.notas.web.models.TeacherWorkloadModel;
import org.guis.notas.web.services.NoteRecordsService;
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
    
    @Autowired
    private NoteRecordsService noteRecordsService;
    
    @GetMapping("/assigned")
    public ModelAndView assigned(@RequestParam Optional<Boolean> recordAlreadyExists) {
        ModelAndView modelAndView = new ModelAndView("/workloads/assigned.html");
        modelAndView.addObject("recordAlreadyExists", recordAlreadyExists.orElse(false));
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
        ModelAndView modelAndView = new ModelAndView();
        
        String teacherUser = authentication.getName();
        
        TeacherWorkloadModel workload = teacherWorkloadService.findWorkloadlByTeacherUser(teacherUser, workloadId)
        		.orElseThrow(() -> new RuntimeException("La carga académica no existe"));
        
        if(noteRecordsService.existsNoteRecord(teacherUser, workloadId)) {
        	modelAndView.setViewName("redirect:/workloads/assigned");
        	modelAndView.addObject("recordAlreadyExists", true);
        } else {
        	modelAndView.setViewName("/workloads/upload-notes.html");
            modelAndView.addObject("workloadId", workloadId);
            modelAndView.addObject("gradeId", workload.getGradeId());
            modelAndView.addObject("sectionId", workload.getSectionId());
        }
       
        
        return modelAndView;
    }
}
