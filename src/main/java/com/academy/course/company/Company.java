package com.academy.course.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Company")
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    @Column
    private String name;

    @AttributeOverrides({
            @AttributeOverride(name = "language",
            column = @Column(name = "work_language")),
            @AttributeOverride(name = "nativePlaceLanguage",
            column = @Column(name = "work_native_placeLanguage"))
    })
    @Embedded
    private Language workLanguage;

    @Embedded
    private Language Language;


}
