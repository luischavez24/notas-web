package org.guis.notas.web.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "note_record_detail", schema = "school")
@IdClass(NoteRecordDetailPK.class)
public class NoteRecordDetail {
	
	@Id
	private int teacherId;
	
	@Id
	private int workloadId;
	
	@Id
	private int academicYear;
	
	@Id
	private int academicPeriod;

	@Id
	private String studentId;
	
	@Column(name = "homework_note")
	private int homeworkNote;
	
	@Column(name="participation_note")
	private int participationNote;
	
	@Column(name="partial_note")
	private int partialNote;
	
	@Column(name="final_note")
	private int finalNote;

    @ManyToOne
    @JoinColumns({
    	@JoinColumn(name ="teacher_id"),
    	@JoinColumn(name ="workload_id"),
    	@JoinColumn(name ="academic_year"),
    	@JoinColumn(name ="academic_period")
    })
	private NoteRecord noteRecord;
	
	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getWorkloadId() {
		return workloadId;
	}

	public void setWorkloadId(int workloadId) {
		this.workloadId = workloadId;
	}

	public int getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(int academicYear) {
		this.academicYear = academicYear;
	}

	public int getAcademicPeriod() {
		return academicPeriod;
	}

	public void setAcademicPeriod(int academicPeriod) {
		this.academicPeriod = academicPeriod;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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
	
	public double getAvgNote() {
		return (homeworkNote + participationNote + partialNote + finalNote) / 4.0;
	}
}
