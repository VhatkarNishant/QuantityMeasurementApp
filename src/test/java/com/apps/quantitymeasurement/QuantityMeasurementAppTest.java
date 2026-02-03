package com.apps.quantitymeasurement;


import org.junit.jupiter.api.Test;

import static com.apps.quantitymeasurement.QuantityMeasurementApp.demonstrateLengthComparison;
import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    public void testEquality_FeetToFeet_SameValue() {
        Length length1 = new Length(2.0, Length.LengthUnit.FEET);
        Length length2 = new Length(2.0, Length.LengthUnit.FEET);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
    }

    @Test
    public void testEquality_InchesToInches_SameValue() {
        Length length1 = new Length(2.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(2.0, Length.LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
    }

    @Test
    public void testEquality_NullComparison() {
        Length length1 = new Length(null, null);
        Length length2 = new Length(null, null);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
    }

    @Test
    public void testEquality_NullComparison_For_Second_Value() {
        Length length1 = new Length(2.0, null);
        Length length2 = new Length(2.0, null);
        assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
    }


    @Test
    public void testEquality_NullComparison_For_First_Value() {
        Length length1 = new Length(null, Length.LengthUnit.INCHES);
        Length length2 = new Length(null, Length.LengthUnit.FEET);
        assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
    }

    @Test
    public void testEquality_InchesToFeet_EquivalentValue() {
        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(12.0, Length.LengthUnit.FEET);
        assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
    }

    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        Length length1 = new Length(12.0, Length.LengthUnit.FEET);
        Length length2 = new Length(2.0, Length.LengthUnit.FEET);
        assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
    }

    @Test
    public void testEquality_InchesToInches_DifferentValue() {
        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length2 = new Length(2.0, Length.LengthUnit.INCHES);
        assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
    }

    @Test
    public void testEquality_InvalidUnits() {
        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        assertThrows(Exception.class, () -> QuantityMeasurementApp.demonstrateLengthEquality(length1, (Length) new Object()));
    }

    @Test
    public void testEquality_SameReference() {
        Length length1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length length2 = length1;
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
    }


    @Test
    public void testDemonstrateLengthComparison_YardToYard_SameValue() {
        var result = demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS, 1.0, Length.LengthUnit.YARDS);
        assertTrue(result);
    }

    @Test
    public void testDemonstrateLengthComparison_YardToYard_DifferentValue() {
        var result = demonstrateLengthComparison(2.0, Length.LengthUnit.YARDS, 1.0, Length.LengthUnit.YARDS);
        assertFalse(result);
    }

    @Test
    public void testDemonstrateLengthComparison_YardToFeet_SameValue() {
        var result = demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS, 3.0, Length.LengthUnit.FEET);
        assertTrue(result);
    }

    @Test
    public void testDemonstrateLengthComparison_FeetToYard_SameValue() {
        var result = demonstrateLengthComparison(3.0, Length.LengthUnit.FEET, 1.0, Length.LengthUnit.YARDS);
        assertTrue(result);
    }

    @Test
    public void testDemonstrateLengthComparison_YardToInches_SameValue() {
        var result = demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS, 36.0, Length.LengthUnit.INCHES);
        assertTrue(result);
    }

    @Test
    public void testDemonstrateLengthComparison_InchesToYard_SameValue() {
        var result = demonstrateLengthComparison(36.0, Length.LengthUnit.INCHES, 1.0, Length.LengthUnit.YARDS);
        assertTrue(result);
    }

    @Test
    public void testDemonstrateLengthComparison_YardToFeet_DifferentValue() {
        var result = demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS, 33.0, Length.LengthUnit.FEET);
        assertFalse(result);
    }

    @Test
    public void testDemonstrateLengthComparison_CentimetersToInches_SameValue() {
        var result = demonstrateLengthComparison(1.0, Length.LengthUnit.CENTIMETRE, 0.393701, Length.LengthUnit.INCHES);
        assertTrue(result);
    }

    @Test
    public void testDemonstrateLengthComparison_CentimetersToFeet_DifferentSameValue() {
        var result = demonstrateLengthComparison(1.0, Length.LengthUnit.CENTIMETRE, 1.0, Length.LengthUnit.FEET);
        assertFalse(result);
    }


    @Test
    public void testDemonstrateLengthComparison_MultiUnit_TransitiveProperty() {
        assertAll(
                () -> assertTrue(demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS, 3.0, Length.LengthUnit.FEET)),
                () -> assertTrue(demonstrateLengthComparison(3.0, Length.LengthUnit.FEET, 36.0, Length.LengthUnit.INCHES)),
                () -> assertTrue(demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS, 36.0, Length.LengthUnit.INCHES))
        );
    }

    @Test
    public void testDemonstrateLengthComparison_YardWithNullUnit() {
        var result = demonstrateLengthComparison(1.0, null, 33.0, Length.LengthUnit.FEET);
        assertFalse(result);
    }


    @Test
    public void testDemonstrateLengthComparison_YardSameReference() {
        Double first_val = 1.0;
        Length.LengthUnit yards = Length.LengthUnit.YARDS;

        Double second_vale = first_val;
        var result = demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS, second_vale, Length.LengthUnit.YARDS);
        assertTrue(result);
    }


    @Test
    public void testDemonstrateLengthComparison_YardWithNullComparison() {
        var result = demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS, null, null);
        assertFalse(result);
    }

    @Test
    public void testDemonstrateLengthComparison_CentimeterWithNullUnit() {
        var result = demonstrateLengthComparison(1.0, null, 33.0, Length.LengthUnit.CENTIMETRE);
        assertFalse(result);
    }

    @Test
    public void testDemonstrateLengthComparison_CentimeterSameReference() {
        Double first_val = 1.0;
        Length.LengthUnit yards = Length.LengthUnit.CENTIMETRE;

        Double second_vale = first_val;
        var result = demonstrateLengthComparison(1.0, Length.LengthUnit.CENTIMETRE, second_vale, Length.LengthUnit.CENTIMETRE);
        assertTrue(result);
    }

    @Test
    public void testDemonstrateLengthComparison_CentimeterWithNullComparison() {
        var result = demonstrateLengthComparison(1.0, Length.LengthUnit.CENTIMETRE, null, null);
        assertFalse(result);
    }


    @Test
    public void testDemonstrateLengthComparison_AllUnits_ComplexScenario() {
        assertTrue(demonstrateLengthComparison(2.0, Length.LengthUnit.YARDS, 6.0, Length.LengthUnit.FEET));
        assertTrue(demonstrateLengthComparison(6.0, Length.LengthUnit.FEET, 72.0, Length.LengthUnit.INCHES));
    }

}
