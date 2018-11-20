package ca.csf.pobj.tp2.util;

public class NumberUtils {

    private NumberUtils() {
        //Private, so it is a static class
    }

    public static int toInt(String string) {
        return Integer.parseInt(string);
    }
}
