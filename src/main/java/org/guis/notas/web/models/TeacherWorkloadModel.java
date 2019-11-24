package org.guis.notas.web.models;

import java.util.Optional;

public class TeacherWorkloadModel {

    private int teacherId;

    private int workloadId;

    private int gradeId;
    
    private int sectionId;
    
    private int academicYear;

    private CourseModel course;

    private Optional<ClassroomModel> classroom;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getWorkloadId() {
        return workloadId;
    }

    public void setWorkloadId(int workloadId) {
        this.workloadId = workloadId;
    }

    public int getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
    }

    public CourseModel getCourse() {
        return course;
    }

    public void setCourse(CourseModel course) {
        this.course = course;
    }

    public Optional<ClassroomModel> getClassroom() {
        return classroom;
    }

    public void setClassroom(Optional<ClassroomModel> classroom) {
        this.classroom = classroom;
    }

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}
    
    
}
