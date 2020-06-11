package com.yevhensuturin;

public class PoliteWorkerMain {
    public static void main(String[] args) {
        final Worker worker1 = new Worker("Worker 1", true);
        final Worker worker2 = new Worker("Worker 2", true);
        SharedResource sharedResource = new SharedResource(worker1);

        new Thread(()->{
            worker1.work(sharedResource, worker2);
        }).start();

        new Thread(()->{
            worker2.work(sharedResource, worker1);
        });
    }
}
