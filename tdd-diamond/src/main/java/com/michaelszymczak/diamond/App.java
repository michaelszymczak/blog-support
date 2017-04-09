package com.michaelszymczak.diamond;

public class App {
    public String getGreeting() {
        return "Hello Diamond.";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
