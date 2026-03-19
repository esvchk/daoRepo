package com.academy.course.hierarchy;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
//@PrimaryKeyJoinColumn(name = "person_id")
//@DiscriminatorValue("S")
@Entity
@Table(name = "Student")
public class Student extends Person1 implements Serializable {
    @Column(name = "faculty_univer")
    private String faculty;
    @Column
    private Double mark;

}
