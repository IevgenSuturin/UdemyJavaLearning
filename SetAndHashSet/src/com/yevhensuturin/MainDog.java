package com.yevhensuturin;

public class MainDog {
    public static void main(String[] args) {
        Labrador roverSub = new Labrador("Rover");
        Dog roverBase = new Dog("Rover");

        System.out.println(roverBase.equals(roverSub));
        System.out.println(roverSub.equals(roverBase));
    }
}
