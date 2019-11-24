package org.guis.notas.web.services.impl;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.guis.notas.web.entities.AcademicPeriod;
import org.guis.notas.web.entities.NoteRecord;
import org.guis.notas.web.entities.NoteRecordDetail;
import org.guis.notas.web.entities.NoteRecordPK;
import org.guis.notas.web.entities.Student;
import org.guis.notas.web.entities.Teacher;
import org.guis.notas.web.models.NotesPerAcademicPeriod;
import org.guis.notas.web.models.StudentInputModel;
import org.guis.notas.web.models.StudentNote;
import org.guis.notas.web.models.UploadNotesModel;
import org.guis.notas.web.repositories.AcademicPeriodRepository;
import org.guis.notas.web.repositories.NoteRecordDetailsRepository;
import org.guis.notas.web.repositories.NoteRecordsRepository;
import org.guis.notas.web.repositories.StudentsRepository;
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
	private NoteRecordDetailsRepository noteRecordDetailsRepository;
	
	@Autowired
	private NoteRecordsRepository noteRecordRepository;
	
	@Autowired
	private AcademicPeriodService academicPeriodService;
	
	@Autowired
	private StudentsRepository studentsRepository;
	
	@Override
	@Transactional
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
		Teacher uploadedBy = new Teacher();
		uploadedBy.setTeacherId(teacherId);
		noteRecord.setUploadedBy(uploadedBy);
		
		noteRecordRepository.save(noteRecord);
		
		for(StudentInputModel studentNotes : uploadNotesModel.getStudentNotes()) {
			NoteRecordDetail noteRecordDetail = new NoteRecordDetail();
			
			noteRecordDetail.setStudentId(studentNotes.getDni());
			noteRecordDetail.setWorkloadId(noteRecord.getWorkloadId());
			noteRecordDetail.setTeacherId(noteRecord.getTeacherId());
			noteRecordDetail.setAcademicYear(noteRecord.getAcademicYear());
			noteRecordDetail.setAcademicPeriod(noteRecord.getAcademicPeriod());
			noteRecordDetail.setHomeworkNote(studentNotes.getHomeworkNote());
			noteRecordDetail.setParticipationNote(studentNotes.getParticipationNote());
			noteRecordDetail.setPartialNote(studentNotes.getPartialNote());
			noteRecordDetail.setFinalNote(studentNotes.getFinalNote());
			
			noteRecordDetailsRepository.save(noteRecordDetail);
		}
	}

	@Override
	public boolean existsNoteRecord(String teacherUser, int workloadId) {
		
		int teacherId = userRepository.findByUsername(teacherUser)
                .orElseThrow(() -> new RuntimeException("El profesor no existe"))
                .getUserId();
	
		AcademicPeriod academicPeriod = academicPeriodService.findCurrentAcademicPeriod()
			.orElseThrow(() -> new RuntimeException("No existe un periodo académico en curso"));
		
		NoteRecordPK pk = new NoteRecordPK();
		
		pk.setTeacherId(teacherId);
		pk.setWorkloadId(workloadId);
		pk.setAcademicYear(academicPeriod.getAcademicYear());
		pk.setAcademicPeriod(academicPeriod.getAcademicPeriod());
		
		return noteRecordRepository.existsById(pk);
	}

	@Override
	public StudentNote findAllNoteRecordsByStudent(String studentId) {
		
		Student student = studentsRepository.findStudentByDni(studentId)
				.orElseThrow(() -> new RuntimeException("El alumno no existe"));
		
		StudentNote studentNote = new StudentNote();
		
		studentNote.setStudent(student);
		
		List<NotesPerAcademicPeriod> notesPerAcademicPeriod = new ArrayList<>();
		
		List<NoteRecordDetail> notes = noteRecordDetailsRepository.findByStudentId(studentId);
		
		for(AcademicPeriod academicPeriod : academicPeriodService.findAllAcademicPeriods()) {
			
			NotesPerAcademicPeriod notePerPeriod = new NotesPerAcademicPeriod();
			
			notePerPeriod.setAcademicPeriod(academicPeriod);

			List<NoteRecordDetail> notesRecords = notes.stream()
				.filter(noteReg -> sameAcademicPeriod(academicPeriod, noteReg))
				.collect(Collectors.toList());
			
			notePerPeriod.setNotes(notesRecords);
			
			notesPerAcademicPeriod.add(notePerPeriod);
		}
		
		studentNote.setPeriods(notesPerAcademicPeriod);
		
		return studentNote;
	}

	private boolean sameAcademicPeriod(AcademicPeriod academicPeriod, NoteRecordDetail noteReg) {
		return noteReg.getAcademicYear() == academicPeriod.getAcademicYear() 
				&& noteReg.getAcademicPeriod() == academicPeriod.getAcademicPeriod();
	}
}
