package org.guis.notas.web.mappers;

import org.guis.notas.web.entities.TeacherWorkload;
import org.guis.notas.web.models.CourseModel;
import org.guis.notas.web.models.TeacherWorkloadModel;
import org.springframework.stereotype.Component;

@Component
public class TeacherWorkloadMapper {

    public TeacherWorkloadModel toModel(TeacherWorkload workloadEntity) {
        TeacherWorkloadModel workloadModel = new TeacherWorkloadModel();
        workloadModel.setTeacherId(workloadEntity.getTeacherId());
        workloadModel.setAcademicYear(workloadEntity.getAcademicYear());
        workloadModel.setWorkloadId(workloadEntity.getWorkloadId());
        CourseModel courseModel = new CourseModel();
        courseModel.setCourseId(workloadEntity.getCourse().getCourseId());
        courseModel.setName(workloadEntity.getCourse().getName());
        workloadModel.setCourse(courseModel);
        return workloadModel;
    }

}
