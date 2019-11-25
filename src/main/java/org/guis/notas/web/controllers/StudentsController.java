package org.guis.notas.web.controllers;

import org.guis.notas.web.entities.Parent;
import org.guis.notas.web.services.NoteRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import groovyjarjarpicocli.CommandLine.Model;

@Controller
@RequestMapping("/students")
public class StudentsController {
	@Autowired
	private NoteRecordsService noteRecordService;
	
	@GetMapping("")
	public ModelAndView findStudentsByParent(Authentication authentication) {
		// TODO: Validate if request user is the student's parent
		ModelAndView modelAndView = new ModelAndView("/students/index.html");
		
		Parent parent = noteRecordService.findParentByUser(authentication.getName());
		
		modelAndView.addObject("students", parent.getChildren());
		
		return modelAndView;
	}
	
	@GetMapping("/notes/{studentId}")
	public ModelAndView findNotesByStudentId(Authentication authentication, @PathVariable String studentId) {
		// TODO: Validate if request user is the student's parent
		ModelAndView modelAndView = new ModelAndView("/students/notes.html");
		
		modelAndView.addObject("studentNote", noteRecordService.findAllNoteRecordsByStudent(studentId));
		
		return modelAndView;
	}
}
