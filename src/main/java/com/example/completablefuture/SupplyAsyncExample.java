package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SupplyAsyncExample {

    public static void delay(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Supplier supplier = () -> {
            delay(1);
            System.out.println("I am in supllier : " + Thread.currentThread().getName());
            return "Hello from Supllier";
        };

        CompletableFuture completableFuture = CompletableFuture.supplyAsync(supplier);
        System.out.println("I am in main");
        String value = (String) completableFuture.join();
        System.out.println("value : " + value);
    }
}
