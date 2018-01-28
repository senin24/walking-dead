package utils;

import java.util.Random;

public class Util {

    public static int getRandom(int min, int max) {
        return (new Random()).nextInt(max - min) + min;
    }

    public static int getRandom(int max) {
        return getRandom(0, max);
    }

    public static boolean getRandom() {
        return (new Random()).nextBoolean();
    }
}
