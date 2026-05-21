package com.academy.course.spring.aop;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransferData {
    private String from;
    private String to;
    private int code;


}
