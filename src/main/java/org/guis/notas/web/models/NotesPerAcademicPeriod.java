package org.guis.notas.web.models;

import java.util.List;

import org.guis.notas.web.entities.AcademicPeriod;
import org.guis.notas.web.entities.NoteRecordDetail;

public class NotesPerAcademicPeriod {

	private AcademicPeriod academicPeriod;
	
	private List<NoteRecordDetail> notes;

	public AcademicPeriod getAcademicPeriod() {
		return academicPeriod;
	}

	public void setAcademicPeriod(AcademicPeriod academicPeriod) {
		this.academicPeriod = academicPeriod;
	}

	public List<NoteRecordDetail> getNotes() {
		return notes;
	}

	public void setNotes(List<NoteRecordDetail> notes) {
		this.notes = notes;
	}
	
	public double getAvgNote() {
		return notes.stream().mapToDouble(NoteRecordDetail::getAvgNote).average().orElse(0.0);
	}
}
