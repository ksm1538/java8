package com.java8.ksm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example11 {
    public static void main(String[] args) {
        // ExecutorService 사용해보기
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // ExecutorService 는 작업을 실행시키면, 계속 대기하기 때문에 명시적으로 종료해줘야 함.
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Name : " + Thread.currentThread().getName());
            }
        });

        executorService.shutdown();         // 현재 진행중인 작업을 완료한 후에 종료
    }
}
