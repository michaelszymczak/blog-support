package com.michaelszymczak.blogsupport;

public class Tdd {
    public String getGreeting() {
        return "Hello TDD!";
    }

    public static void main(String[] args) {
        System.out.println(new Tdd().getGreeting());
    }
}
