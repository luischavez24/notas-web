package org.guis.notas.web.entities;

import java.io.Serializable;

import javax.persistence.Column;

public class AcademicPeriodPK implements Serializable{
	
	@Column(name="academic_year", insertable = false, updatable = false)
	private int academicYear;
	
	@Column(name="academic_period", insertable = false, updatable = false)
	private int academicPeriod;

	public AcademicPeriodPK() {
		// TODO Auto-generated constructor stub
	}
}
