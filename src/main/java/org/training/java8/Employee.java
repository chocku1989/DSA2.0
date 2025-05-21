package org.training.java8;


import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Employee {

    private String employeeName;
    private String teamName;
    private LocalDate dateOfJoining;

}
