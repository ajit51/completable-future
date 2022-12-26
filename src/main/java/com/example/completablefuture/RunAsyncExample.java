package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunAsyncExample {

    public static void delay(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        Runnable runnable = () -> {
            delay(1);
            System.out.println("I am in runnable : " + Thread.currentThread().getName());
        };

        //CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(runnable);
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(runnable, executorService);
        System.out.println("I am in : " + Thread.currentThread().getName());
        completableFuture.join();
    }
}
