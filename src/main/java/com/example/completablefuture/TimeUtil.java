package com.example.completablefuture;

import java.util.concurrent.TimeUnit;

public class TimeUtil {

    public static void delay(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
