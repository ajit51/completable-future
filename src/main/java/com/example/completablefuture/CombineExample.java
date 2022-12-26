package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CombineExample {

    public static void delay(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static CompletableFuture<String> getUserEmail() {
        return CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("getUserEmail() - " + Thread.currentThread().getName());
                    delay(3);
                    return "tech.recipe@yt.com";
                });
    }

    public static CompletableFuture<String> getWeatherReport() {
        return CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("getWeatherReport() - " + Thread.currentThread().getName());
                    delay(3);
                    return "Weather Report of city is - Rainy";
                });
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        CompletableFuture<String> completableFuture = getUserEmail().thenCombine(getWeatherReport(), (e, w) -> {
            System.out.println("Sending email to " + e + " with report - " + w);
            delay(1);
            return e + w;
        });
        System.out.println("Doing something");
        delay(3);
        System.out.println(completableFuture.join());
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken - " + (endTime - startTime) / 1000);
    }
}
