package org.guis.notas.web.services.impl;

import org.guis.notas.web.entities.TeacherWorkload;
import org.guis.notas.web.entities.UserCredentials;
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

import java.util.Optional;


@Service("teacherWorkloadService")
public class TeacherWorkloadServiceImpl implements TeacherWorkloadService {

    private final TeacherWorkloadRepository teacherWorkloadRepository;
    private final UserRepository userRepository;

    @Autowired
    public TeacherWorkloadServiceImpl(TeacherWorkloadRepository teacherWorkloadRepository, UserRepository userRepository) {
        this.teacherWorkloadRepository = teacherWorkloadRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PageWrapper<TeacherWorkload> findAllByTeacherUser(int page, int size, String teacherUser) {

        int teacherId = userRepository.findByUsername(teacherUser)
                .orElseThrow(() -> new RuntimeException("El profesor no existe"))
                .getUserId();

        Pageable pageable = PageRequest.of(page, size);

        // Returns the request page
        Page<TeacherWorkload> teacherWorkload = teacherWorkloadRepository.findAllByTeacherId(pageable, teacherId);

        teacherWorkload.map(tw -> {

        });

        return PageWrapper.of(teacherWorkload);
    }
}
