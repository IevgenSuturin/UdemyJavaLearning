package com.yevhensuturin;

import static com.yevhensuturin.ThreadColor.*;

public class ThreadsMain {
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE+"Hello from the main thread!");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        new Thread(){
            @Override
            public void run(){
                System.out.println(ANSI_GREEN+"Hello from the anonymous class!");
            }
        }.start();

        new Thread(()-> {
            System.out.println(ANSI_CYAN+"Hello from the lambda thread");
        }).start();

        Thread myRunnablethread = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous implementations of the run!");
                try {
                    anotherThread.join();
                    System.out.println(ANSI_RED+"AnotherThread has terminated or timed out, so I'm running again");
                } catch (InterruptedException e){
                    System.out.println(ANSI_RED + "I coundn't wait after all. I was interrupted!");
                }
            }
        });
        myRunnablethread.start();
//        anotherThread.interrupt();

        System.out.println(ANSI_PURPLE+"Hello again from the main thread!");

// It is not possible to start thread second time (IIllegalThreadStateException occurs)
//        anotherThread.start();
    }
}
