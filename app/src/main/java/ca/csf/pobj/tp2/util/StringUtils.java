package ca.csf.pobj.tp2.util;

public final class StringUtils {
    private StringUtils() {
        //Private, so it is a static class
    }

    public static boolean isBlank(CharSequence value) {
        if (value != null) {
            for (int i = 0; i < value.length(); i++) {
                if (!Character.isWhitespace(value.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
