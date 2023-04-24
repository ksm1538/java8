package com.java8.ksm;

public class Example10 {

    static class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println("Thread is Running : " + Thread.currentThread().getName());
        }
    }


    public static void main(String[] args) {
        /*** Thread를 사용하는 방법 ***/
        // 1. Thread 상속
        Thread1 thread1 = new Thread1();
        thread1.start();

        // 2. Runnable 을 상속한 익명 함수 (람다 표현식 가능)
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    // sleep 하는 동안, 다른 Thread 는 작업을 진행.
                    Thread.sleep(2000L);
                }catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
                System.out.println("Thread is Running : " + Thread.currentThread().getName());
            }
        });
        thread2.start();

        System.out.println("Main is Running");
    }
}
