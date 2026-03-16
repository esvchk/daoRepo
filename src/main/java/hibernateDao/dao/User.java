package hibernateDao.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity(name = "people")
public class User implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;
    @Column(name = "age")
    private int age;
    @Column(name = "salary")
    private double salary;
    @Column(name = "passport")
    private String passport;
    @Column(name = "address")
    private String address;
    @Column(name = "dateOfBirthday")
    private LocalDate dateOfBirthday;
    @Column(name = "dateTimeCreate")
    private LocalDateTime dateTimeCreate;
    @Column(name = "timeToLunch")
    private LocalTime timeToLunch;
    @Column(name = "letter")
    private String letter;
}
