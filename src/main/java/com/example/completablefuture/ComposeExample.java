package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ComposeExample {

    public static void delay(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static CompletableFuture<String> getUserDetails() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("getUserDetails() - : " + Thread.currentThread().getName());
            delay(2);
            return "UserDetails";
        });
    }

    public static CompletableFuture<String> getWishList(String user) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("getWishList() - : " + user + " - " + Thread.currentThread().getName());
            delay(3);
            return "User's WishList";
        });
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        CompletableFuture<String> stringCompletableFuture = getUserDetails()
                .thenCompose(s -> getWishList(s));

        System.out.println("Doing something - " + Thread.currentThread().getName());
        delay(4);
        System.out.println(stringCompletableFuture.join());
        long endTime = System.currentTimeMillis();

        System.out.println("Time taken : " + (endTime - startTime) / 1000);
    }
}
