package org.guis.notas.web.entities;

import java.io.Serializable;

import javax.persistence.Column;

public class NoteRecordPK implements Serializable{
	
	@Column(name = "teacher_id", insertable = false, updatable = false)
	private int teacherId;
	
	@Column(name = "workload_id", insertable = false, updatable = false)
	private int workloadId;
	
	@Column(name = "academic_year", insertable = false, updatable = false)
	private int academicYear;
	
	@Column(name = "academic_period", insertable = false, updatable = false)
	private int academicPeriod;

	public NoteRecordPK() {
		super();
	}
}
