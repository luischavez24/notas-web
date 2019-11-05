package org.guis.notas.web.entities;

import javax.persistence.*;

@Entity
@Table(name="teacher", schema = "school")
public class Teacher {

    @Id
    @Column(name="teacher_id")
    private int teacherId;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Person person;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
