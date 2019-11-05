package org.guis.notas.web.entities;

import javax.persistence.*;

@Entity
@Table(name="course", schema = "school")
public class Course {

    @Id
    @Column(name="course_id")
    private int courseId;

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "coordinator_id")
    private Teacher coordinator;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Teacher coordinator) {
        this.coordinator = coordinator;
    }
}
