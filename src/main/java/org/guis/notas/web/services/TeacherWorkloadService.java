package org.guis.notas.web.services;

import org.guis.notas.web.entities.TeacherWorkload;
import org.guis.notas.web.utils.PageWrapper;

public interface TeacherWorkloadService {

    PageWrapper<TeacherWorkload> findAllByTeacherUser(int page, int size, String teacherUser);

}
