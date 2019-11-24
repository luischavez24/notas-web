package org.guis.notas.web.entities;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "note_record", schema = "school")
@IdClass(NoteRecordPK.class)
public class NoteRecord {
	@Id
	private int teacherId;
	
	@Id
	private int workloadId;
	
	@Id
	private int academicYear;
	
	@Id
	private int academicPeriod;
	
    @ManyToOne
    @JoinColumn(name = "uploaded_by", insertable = false, updatable = false)
    private Teacher uploadedBy;
    
    @Column(name="uploaded_on")
    private ZonedDateTime uploadedOn;

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

	public Teacher getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(Teacher uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public ZonedDateTime getUploadedOn() {
		return uploadedOn;
	}

	public void setUploadedOn(ZonedDateTime uploadedOn) {
		this.uploadedOn = uploadedOn;
	}
}
