package org.guis.notas.web.models;

public class StudentInputModel {

	private String dni;
	
	private int homeworkNote;
	
	private int participationNote;
	
	private int partialNote;
	
	private int finalNote;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getHomeworkNote() {
		return homeworkNote;
	}

	public void setHomeworkNote(int homeworkNote) {
		this.homeworkNote = homeworkNote;
	}

	public int getParticipationNote() {
		return participationNote;
	}

	public void setParticipationNote(int participationNote) {
		this.participationNote = participationNote;
	}

	public int getPartialNote() {
		return partialNote;
	}

	public void setPartialNote(int partialNote) {
		this.partialNote = partialNote;
	}

	public int getFinalNote() {
		return finalNote;
	}

	public void setFinalNote(int finalNote) {
		this.finalNote = finalNote;
	}

	@Override
	public String toString() {
		return "StudentInputModel [dni=" + dni + ", homeworkNote=" + homeworkNote + ", participationNote="
				+ participationNote + ", partialNote=" + partialNote + ", finalNote=" + finalNote + "]";
	}
	
	
}
