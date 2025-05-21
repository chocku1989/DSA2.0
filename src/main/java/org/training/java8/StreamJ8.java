package org.training.java8;

import com.sun.tools.javac.Main;
import org.training.Employee;
import org.training.User;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamJ8 {

    public static void tryStreams( List<Employee> employees){

        List<Employee> list = employees.stream().filter(e1 -> e1.getRole() .equals("HR Manager")).toList();
        list.forEach(System.out::print);

        Map<String, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(e1 -> e1.getLocation()));
        collect.forEach((role, empList) -> {
            System.out.println(role + ": " + empList);
        });

        List<Employee> collect1 = employees.stream().map(e1 -> {
            e1.setName(e1.getName().toUpperCase());
            return e1;
        }).collect(Collectors.toList());//////////

//        List<Employee> collect1 = employees.stream()
//                .map(e -> {
//                    e.setName(e.getName().toUpperCase()); // Modify the name only
//                    return e; // Return the modified employee object
//                })
//                .collect(Collectors.toList());
        collect1.forEach(System.out::print);
    }

    public static void tryStreams1( List<User> users){
        List<Long> list = users.stream().flatMap(u1 -> u1.getContactNumbers().stream()).toList();
        System.out.println("mob no");
       list.forEach(l1-> System.out.println(l1));
    }

    public static void main(String[] args) throws FileNotFoundException {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("John Doe", 1, "Software Engineer", "New York", 9876543210L));
        employees.add(new Employee("Jane Smith", 2, "Project Manager", "San Francisco", 9876543211L));
        employees.add(new Employee("Robert Brown", 3, "QA Engineer", "Chicago", 9876543212L));
        employees.add(new Employee("Emily White", 4, "Business Analyst", "Los Angeles", 9876543213L));
        employees.add(new Employee("Michael Johnson", 5, "HR Manager", "Dallas", 9876543214L));
        employees.add(new Employee("Michael Johnson", 5, "HR Manager", "Dallas", 9876543214L));
        Employee e1 =new Employee("Michael Johnson", 5, "HR Manager", "Dallas", 9876543214L);
        Employee e2 =new Employee("Michael Johnson", 5, "HR Manager", "Dallas", 9876543214L);

        tryStreams(employees);

        List<User> users = Arrays.asList(
                new User("Alice", 101, 30, "Software Engineer", "New York", Arrays.asList(1234567890L, 9876543210L)),
                new User("Bob", 102, 35, "Project Manager", "San Francisco", Arrays.asList(1112223333L, 4445556666L)),
                new User("Charlie", 103, 28, "Designer", "Los Angeles", Arrays.asList(5556667777L)),
                new User("David", 104, 40, "Data Scientist", "Chicago", Arrays.asList(7778889999L, 8889990000L)),
                new User("Eva", 105, 22, "Intern", "Seattle", Arrays.asList(9990001111L))
        );

        tryStreams1(users);

        System.out.println(e1.equals(e2));
        System.out.println(e1.hashCode());
        System.out.println(e2.hashCode());

        StringOccurrence test = new StringOccurrence("test");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(""));
//        bufferedReader.readLine()
    }
}
