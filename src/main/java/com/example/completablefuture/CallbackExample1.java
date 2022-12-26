package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CallbackExample1 {
    public static void delay(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(
                () -> {
                    delay(1);
                    return "Tech Recipes";
                }).thenApply(s -> {
            return "Hello " + s;
        }).thenAccept(s -> {
            System.out.println("Result : " + s);
        });

        completableFuture.join();
    }
}
