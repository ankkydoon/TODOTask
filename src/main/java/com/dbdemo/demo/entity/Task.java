package com.dbdemo.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonManagedReference
    @OneToMany(mappedBy="task",cascade = CascadeType.ALL)
    private List<Notes> notes;

    public void setNotes(List<Notes> notes) {
        this.notes = notes;
        notes.forEach(notes1 -> notes1.setTask(this));
    }

    String description;




}
