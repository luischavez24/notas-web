package org.guis.notas.web.services;

import org.guis.notas.web.models.StudentNote;
import org.guis.notas.web.models.UploadNotesModel;

public interface NoteRecordsService {

	void uploadNotes(UploadNotesModel uploadNotesModel, String teacherUser);
	
	boolean existsNoteRecord(String teacherUser, int workloadId);

	StudentNote findAllNoteRecordsByStudent(String studentId);
	
}
