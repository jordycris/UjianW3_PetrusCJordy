package com.juaracoding;

public class Utils {
    static void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void assertLogin(String actual, String expected) {
        if (actual.equals(expected)) {
            System.out.println("Login Passes");
        } else {
            System.out.println("Login Failed");
        }
    }

    static void assertAddCart(String actual, String expected) {
        if (actual.equals(expected)) {
            System.out.println("Add to Cart Passes");
        } else {
            System.out.println("Add to Cart Failed");
        }
    }
}
