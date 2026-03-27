package com.academy.course.by.city.study.cascade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "employees")
@Entity
@Table
public class Department extends DataEntity implements Serializable{
    @Column(name = "department_name")
    private String departmentName;
    @OneToMany(mappedBy = "department")
    private Set<Employee> employees = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Department that = (Department) o;
        return Objects.equals(getId(),that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
