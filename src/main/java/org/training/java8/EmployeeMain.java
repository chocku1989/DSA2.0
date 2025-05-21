package org.training.java8;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeMain {


    public static void main(String[] args){
        // Assuming Employee class has three attributes - employeeName, TeamName and Date of Joining
        Employee emp1 = new Employee("Bhargav", "IT-DEV", LocalDate.of(2012, 9, 13));
        Employee emp2 = new Employee("Rahul", "IT-PROD", LocalDate.of(2018, 7, 4));
        Employee emp3 = new Employee("Sagar", "IT-DEV", LocalDate.of(2020, 2, 10));
        Employee emp4 = new Employee("Vaibhav", "IT-MIDDLEWARE", LocalDate.of(2022, 7, 6));
        Employee emp5 = new Employee("Ritu", "IT-MIDDLEWARE", LocalDate.of(2022, 11, 15));
        Employee emp6 = new Employee("Anand", "IT-PROD", LocalDate.of(2025, 1, 30));
        Employee emp7 = new Employee("Ritu", "IT-PROD", LocalDate.of(2025, 4, 18));

        List<Employee> empList = Arrays.asList(emp1, emp2, emp3, emp4, emp5, emp6, emp7);

        Stream<Employee> stream = empList.stream();
        System.out.println(stream.getClass().getName());
        List<String> names= empList.stream().map(e1->e1.getEmployeeName()).collect(Collectors.toList());
        System.out.println(names);

        List<Employee> filtered = empList.stream()
                .filter(e1 -> {
                    LocalDate d1 = e1.getDateOfJoining();
                    LocalDate currDate = LocalDate.now();
                    // Check if difference in years between currDate and d1 is >= 5
                    return ChronoUnit.YEARS.between(d1, currDate) >= 5;
                })
                .collect(Collectors.toList());

        System.out.println(filtered);
    }
}
