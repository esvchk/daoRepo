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
//@DiscriminatorValue("E")
@Entity
@Table(name = "Employee1")

public class Employee1 extends Person1 implements Serializable {
    @Column
    private String company;
    @Column
    private Double salary;
}
