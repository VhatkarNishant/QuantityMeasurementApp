package com.apps.quantitymeasurement;

import org.junit.Assert;
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
    public void testFleetEquality_NullComparison() {
        QuantityMeasurementApp.Feet feet_one = new QuantityMeasurementApp.Feet(11d);
        QuantityMeasurementApp.Feet feet_two = new QuantityMeasurementApp.Feet(null);
        var result = feet_one.equals(feet_two);
        assertFalse(result);
    }
}
