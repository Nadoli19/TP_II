package ca.csf.pobj.tp2.unit;

import java.security.InvalidParameterException;

public class RomanNumeral {
    public final static int MAX_VALUE = 4999;
    public final static int MIN_VALUE = 1;
    private final static String oneThousand = "M";
    private final static String fiveHundreds = "D";
    private final static String oneHundred = "C";
    private final static String fifty = "L";
    private final static String ten = "X";
    private final static String five = "V";
    private final static String one = "I";

    public String convertToRomanNumeral(int input) {
        StringBuilder result = new StringBuilder("");
        if (input < MIN_VALUE || input > MAX_VALUE) {
            throw new InvalidParameterException("Invalid input");
        } else {
            //BEN_CORRECTION : Duplication de code + Syndrome Stack Overflow.
            while (input != 0) {
                while (input >= 1000) {
                    result.append(oneThousand);
                    input -= 1000;
                }
                while (input >= 900) {
                    result.append(oneHundred + oneThousand);
                    input -= 900;
                }
                while (input >= 500) {
                    result.append(fiveHundreds);
                    input -= 500;
                }
                while (input >= 400) {
                    result.append(oneHundred + fiveHundreds);
                    input -= 400;
                }
                while (input >= 100) {
                    result.append(oneHundred);
                    input -= 100;
                }
                while (input >= 90) {
                    result.append(ten + oneHundred);
                    input -= 90;
                }
                while (input >= 50) {
                    result.append(fifty);
                    input -= 50;
                }
                while (input >= 40) {
                    result.append(ten + fifty);
                    input -= 40;
                }
                while (input >= 10) {
                    result.append(ten);
                    input -= 10;
                }
                while (input >= 9) {
                    result.append(one + ten);
                    input -= 9;
                }
                while (input >= 5) {
                    result.append(five);
                    input -= 5;
                }
                while (input >= 4) {
                    result.append(one + five);
                    input -= 4;
                }
                while (input >= 1) {
                    result.append(one);
                    input -= 1;
                }
            }
            return result.toString();
        }
    }
}

