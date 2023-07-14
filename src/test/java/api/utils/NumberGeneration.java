package api.utils;

import java.util.Random;

public class NumberGeneration {
    public static int generateRandom5DigitNumber() {
        Random random = new Random();
        return random.nextInt(90000) + 10000;
    }
}
