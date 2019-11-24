package org.guis.notas.web.services;

import org.guis.notas.web.models.UploadNotesModel;

public interface NoteRecordsService {

	public void uploadNotes(UploadNotesModel uploadNotesModel, String teacherUser);
}
