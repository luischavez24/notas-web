package org.guis.notas.web.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="academic_period", schema = "school")
@IdClass(AcademicPeriodPK.class)
public class AcademicPeriod {
	
	@Id
	private int academicYear;
	
	@Id
	private int academicPeriod;
	
	@Column(name="starts_on")
	private LocalDate startsOn;
	
	@Column(name="ends_on")
	private LocalDate endsOn;
	
	@Column(name="active")
	private boolean active;

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

	public LocalDate getStartsOn() {
		return startsOn;
	}

	public void setStartsOn(LocalDate startsOn) {
		this.startsOn = startsOn;
	}

	public LocalDate getEndsOn() {
		return endsOn;
	}

	public void setEndsOn(LocalDate endsOn) {
		this.endsOn = endsOn;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
}
