package com.academy.course.spring.autowired;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component("personNew")
public class PersonNew {
    private String name = "name";
    private AddressBeanSecond address;

    @Autowired
    public PersonNew(AddressBeanSecond address) {
        this.address = address;
    }

    public void perform(){
        System.out.println("Hello: " + name);
        System.out.println("City: " + address.getCity());
        System.out.println("Country: " + address.getCountry());
    }
}
