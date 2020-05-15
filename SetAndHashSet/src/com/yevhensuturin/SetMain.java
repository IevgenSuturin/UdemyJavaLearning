package com.yevhensuturin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for(int i=1; i<=100; i++){
            squares.add(i*i);
            cubes.add(i*i*i);
        }

        System.out.println("There are "+squares.size()+" squares and "+cubes.size()+" cubes");

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("union contains "+union.size() + " elements");

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("intersection contains "+intersection.size() + " elements");
        for (Integer el: intersection) {
            System.out.println(el + " is the square of "+Math.sqrt(el) + " and a cube of "+Math.cbrt(el));
        }

        Set<String> setString = new HashSet<>();
        String string = "one day in the year of the fox";
        String[] arrayString = string.split(" ");
        setString.addAll(Arrays.asList(arrayString));
        for(String str: setString){
            System.out.println(str);
        }

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();

        String[] natureWorlds = {"all", "nature", "is", "but", "art", "unknown", "to", "three"};
        String[] divineWorlds = {"to", "err", "is", "human", "to", "forgive", "divine"};

        nature.addAll(Arrays.asList(natureWorlds));
        divine.addAll(Arrays.asList(divineWorlds));

        System.out.println("nature - divine");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("divine - nature");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);
        System.out.println("Symmetric difference");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        if(nature.containsAll(divine)){
            System.out.println("divine is a subset of nature");
        }


        Integer first = 100;

        ArrayList<Integer> arr1 = new ArrayList<>();
        for(int i=1; i<=5; i++){
            arr1.add(i);
        }

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.addAll(arr1);
        arr1.add(first);
        arr2.add(first);

        for (Integer el1:arr1) {
            System.out.print(el1);
        }
        System.out.println();
        for (Integer el2:arr2) {
            System.out.print(el2);
        }
        System.out.println();

//        for(int i=0; i<5; i++){
//            arr2.set(i, i);
//        }
        first=200;
        for (Integer el1:arr1) {
            System.out.print(el1);
        }
        System.out.println();
        for (Integer el2:arr2) {
            System.out.print(el2);
        }

    }

    private static void printSet(Set<String> set){
        System.out.print("\t");
        for(String s: set){
            System.out.print(s+" ");
        }
        System.out.println();
    }
}
