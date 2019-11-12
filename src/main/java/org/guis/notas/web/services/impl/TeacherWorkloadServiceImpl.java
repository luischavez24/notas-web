package org.guis.notas.web.services.impl;

import org.guis.notas.web.entities.Classroom;
import org.guis.notas.web.entities.Enrollment;
import org.guis.notas.web.entities.TeacherWorkload;
import org.guis.notas.web.entities.UserCredentials;
import org.guis.notas.web.mappers.ClassroomsMapper;
import org.guis.notas.web.mappers.TeacherWorkloadMapper;
import org.guis.notas.web.models.ClassroomModel;
import org.guis.notas.web.models.TeacherWorkloadModel;
import org.guis.notas.web.repositories.ClassroomsRepository;
import org.guis.notas.web.repositories.PeopleRepository;
import org.guis.notas.web.repositories.TeacherWorkloadRepository;
import org.guis.notas.web.repositories.UserRepository;
import org.guis.notas.web.services.TeacherWorkloadService;
import org.guis.notas.web.utils.PageWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service("teacherWorkloadService")
public class TeacherWorkloadServiceImpl implements TeacherWorkloadService {

    @Autowired
    private TeacherWorkloadRepository teacherWorkloadRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeacherWorkloadMapper teacherWorkloadMapper;

    @Autowired
    private ClassroomsRepository classroomsRepository;

    @Autowired
    private ClassroomsMapper classroomsMapper;

    @Override
    public PageWrapper<TeacherWorkloadModel> findAllByTeacherUser(int page, int size, String teacherUser) {

        int teacherId = userRepository.findByUsername(teacherUser)
                .orElseThrow(() -> new RuntimeException("El profesor no existe"))
                .getUserId();

        Pageable pageable = PageRequest.of(page, size);
        List<Classroom> classrooms = classroomsRepository.findAll();

        // Returns the request page
        Page<TeacherWorkloadModel> teacherWorkload = teacherWorkloadRepository.findAllByTeacherId(pageable, teacherId)
                .map(twEntity -> {
                    Optional<ClassroomModel> classroom = classrooms.stream()
                            .filter(c -> isSameClassroom(c, twEntity))
                            .findFirst()
                            .map(classroomsMapper::toModel);
                    TeacherWorkloadModel workloadModel = teacherWorkloadMapper.toModel(twEntity);
                    workloadModel.setClassroom(classroom);
                    return workloadModel;
                });

        return PageWrapper.of(teacherWorkload);
    }

    @Override
    public PageWrapper<Enrollment> findEnrollemntByWorkload(int gradeId, int sectionId, int academicYear, int page, int size) {

        Page<Enrollment> enrollmentPage = classroomsRepository.findAllEnrollments(gradeId, sectionId, academicYear,
                Optional.of(page), Optional.of(size));

        return PageWrapper.of(enrollmentPage);
    }


    private boolean isSameClassroom(Classroom classroom, TeacherWorkload workloadModel) {
        return classroom.getSectionId() == workloadModel.getSectionId() &&
                classroom.getGrade().getGradeId() == workloadModel.getGradeId();
    }
}
