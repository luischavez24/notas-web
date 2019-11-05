package org.guis.notas.web.entities;

import javax.persistence.*;

@Entity
@Table(name="teacher_workload", schema="school")
@IdClass(TeacherWorkloadPK.class)
public class TeacherWorkload {

    @Id
    private int teacherId;

    @Id
    private int workloadId;

    @Id
    private int academicYear;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
