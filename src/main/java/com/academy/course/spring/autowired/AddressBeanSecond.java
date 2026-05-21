package com.academy.course.spring.autowired;


import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component("addressBean")
public class AddressBeanSecond {
    @Value("City")
    private String city;
    @Value("Country")
    private String country;
}
