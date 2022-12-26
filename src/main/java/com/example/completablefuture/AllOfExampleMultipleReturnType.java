package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;

public class AllOfExampleMultipleReturnType {

    public static CompletableFuture<Integer> future1() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Future1 - " + Thread.currentThread().getName());
            TimeUtil.delay(2);
            return Integer.valueOf(12);
        });
    }

    public static CompletableFuture<Double> future2() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Future2 - " + Thread.currentThread().getName());
            TimeUtil.delay(4);
            return Double.valueOf(1.23);
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
        CompletableFuture<Integer> future1 = future1();
        CompletableFuture<Double> future2 = future2();
        CompletableFuture<String> future3 = future3();
        CompletableFuture<Void> completableFuture = CompletableFuture
                .allOf(future1(), future2(), future3())
                .thenAccept(ignore -> {
                    System.out.println("future1 - " + future1.join());
                    System.out.println("future2 - " + future2.join());
                    System.out.println("future3 - " + future3.join());
                });
        completableFuture.join();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken - " + (endTime - startTime) / 1000);
    }
}
