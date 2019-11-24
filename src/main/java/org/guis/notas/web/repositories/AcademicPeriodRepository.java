package org.guis.notas.web.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.guis.notas.web.entities.AcademicPeriod;
import org.guis.notas.web.entities.AcademicPeriodPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicPeriodRepository extends JpaRepository<AcademicPeriod, AcademicPeriodPK>{

	Optional<AcademicPeriod> findByStartsOnLessThanEqualAndEndsOnGreaterThanEqual(LocalDate startOnCompare, LocalDate endsOnCompare);
}
