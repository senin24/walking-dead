package utils;

import java.util.Map;
import java.util.Objects;
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

    //https://stackoverflow.com/a/2904266/3853459
    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
