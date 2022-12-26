package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;

public class AllOfExample {

    public static CompletableFuture<String> future1() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Future1 - " + Thread.currentThread().getName());
            TimeUtil.delay(2);
            return "1";
        });
    }

    public static CompletableFuture<String> future2() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Future2 - " + Thread.currentThread().getName());
            TimeUtil.delay(4);
            return "2";
        });
    }

    public static CompletableFuture<String> future3() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Future3 - " + Thread.currentThread().getName());
            TimeUtil.delay(1);
            return "3";
        });
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(future1(), future2(), future3());
        completableFuture.join();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken - " + (endTime - startTime) / 1000);
    }
}
