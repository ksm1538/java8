package com.java8.ksm;

import java.util.concurrent.*;

public class Example13 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // CompletableFuture 사용해보기 1
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("Hello");

        System.out.println(future.get());

        // CompletableFuture.runAsync() : 리턴값이 없을 때 사용
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("Thread is Running : " + Thread.currentThread().getName());
        });
        future1.get();

        // CompletableFuture.supplyAsync() : 리턴값이 있을 때 사용
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            return "Thread is Running!! : " + Thread.currentThread().getName();
        });
        String s1 = future2.get();
        System.out.println(s1);

        // Callback 사용해보기 : thenApply(Function)
        // 1) thenApply(Function)
        // 2) thenAccept(Consumer)
        // 3) thenRun(Runnable)
        CompletableFuture<String> futureCallback1 = CompletableFuture.supplyAsync(() -> {
            return Thread.currentThread().getName();
        }).thenApply(s -> {
            return "Thread Name : " + s;
        });
        String s2 = futureCallback1.get();
        System.out.println(s2);
    }
}
