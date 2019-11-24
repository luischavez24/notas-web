package org.guis.notas.web.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.guis.notas.web.entities.Enrollment;
import org.guis.notas.web.entities.TeacherWorkload;
import org.guis.notas.web.models.TeacherWorkloadModel;
import org.guis.notas.web.models.UploadNotesModel;
import org.guis.notas.web.services.TeacherWorkloadService;
import org.guis.notas.web.utils.PageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.JsonSerializer;

import java.time.ZonedDateTime;

@RestController
@RequestMapping("/api/workloads")
public class TeacherWorkloadRestController {

	private static final Log LOG = LogFactory.getLog(TeacherWorkloadRestController.class);
	
    @Autowired
    private TeacherWorkloadService teacherWorkloadService;

    @GetMapping("")
    public PageWrapper<TeacherWorkloadModel> findAllByTeacher(Authentication authentication, @RequestParam int start, @RequestParam int length, @RequestParam int draw) {

        String teacherUser = authentication.getName();

        int page = start / length;

        PageWrapper<TeacherWorkloadModel> workloadWrapper =  teacherWorkloadService.findAllByTeacherUser(page, length, teacherUser);

        workloadWrapper.setDraw(draw);

        return workloadWrapper;
    }

    @GetMapping("/{gradeId}/{sectionId}/enrollments")
    public PageWrapper<Enrollment> findAllEnrolments(@PathVariable int gradeId, @PathVariable int sectionId,
                                                     @RequestParam int start, @RequestParam int length, @RequestParam int draw) {

        int page = start / length;

        PageWrapper<Enrollment> enrollmentPageWrapper =  teacherWorkloadService.findEnrollemntByWorkload(gradeId, sectionId,
                ZonedDateTime.now().getYear(), page, length);

        enrollmentPageWrapper.setDraw(draw);

        return enrollmentPageWrapper;
    }
    
    @PostMapping("/upload-notes")
    public void uploadNote(@RequestBody UploadNotesModel uploadNotesModel) {
    	LOG.info(uploadNotesModel);
    }
}
