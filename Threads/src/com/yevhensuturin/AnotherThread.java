package com.yevhensuturin;

import static com.yevhensuturin.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ANSI_BLUE+"Hello from "+currentThread().getName());

        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            System.out.println(ANSI_BLUE + "Another thread woke me up");
            return;
        }

        System.out.println(ANSI_BLUE+"Three seconds are past and I'm awake");
    }
}
