package org.guis.notas.web.controllers;

import org.guis.notas.web.models.StudentNote;
import org.guis.notas.web.services.NoteRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentsRestController {
	
	@Autowired
	private NoteRecordsService noteRecordService;
	
	@GetMapping("/notes/{studentId}")
	public ResponseEntity<?> findNotesByStudentId(Authentication authentication, String studentId) {
		// Validate if request user is the student's parent
		return ResponseEntity.ok(noteRecordService.findAllNoteRecordsByStudent(studentId));
	}
	
}
