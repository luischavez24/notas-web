package org.guis.notas.web.repositories;

import org.guis.notas.web.entities.TeacherWorkload;
import org.guis.notas.web.entities.TeacherWorkloadPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TeacherWorkloadRepository extends PagingAndSortingRepository<TeacherWorkload,TeacherWorkloadPK> {

    Page<TeacherWorkload> findAllByTeacherId(Pageable pageable, int teacherId);
}
