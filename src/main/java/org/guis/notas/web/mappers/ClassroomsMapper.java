package org.guis.notas.web.mappers;

import org.guis.notas.web.entities.Classroom;
import org.guis.notas.web.models.ClassroomModel;
import org.guis.notas.web.models.GradeModel;
import org.springframework.stereotype.Component;

@Component
public class ClassroomsMapper {

    public ClassroomModel toModel(Classroom classroomEntity) {
        ClassroomModel classroomModel = new ClassroomModel();
        classroomModel.setSectionId(classroomEntity.getSectionId());
        classroomModel.setName(classroomEntity.getName());
        GradeModel gradeModel = new GradeModel();
        gradeModel.setGradeId(classroomEntity.getGrade().getGradeId());
        gradeModel.setName(classroomEntity.getGrade().getName());
        classroomModel.setGrade(gradeModel);
        return classroomModel;
    }

}
