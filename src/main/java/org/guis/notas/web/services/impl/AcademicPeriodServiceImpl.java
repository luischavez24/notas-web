package org.guis.notas.web.services.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.guis.notas.web.entities.AcademicPeriod;
import org.guis.notas.web.repositories.AcademicPeriodRepository;
import org.guis.notas.web.services.AcademicPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("academicPeriodService")
public class AcademicPeriodServiceImpl implements AcademicPeriodService {

	@Autowired
	private AcademicPeriodRepository academicPeriodRepository;
	
	@Override
	public Optional<AcademicPeriod> findCurrentAcademicPeriod() {
		return academicPeriodRepository.findByStartsOnLessThanEqualAndEndsOnGreaterThanEqual(LocalDate.now(), LocalDate.now());
	}

}
