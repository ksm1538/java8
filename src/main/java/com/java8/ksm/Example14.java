package com.java8.ksm;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example14 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> nameFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("nameFuture1 is Running : " + Thread.currentThread().getName());
            return "JAVA";
        });

        CompletableFuture<String> nameFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("nameFuture2 is Running : " + Thread.currentThread().getName());
            return "C++";
        });

        // 1. thenCompose()
        CompletableFuture<String> future = nameFuture1.thenCompose((s) -> combineString(s));
        System.out.println(future.get());

        // 2. thenCombine()
        CompletableFuture<String> futureCombine = nameFuture1.thenCombine(nameFuture2, (result1, result2) -> result1 + ", " + result2);
        System.out.println(futureCombine.get());
    }

    // Future 의 결과값을 이용해서 CompletableFuture 로 반환
    static CompletableFuture<String> combineString(String s) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("combineString is Running : " + Thread.currentThread().getName());
            return s + " KING";
        });
    }
}
