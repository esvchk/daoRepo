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
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "EDUCATION_TYPE",discriminatorType = DiscriminatorType.CHAR)
//@DiscriminatorValue("S")
@Entity
@Table(name = "School")
public class School implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private String type;

}
