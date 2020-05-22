package com.yevhensuturin;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        try {
            int result = devide();
            System.out.println(result);
        } catch (ArithmeticException | NoSuchElementException e){
            System.out.println(e.toString());
            System.out.println("Unable to perforn devision operation.");
        }
    }

    private static int devide(){
        int x, y;
        try {
            x = getInt();
            y = getInt();
            System.out.println("x = "+x+", y = "+y);
            return x / y;
        } catch (NoSuchElementException e){
            throw new ArithmeticException("no suitable input");
        } catch (ArithmeticException e){
            throw new ArithmeticException("attempt to divide by zero");
        }
    }

    private static int getInt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter a number");
        while(true){
            try{
                return scanner.nextInt();
            } catch (InputMismatchException e){
                scanner.nextLine();
                System.out.println("Please, enter a number using only the digits 0 to 9");
            }
        }
    }
}
