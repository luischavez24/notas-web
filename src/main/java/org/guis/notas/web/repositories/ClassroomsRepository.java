package org.guis.notas.web.repositories;

import org.guis.notas.web.entities.Classroom;
import org.guis.notas.web.entities.Enrollment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@FeignClient(url = "http://localhost:8081/classrooms", name="classrooms")
public interface ClassroomsRepository {
    @GetMapping("")
    List<Classroom> findAll();

    @GetMapping("/{gradeId}/{sectionId}/enrollements/{academicYear}")
    Page<Enrollment> findAllEnrollments(@PathVariable int gradeId, @PathVariable int sectionId, @PathVariable int academicYear,
                                        @RequestParam Optional<Integer> page, Optional<Integer> size);
}
