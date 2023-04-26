package com.java8.ksm;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Example12 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> callable1 = () -> {
            Thread.sleep(1000L);
            return "callable1";
        };

        System.out.println("START");
        Future<String> result = executorService.submit(callable1);

        String s = result.get();            // get() : ExecutorService 의 callable 작업이 끝날 때까지 프로그램 대기.
        System.out.println("END");
        System.out.println("s : " + s);


        Callable<String> callable2 = () -> {
            Thread.sleep(2000L);
            return "callable2";
        };

        Callable<String> callable3 = () -> {
            Thread.sleep(3000L);
            return "callable3";
        };

        // invokeAll : 해당 callable 작업이 모두 끝나야 결과값 반환.
        // invokeAny : 하나라도 빨리 끝나면, 그 하나의 결과값 반환
        List<Future<String>> resultList = executorService.invokeAll(Arrays.asList(callable1, callable2, callable3));

        for (Future<String> f : resultList) {
            System.out.println(f.get());
        }

        executorService.shutdown();
    }
}
