package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LengthTest {

    @Test
    public void testLengthRefactored_Equality() {
        assertTrue(new Length(12.0, LengthUnit.INCHES).equals(new Length(1.0, LengthUnit.FEET)));
    }

    @Test
    public void testLengthRefactored_ConvertTo() {
        assertTrue(new Length(12.0, LengthUnit.INCHES).equals(new Length(1.0, LengthUnit.FEET).convertTo(LengthUnit.INCHES)));
    }

    @Test
    public void testLengthRefactored_Add() {
        assertEquals(new Length(24.0, LengthUnit.INCHES), new Length(12.0, LengthUnit.INCHES).add(new Length(1.0, LengthUnit.FEET)));
    }

    @Test
    public void testLengthRefactored_AddWithTargetUnit() {
        assertEquals(new Length(24.0, LengthUnit.INCHES), new Length(12.0, LengthUnit.INCHES).add(new Length(1.0, LengthUnit.FEET), LengthUnit.INCHES));
    }

    @Test
    public void testLengthRefactored_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> new Length(1.0, null));
    }

    @Test
    public void testLengthRefactored_InvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> new Length(Double.NaN, LengthUnit.FEET));
    }
}
