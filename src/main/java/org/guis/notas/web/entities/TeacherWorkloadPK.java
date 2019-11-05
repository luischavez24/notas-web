package org.guis.notas.web.entities;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class TeacherWorkloadPK implements Serializable {

    @Column(name = "teacher_id", insertable = false, updatable = false)
    private int teacherId;

    @Column(name = "workload_id", insertable = false, updatable = false)
    private int workloadId;

    @Column(name = "academic_year", insertable = false, updatable = false)
    private int academicYear;

    public TeacherWorkloadPK() {

    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeacherWorkloadPK)) return false;
        TeacherWorkloadPK that = (TeacherWorkloadPK) o;
        return getTeacherId() == that.getTeacherId() &&
                getWorkloadId() == that.getWorkloadId() &&
                getAcademicYear() == that.getAcademicYear();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTeacherId(), getWorkloadId(), getAcademicYear());
    }
}
