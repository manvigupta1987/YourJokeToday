package com.example;

import java.util.Random;

public class jokeProvider {

    private String[] jokes ={"Can a kangaroo jump higher than a house? Of course, a house doesn’t jump at all.",
        "My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.",
        "I heard women love a man in uniform. Can’t wait to start working at McDonalds.",
            "It is so cold outside I saw a politician with his hands in his own pockets."};

    public String getJoke() {
        Random random = new Random();
        int index = random.nextInt(jokes.length);
        return jokes[index];
    }
}
