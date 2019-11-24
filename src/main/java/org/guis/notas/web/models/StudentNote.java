package org.guis.notas.web.models;

import java.util.List;

import org.guis.notas.web.entities.Student;

public class StudentNote {
	
	private Student student;
	
	private List<NotesPerAcademicPeriod> periods;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<NotesPerAcademicPeriod> getPeriods() {
		return periods;
	}

	public void setPeriods(List<NotesPerAcademicPeriod> periods) {
		this.periods = periods;
	}
	
}
