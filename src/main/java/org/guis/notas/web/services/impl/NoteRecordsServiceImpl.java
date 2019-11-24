package org.guis.notas.web.services.impl;

import java.time.ZonedDateTime;

import org.guis.notas.web.entities.AcademicPeriod;
import org.guis.notas.web.entities.NoteRecord;
import org.guis.notas.web.models.UploadNotesModel;
import org.guis.notas.web.repositories.AcademicPeriodRepository;
import org.guis.notas.web.repositories.NoteRecordDetailsRepository;
import org.guis.notas.web.repositories.NoteRecordsRepository;
import org.guis.notas.web.repositories.UserRepository;
import org.guis.notas.web.services.AcademicPeriodService;
import org.guis.notas.web.services.NoteRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("noteRecordsService")
public class NoteRecordsServiceImpl implements NoteRecordsService {

	@Autowired
	private NoteRecordsRepository noteRecordsRepository;
	
    @Autowired
    private UserRepository userRepository;
	
	@Autowired
	private NoteRecordDetailsRepository noteRecordsDetailsRepository;
	
	@Autowired
	private AcademicPeriodService academicPeriodService;
	
	@Override
	public void uploadNotes(UploadNotesModel uploadNotesModel, String teacherUser) {
		
		int teacherId = userRepository.findByUsername(teacherUser)
	                .orElseThrow(() -> new RuntimeException("El profesor no existe"))
	                .getUserId();
		
		AcademicPeriod academicPeriod = academicPeriodService.findCurrentAcademicPeriod()
				.orElseThrow(() -> new RuntimeException("No existe un periodo académico en curso"));
		
		NoteRecord noteRecord = new NoteRecord();
		
		noteRecord.setWorkloadId(uploadNotesModel.getWorkloadId());
		noteRecord.setTeacherId(teacherId);
		noteRecord.setAcademicYear(academicPeriod.getAcademicYear());
		noteRecord.setAcademicPeriod(academicPeriod.getAcademicPeriod());
		noteRecord.setUploadedOn(ZonedDateTime.now());
		
	}

	
}
