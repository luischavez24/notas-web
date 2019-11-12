package org.guis.notas.web.models;

public class ClassroomModel {

    private int sectionId;

    private String name;

    private GradeModel grade;

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GradeModel getGrade() {
        return grade;
    }

    public void setGrade(GradeModel grade) {
        this.grade = grade;
    }
}
