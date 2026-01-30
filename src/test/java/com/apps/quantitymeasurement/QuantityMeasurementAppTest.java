package com.apps.quantitymeasurement;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuantityMeasurementAppTest {

    @Test
    public void testFleetEquality_SameValue() {
        QuantityMeasurementApp.Feet feet_one = new QuantityMeasurementApp.Feet(10d);
        QuantityMeasurementApp.Feet feet_two = new QuantityMeasurementApp.Feet(10d);
        var result = feet_one.equals(feet_two);
        assertTrue(result);
    }

    @Test
    public void testFleetEquality_DifferentValue() {
        QuantityMeasurementApp.Feet feet_one = new QuantityMeasurementApp.Feet(10d);
        QuantityMeasurementApp.Feet feet_two = new QuantityMeasurementApp.Feet(11d);
        var result = feet_one.equals(feet_two);
        assertFalse(result);
    }


    @Test
    public void testFleetEquality_NullComparison_For_Second_Value() {
        QuantityMeasurementApp.Feet feet_first_value = new QuantityMeasurementApp.Feet(10d);
        QuantityMeasurementApp.Feet feet_second_null = new QuantityMeasurementApp.Feet(null);
        var result = feet_first_value.equals(feet_second_null);
        assertFalse(result);
    }

    @Test
    public void testFleetEquality_NullComparison_For_First_Value() {
        QuantityMeasurementApp.Feet feet_first_value = new QuantityMeasurementApp.Feet(null);
        QuantityMeasurementApp.Feet feet_second_null = new QuantityMeasurementApp.Feet(10d);
        var result = feet_first_value.equals(feet_second_null);
        assertFalse(result);
    }

    @Test
    public void testFleetEquality_NullComparison() {
        QuantityMeasurementApp.Feet feet_first_value = new QuantityMeasurementApp.Feet(null);
        QuantityMeasurementApp.Feet feet_second_null = new QuantityMeasurementApp.Feet(null);
        var result = feet_first_value.equals(feet_second_null);
        assertTrue(result);
    }

    @Test
    public void testFleetEquality_SameReference() {
        QuantityMeasurementApp.Feet feet_first_value = new QuantityMeasurementApp.Feet(10d);
        QuantityMeasurementApp.Feet feet_second_null = feet_first_value;
        var result = feet_first_value.equals(feet_second_null);
        assertTrue(result);
    }

    @Test
    public void testFleetEquality_ForDifferentClass() {
        QuantityMeasurementApp.Feet feet_first_value = new QuantityMeasurementApp.Feet(10d);
        Object obj = "D1";
        assertFalse(feet_first_value.equals(obj));
    }

    @Test
    public void testInchesEquality_SameValue() {
        QuantityMeasurementApp.Inches inches_one = new QuantityMeasurementApp.Inches(10d);
        QuantityMeasurementApp.Inches inches_two = new QuantityMeasurementApp.Inches(10d);
        var result = inches_one.equals(inches_two);
        assertTrue(result);
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        QuantityMeasurementApp.Inches inches_one = new QuantityMeasurementApp.Inches(10d);
        QuantityMeasurementApp.Inches inches_two = new QuantityMeasurementApp.Inches(11d);
        var result = inches_one.equals(inches_two);
        assertFalse(result);
    }

    @Test
    public void testInchesEquality_NullComparison_For_Second_Value() {
        QuantityMeasurementApp.Inches inches_first_value = new QuantityMeasurementApp.Inches(10d);
        QuantityMeasurementApp.Inches inches_second_null = new QuantityMeasurementApp.Inches(null);
        var result = inches_first_value.equals(inches_second_null);
        assertFalse(result);
    }


    @Test
    public void testInchesEquality_NullComparison_For_First_Value() {
        QuantityMeasurementApp.Feet inches_first_value = new QuantityMeasurementApp.Feet(null);
        QuantityMeasurementApp.Feet inches_second_null = new QuantityMeasurementApp.Feet(10d);
        var result = inches_first_value.equals(inches_second_null);
        assertFalse(result);
    }

    @Test
    public void testInchesEquality_NullComparison() {
        QuantityMeasurementApp.Inches inches_first_value = new QuantityMeasurementApp.Inches(null);
        QuantityMeasurementApp.Inches inches_second_null = new QuantityMeasurementApp.Inches(null);
        var result = inches_first_value.equals(inches_second_null);
        assertTrue(result);
    }

    @Test
    public void testInchesEquality_SameReference() {
        QuantityMeasurementApp.Inches inches_first_value = new QuantityMeasurementApp.Inches(10d);
        QuantityMeasurementApp.Inches inches_second_null = inches_first_value;
        var result = inches_first_value.equals(inches_second_null);
        assertTrue(result);
    }

    @Test
    public void testInchesEquality_ForDifferentClass() {
        QuantityMeasurementApp.Inches feet_first_value = new QuantityMeasurementApp.Inches(10d);
        Object obj = "D1";
        assertFalse(feet_first_value.equals(obj));
    }
}
