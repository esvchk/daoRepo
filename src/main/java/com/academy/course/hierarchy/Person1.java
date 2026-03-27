package com.academy.course.hierarchy;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
//@Inheritance(strategy = InheritanceType.JOINED)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "PERSON_TYPE",discriminatorType = DiscriminatorType.CHAR)
//@DiscriminatorValue("P")
@Entity
@Table(name = "Person1")
public class Person1 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String surname;
    @AttributeOverrides({
            @AttributeOverride(name = "street",
                    column = @Column(name = "home_street")),
            @AttributeOverride(name = "city",
                    column = @Column(name = "home_city"))

    })
    @Embedded
    private Address homeAddress;
    @Embedded
    private Address address;

}
