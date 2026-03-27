package com.academy.course.hierarchy.school;

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
//@DiscriminatorValue("U")
//@PrimaryKeyJoinColumn(name = "School_id")
@Entity
@Table(name = "University")
public class University extends School implements Serializable {
    @Column
    private String grade;

}
