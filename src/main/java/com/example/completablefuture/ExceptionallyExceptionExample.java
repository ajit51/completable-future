package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;

public class ExceptionallyExceptionExample {

    public static void main(String[] args) {
        boolean error = true;
        CompletableFuture<String> handleException = CompletableFuture.supplyAsync(() -> {
            if (error) {
                throw new RuntimeException("error@future");
            }
            return "Success";
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return "null";
        });

        String result = handleException.join();
        System.out.println(result);
    }
}
