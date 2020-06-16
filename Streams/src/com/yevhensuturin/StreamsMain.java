package com.yevhensuturin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsMain {
    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList("N40", "N36", "B12", "B36", "G53", "G49", "G60", "G50", "g64",
                                                      "I26", "I17", "I29", "O71");

//        List<String> gNumbers = new ArrayList<>();
//
//        someBingoNumbers.forEach(number->{
//            if (number.toUpperCase().startsWith("G")) {
//                gNumbers.add(number);
////                System.out.println(number);
//            };
//        });
//
//        gNumbers.sort((s1, s2)->s1.compareTo(s2));
//        gNumbers.forEach(s-> System.out.println(s));

        someBingoNumbers.stream()
                        .map(String::toUpperCase)
                        .filter(s->s.startsWith("G"))
                        .sorted((s1, s2)->s2.compareTo(s1))
                        .forEach(System.out::println);

        Stream<String> ioNumberString = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberString = Stream.of("N40", "N36", "I26", "I17", "I21", "O71");
        Stream<String> concatString = Stream.concat(ioNumberString, inNumberString);

        System.out.println("---------------------------------");
        System.out.println(concatString
                .peek(System.out::println)
                .distinct()
                .peek(System.out::println)
                .count()
        );

        Employee john = new Employee("John Doe", 20);
        Employee jack = new Employee("Jack Hill", 34);
        Employee jane = new Employee("Jane Deer", 30);
        Employee snow = new Employee("Snow White", 19);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jack);
        hr.addEmployee(jane);
        hr.addEmployee(snow);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);
        System.out.println("-----------------------------------------");
//        List<String> sortedGNumbers = someBingoNumbers.stream()
//                .map(String::toUpperCase)
//                .sorted()
//                .filter(s->s.startsWith("G"))
//                .collect(Collectors.toList());
        List<String> sortedGNumbers = someBingoNumbers.stream()
                .map(String::toUpperCase)
                .sorted()
                .filter(s->s.startsWith("G"))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll
                );

        sortedGNumbers.forEach(System.out::println);

        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge()<e2.getAge() ? e1: e2)
                .ifPresent(System.out::println);

        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s->{
                    System.out.println(s);
                    return s.length() == 3;
                })
        .count();
    }
}
