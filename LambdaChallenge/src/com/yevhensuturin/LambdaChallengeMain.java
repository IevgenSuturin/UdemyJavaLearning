package com.yevhensuturin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaChallengeMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        Runnable runnable = ()->{
          String myString = "Let's split this up into an array";
          String[] parts = myString.split(" ");
          for(String s: parts){
              System.out.println(s);
          }
        };

        Thread t1 = new Thread(runnable);
        t1.start();
        t1.join();

        Function<String, String> everySecondChar = source -> {
            StringBuilder returnValue = new StringBuilder();
            for(int i = 0; i < source.length(); i++){
                if(i%2 == 0){
                    returnValue.append(source.charAt(i));
                }
            }
            return returnValue.toString();
        };

        System.out.println(everySecondChar.apply("1234567890"));
        System.out.println(everySecondCharacter("1234567890", everySecondChar));

        Supplier<String> javaString = () -> "I love Java!";

        String supplierResult = javaString.get();
        System.out.println(supplierResult);

        Callable<String> callable = ()->"Return from callable";
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> future = executor.submit(callable);
        System.out.println(future.get());
        executor.shutdown();


        System.out.println("\n-----------------------------------\n");
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        List<String> firstUpperCaseList = new ArrayList<>();
        topNames2015.forEach(s->
                firstUpperCaseList.add(s.substring(0,1).toUpperCase().concat(s.substring(1)))
                );

        //Collections.sort(firstUpperCaseList);
        firstUpperCaseList.sort(String::compareTo);
        firstUpperCaseList.forEach(System.out::println);
        System.out.println("\n-----------------------------------\n");


        topNames2015.stream()
                .map(s->s.substring(0,1).toUpperCase().concat(s.substring(1)))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .forEach(System.out::println);

        Long number = topNames2015.stream()
                //.map(s->s.substring(0,1).toUpperCase().concat(s.substring(1)))
                .filter(s->s.toUpperCase().startsWith("A"))
                .count();
        System.out.println(number);
    }

    public static String everySecondCharacter(String str, Function<String, String> myFunction){
        return myFunction.apply(str);
    }
}
