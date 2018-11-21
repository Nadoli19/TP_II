package ca.csf.pobj.tp2.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void ShouldTellThatEmptyStringIsBlank() {
        assertTrue(StringUtils.isBlank(""));
    }

    @Test
    public void ShouldTellThatStringWithWhitespacesIsBlank() {
        assertTrue(StringUtils.isBlank("   "));
    }

    @Test
    public void ShouldTellThatNullStringIsBlank() {
        assertTrue(StringUtils.isBlank(null));
    }

    @Test
    public void ShouldTellThatStringWithNonWhitespaceCharsIsNotBlank() {
        assertFalse(StringUtils.isBlank("Hello world!"));
    }

    @Test
    public void ShouldTellThatStringWithLeadingWhitespaceCharsIsNotBlank() {
        assertFalse(StringUtils.isBlank("    Hello world!"));
    }

    @Test
    public void ShouldTellThatStringWithTraillingWhitespaceIsNotBlank() {
        assertFalse(StringUtils.isBlank("Hello world!    "));
    }

    @Test
    public void ShouldTellThatStringWithLeadingAndTraillingWhitespaceIsNotBlank() {
        assertFalse(StringUtils.isBlank("    Hello world!    "));
    }
}