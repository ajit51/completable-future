package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CallbackExample2 {
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
        }).thenRun(() -> {
            System.out.println("Finished.");
        });

        completableFuture.join();
    }
}
