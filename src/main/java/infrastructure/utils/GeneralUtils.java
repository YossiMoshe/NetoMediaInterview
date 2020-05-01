package infrastructure.utils;

import static java.util.UUID.randomUUID;

public class GeneralUtils {

    public static String getUUID() {
        return String.valueOf(randomUUID());
    }
}
