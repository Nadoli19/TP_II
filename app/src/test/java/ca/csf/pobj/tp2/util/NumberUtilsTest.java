package ca.csf.pobj.tp2.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberUtilsTest {

    @Test
    public void CanConvertStringToInt() {
        assertEquals(1, NumberUtils.toInt("1"), 0);
        assertEquals(999, NumberUtils.toInt("999"), 0);
        assertEquals(2567, NumberUtils.toInt("2567"), 0);
    }

    @Test
    public void CanConvertStringToIntWhenNegative() {
        assertEquals(-1, NumberUtils.toInt("-1"), 0);
        assertEquals(-999, NumberUtils.toInt("-999"), 0);
        assertEquals(-2567, NumberUtils.toInt("-2567"), 0);
    }

    @Test
    public void CanConvertIntToString() {
        assertEquals("1", NumberUtils.toString(1));
        assertEquals("4999", NumberUtils.toString(4999));
    }

    @Test
    public void CanConvertNegativeFloatToString() {
        assertEquals("-1", NumberUtils.toString(-1));
        assertEquals("-4999", NumberUtils.toString(-4999));
    }
}