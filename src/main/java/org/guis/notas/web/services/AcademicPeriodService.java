package org.guis.notas.web.services;

import java.util.List;
import java.util.Optional;

import org.guis.notas.web.entities.AcademicPeriod;

public interface AcademicPeriodService {

	Optional<AcademicPeriod> findCurrentAcademicPeriod();
	
	List<AcademicPeriod> findAllAcademicPeriods();
	
}
