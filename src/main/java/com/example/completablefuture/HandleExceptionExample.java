package com.example.completablefuture;

import java.util.concurrent.CompletableFuture;

public class HandleExceptionExample {

    public static void main(String[] args) {
        boolean error = true;
        CompletableFuture<String> handleException = CompletableFuture.supplyAsync(() -> {
            if (error) {
                throw new RuntimeException("error@future");
            }
            return "Success";
        }).handle((s, e) -> {
            if (e != null) {
                System.out.println(e.getMessage());
                return "null";
            }
            return s;
        });

        String result = handleException.join();
        System.out.println(result);
    }
}
