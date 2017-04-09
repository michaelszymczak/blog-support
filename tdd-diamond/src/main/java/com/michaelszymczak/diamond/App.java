package com.michaelszymczak.diamond;

import com.michaelszymczak.diamond.api.Letter;
import com.michaelszymczak.diamond.app.DiamondFactory;

public class App {
    public String getGreeting() {
        return new DiamondFactory().createFor(Letter.G).rendered();
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}
