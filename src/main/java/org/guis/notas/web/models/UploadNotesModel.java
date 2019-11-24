package org.guis.notas.web.models;

import java.util.List;

public class UploadNotesModel {
	
	private int workloadId;
	
	private List<StudentInputModel> studentNotes;

	public int getWorkloadId() {
		return workloadId;
	}

	public void setWorkloadId(int workloadId) {
		this.workloadId = workloadId;
	}

	public List<StudentInputModel> getStudentNotes() {
		return studentNotes;
	}

	public void setStudentNotes(List<StudentInputModel> studentNotes) {
		this.studentNotes = studentNotes;
	}

	@Override
	public String toString() {
		return "UploadNotesModel [workloadId=" + workloadId + ", studentNotes=" + studentNotes + "]";
	}
	
	
}
