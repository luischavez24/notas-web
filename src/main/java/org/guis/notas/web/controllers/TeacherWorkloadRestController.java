package org.guis.notas.web.controllers;

import org.guis.notas.web.entities.TeacherWorkload;
import org.guis.notas.web.services.TeacherWorkloadService;
import org.guis.notas.web.utils.PageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workloads")
public class TeacherWorkloadRestController {

    @Autowired
    private TeacherWorkloadService teacherWorkloadService;

    @GetMapping("")
    public PageWrapper<TeacherWorkload> findAllByTeacher(Authentication authentication, @RequestParam int start, @RequestParam int length, @RequestParam int draw) {
        String teacherUser = authentication.getName();

        int page = start / length;

        PageWrapper<TeacherWorkload> workloadWrapper =  teacherWorkloadService.findAllByTeacherUser(page, length, teacherUser);

        workloadWrapper.setDraw(draw);

        return workloadWrapper;
    }
}
