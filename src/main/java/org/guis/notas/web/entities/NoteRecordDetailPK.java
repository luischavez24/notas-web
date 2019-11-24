package org.guis.notas.web.entities;

import java.io.Serializable;

import javax.persistence.Column;

public class NoteRecordDetailPK implements Serializable {
	
	@Column(name = "teacher_id", insertable = false, updatable = false)
	private int teacherId;
	
	@Column(name = "workload_id", insertable = false, updatable = false)
	private int workloadId;
	
	@Column(name = "academic_year", insertable = false, updatable = false)
	private int academicYear;
	
	@Column(name = "academic_period", insertable = false, updatable = false)
	private int academicPeriod;
	
	@Column(name = "student_id", insertable = false, updatable = false)
	private String studentId;


	public NoteRecordDetailPK() {
		super();
	}

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
	
	
}
