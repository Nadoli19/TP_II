package ca.csf.pobj.tp2.unit;

import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;

public class RomanNumeralTest {

    private RomanNumeral romanNumeral;

    @Before
    public void Before() {
        romanNumeral = new RomanNumeral();
    }

    @Test
    public void canConvertToRomanNumeral() {
        assertEquals("MMMMCMXCIX", romanNumeral.convertToRomanNumeral(4999));
        assertEquals("MMMM", romanNumeral.convertToRomanNumeral(4000));
        assertEquals("MMMCMXCIX", romanNumeral.convertToRomanNumeral(3999));
        assertEquals("MMM", romanNumeral.convertToRomanNumeral(3000));
        assertEquals("MM", romanNumeral.convertToRomanNumeral(2000));
        assertEquals("M", romanNumeral.convertToRomanNumeral(1000));
        assertEquals("D", romanNumeral.convertToRomanNumeral(500));
        assertEquals("CCC", romanNumeral.convertToRomanNumeral(300));
        assertEquals("C", romanNumeral.convertToRomanNumeral(100));
        assertEquals("L", romanNumeral.convertToRomanNumeral(50));
        assertEquals("XXX", romanNumeral.convertToRomanNumeral(30));
        assertEquals("XX", romanNumeral.convertToRomanNumeral(20));
        assertEquals("X", romanNumeral.convertToRomanNumeral(10));
        assertEquals("IX", romanNumeral.convertToRomanNumeral(9));
        assertEquals("V", romanNumeral.convertToRomanNumeral(5));
        assertEquals("I", romanNumeral.convertToRomanNumeral(1));
    }

    @Test(expected = InvalidParameterException.class)
    public void throwTheExceptionIfNeededZero() {
        romanNumeral.convertToRomanNumeral(0);
    }

    @Test(expected = InvalidParameterException.class)
    public void throwTheExceptionIfNeededFiveThousand() {
        romanNumeral.convertToRomanNumeral(5000);
    }

    @Test(expected = InvalidParameterException.class)
    public void throwTheExceptionIfNeededNeg() {
        romanNumeral.convertToRomanNumeral(-999999);
    }

    @Test(expected = InvalidParameterException.class)
    public void throwTheExceptionIfNeededToHigh() {
        romanNumeral.convertToRomanNumeral(999999);
    }
}