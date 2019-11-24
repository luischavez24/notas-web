package org.guis.notas.web.repositories;

import org.guis.notas.web.entities.NoteRecord;
import org.guis.notas.web.entities.NoteRecordPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRecordsRepository extends JpaRepository<NoteRecord, NoteRecordPK>{
	
}
