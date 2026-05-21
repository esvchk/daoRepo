package com.academy.course.spring.autowired;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(
        basePackages = "com.academy.course.spring.autowired",
        excludeFilters = {
                @ComponentScan.Filter(
                        value = ComponentScan.class,
                        type = FilterType.ANNOTATION,
                        pattern = {}
                )
        }
)
@EnableAspectJAutoProxy
@Import(ConfigSecond.class)
public class MyConfiguration {
    @Bean(name = "personNew")
    public PersonNew create() {
        return PersonNew.builder()
                .name("PersonNew name")
                .address(AddressBeanSecond.builder()
                        .city("PersonNew city")
                        .country("PersonNew country")
                        .build())
                .build();
    }
}
