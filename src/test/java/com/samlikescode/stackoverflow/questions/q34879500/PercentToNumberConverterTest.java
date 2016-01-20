package com.samlikescode.stackoverflow.questions.q34879500;

import org.junit.Test;

import java.text.DecimalFormat;
import java.text.ParsePosition;

import static org.junit.Assert.assertEquals;

public class PercentToNumberConverterTest {
    @Test
    public void testStringPercentToFloat() throws Exception {
        String percent = "100%";
        float floatValue = new DecimalFormat("0.0").parse(percent).floatValue();
        assertEquals(100, floatValue, 0.0001);
    }

    @Test
    public void testStringPxToFloat() throws Exception {
        String percent = "100px";
        float floatValue = new DecimalFormat("0.0#").parse(percent).floatValue();
        assertEquals(100, floatValue, 0.0001);
    }

    @Test
    public void testStringValueToFloat() throws Exception {
        String percent = "100";
        float floatValue = new DecimalFormat("0.0#%").parse(percent).floatValue();
        assertEquals(100, floatValue, 0.0001);
    }

    @Test
    public void testStringJibberishToFloat() throws Exception {
        String stringInput = "Some jibberish 100px more jibberish.";

        int i = 0;
        while (!Character.isDigit(stringInput.charAt(i))) i++;

        float floatValue = new DecimalFormat("0.0").parse(stringInput, new ParsePosition(i)).floatValue();
        assertEquals(100, floatValue, 0.0001);
    }
}