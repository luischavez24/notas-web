package org.guis.notas.web.services;

import org.guis.notas.web.entities.Enrollment;
import org.guis.notas.web.entities.TeacherWorkload;
import org.guis.notas.web.models.TeacherWorkloadModel;
import org.guis.notas.web.utils.PageWrapper;

import java.util.Optional;

public interface TeacherWorkloadService {

    PageWrapper<TeacherWorkloadModel> findAllByTeacherUser(int page, int size, String teacherUser);
    
    Optional<TeacherWorkloadModel> findWorkloadlByTeacherUser(String teacherUser, int workloadId);

    PageWrapper<Enrollment> findEnrollemntByWorkload(int gradeId, int sectionId, int academicYear,int page, int size);
}
