package com.yevhensuturin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaSortingMain {
    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee tim = new Employee( "Tim Buchalka", 21);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(tim);
        employees.add(jack);
        employees.add(snow);

        Collections.sort(employees, (first, second)->{return first.getName().compareTo(second.getName());});

        for (Employee employee: employees){
            System.out.println(employee);
        }

        Collections.sort(employees, (first, second)->{return first.getAge()-second.getAge();});

        for (Employee employee: employees){
            System.out.println(employee);
        }

//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + " " +s2.toUpperCase();
//            }
//        }, employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);
//
//        sillyString = doStringStuff((s1, s2)-> s1.toUpperCase()+": "+s2.toUpperCase(), employees.get(0).getName(), employees.get(1).getName());
//        System.out.println(sillyString);
//
//        UpperConcat uc = (s1, s2) ->{
//            String results = s1.toUpperCase() + " - " + s2.toUpperCase();
//            return results;
//        };
//        System.out.println(doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName()));
//        for(Employee employee: employees){
//            System.out.println(employee.getName());
//            System.out.println(employee.getAge());
//        }

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

// Does work. Because the lambda was used where employee is effectively final
//        for(Employee employee: employees){
//            System.out.println(employee.getName());
//            new Thread(()-> System.out.println(employee.getAge())).start();
//        }
// Does work. Because the lambda was used where employee is effectively final
//        for (int i=0; i<employees.size(); i++){
//            Employee employee=employees.get(i);
//            new Thread(()-> System.out.println(employee.getName())).start();
//        }

// Does not work
//        Employee employee;
//        for (int i=0; i<employees.size(); i++){
//            employee=employees.get(i);
//            new Thread(()-> System.out.println(employee.getName()));
//        }

        AnotherClass anotherClass = new AnotherClass();
        System.out.println(anotherClass.doSomeThing());
    }

    public final static String doStringStuff(UpperConcat uc, String s1, String s2){
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee{
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: "+name+"; age: "+age;
    }
}

interface UpperConcat{
    public String upperAndConcat(String s1, String s2);
}

class AnotherClass{
    public String doSomeThing(){
//lambda usage
        int i = 0;
        UpperConcat upperConcat = (s1, s2) -> {
                    System.out.println("The lambda class's name is: " + getClass().getSimpleName());
                    System.out.println("i in the lambda expression = " + i);
                    return s1.toUpperCase() + " // " + s2.toUpperCase();
        };

        String s1="Hello";
        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
//        i++;
        System.out.println("i = " + i);
        return LambdaSortingMain.doStringStuff(upperConcat, "Str1", "str2");
//Anonymous class usage
//        int i = 0;
//        {
//            UpperConcat upperConcat = new UpperConcat() {
//                @Override
//                public String upperAndConcat(String s1, String s2) {
//                    System.out.println("i = " + i);
//                    return s1.toUpperCase() + " -- " + s2.toUpperCase();
//                }
//            };
//           System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
//           System.out.println("i = " + i);
//           return LambdaSortingMain.doStringStuff(upperConcat, "Str1", "str2");
//        }

//        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
//        return LambdaSortingMain.doStringStuff((s1, s2) -> {
//                    System.out.println("The lambda class's name is: " + getClass().getSimpleName());
//                return s1.toUpperCase() + " == " + s2.toUpperCase();}, "String1", "String2");

//        System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
//        return LambdaSortingMain.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The anonymous class's name is: " + getClass().getSimpleName());
//                return s1.toUpperCase() + " !! "+s2.toUpperCase();
//            }
//        }, "String1", "String2");
    }

    public void printValue(){
        int number = 25;

        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("The value number = "+number);
        };

        new Thread(r).start();
    }
}
