package org.guis.notas.web.repositories;

import java.util.List;

import org.guis.notas.web.entities.NoteRecordDetail;
import org.guis.notas.web.entities.NoteRecordDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRecordDetailsRepository extends JpaRepository<NoteRecordDetail, NoteRecordDetailPK>{
	
	List<NoteRecordDetail> findAllByStudentId(String studentId);
	
}
