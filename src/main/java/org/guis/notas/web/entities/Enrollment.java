package org.guis.notas.web.entities;

import java.time.ZonedDateTime;

public class Enrollment {
    private int studentId;

    private String dni;

    private ZonedDateTime enrollmentOn;

    private Classroom classroom;

    private Student student;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public ZonedDateTime getEnrollmentOn() {
        return enrollmentOn;
    }

    public void setEnrollmentOn(ZonedDateTime enrollmentOn) {
        this.enrollmentOn = enrollmentOn;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
