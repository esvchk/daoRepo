package com.academy.course.hierarchy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Person1")
public class Person1 implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
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
