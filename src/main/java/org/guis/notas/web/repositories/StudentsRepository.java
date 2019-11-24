package org.guis.notas.web.repositories;

import java.util.Optional;

import org.guis.notas.web.entities.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8081/students", name="students")
public interface StudentsRepository {

	@GetMapping("/{studentDni}")
	Optional<Student> findStudentByDni(@PathVariable String studentDni); 
	
}
