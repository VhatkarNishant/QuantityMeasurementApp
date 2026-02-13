package com.apps.quantitymeasurement;


import org.junit.jupiter.api.Test;

import static com.apps.quantitymeasurement.QuantityMeasurementApp.*;
import static com.apps.quantitymeasurement.QuantityMeasurementApp.demonstrateLengthAddition;
import static com.apps.quantitymeasurement.QuantityMeasurementApp.demonstrateWeightAddition;
import static com.apps.quantitymeasurement.QuantityMeasurementApp.demonstrateWeightEquality;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


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
        Length length1 = new Length(2.0, LengthUnit.FEET);
        Length length2 = new Length(2.0, LengthUnit.FEET);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
    }

    @Test
    public void testEquality_InchesToInches_SameValue() {
        Length length1 = new Length(2.0, LengthUnit.INCHES);
        Length length2 = new Length(2.0, LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
    }

    @Test
    public void testEquality_InchesToFeet_EquivalentValue() {
        Length length1 = new Length(12.0, LengthUnit.INCHES);
        Length length2 = new Length(12.0, LengthUnit.FEET);
        assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
    }

    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        Length length1 = new Length(12.0, LengthUnit.FEET);
        Length length2 = new Length(2.0, LengthUnit.FEET);
        assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
    }

    @Test
    public void testEquality_InchesToInches_DifferentValue() {
        Length length1 = new Length(12.0, LengthUnit.INCHES);
        Length length2 = new Length(2.0, LengthUnit.INCHES);
        assertFalse(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
    }

    @Test
    public void testEquality_InvalidUnits() {
        Length length1 = new Length(12.0, LengthUnit.INCHES);
        assertThrows(Exception.class, () -> QuantityMeasurementApp.demonstrateLengthEquality(length1, (Length) new Object()));
    }

    @Test
    public void testEquality_SameReference() {
        Length length1 = new Length(12.0, LengthUnit.INCHES);
        Length length2 = length1;
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(length1, length2));
    }


    @Test
    public void testDemonstrateLengthComparison_YardToYard_SameValue() {
        var result = demonstrateLengthComparison(1.0, LengthUnit.YARDS, 1.0, LengthUnit.YARDS);
        assertTrue(result);
    }

    @Test
    public void testDemonstrateLengthComparison_YardToYard_DifferentValue() {
        var result = demonstrateLengthComparison(2.0, LengthUnit.YARDS, 1.0, LengthUnit.YARDS);
        assertFalse(result);
    }

    @Test
    public void testDemonstrateLengthComparison_YardToFeet_SameValue() {
        var result = demonstrateLengthComparison(1.0, LengthUnit.YARDS, 3.0, LengthUnit.FEET);
        assertTrue(result);
    }

    @Test
    public void testDemonstrateLengthComparison_FeetToYard_SameValue() {
        var result = demonstrateLengthComparison(3.0, LengthUnit.FEET, 1.0, LengthUnit.YARDS);
        assertTrue(result);
    }

    @Test
    public void testDemonstrateLengthComparison_YardToInches_SameValue() {
        var result = demonstrateLengthComparison(1.0, LengthUnit.YARDS, 36.0, LengthUnit.INCHES);
        assertTrue(result);
    }

    @Test
    public void testDemonstrateLengthComparison_InchesToYard_SameValue() {
        var result = demonstrateLengthComparison(36.0, LengthUnit.INCHES, 1.0, LengthUnit.YARDS);
        assertTrue(result);
    }

    @Test
    public void testDemonstrateLengthComparison_YardToFeet_DifferentValue() {
        var result = demonstrateLengthComparison(1.0, LengthUnit.YARDS, 33.0, LengthUnit.FEET);
        assertFalse(result);
    }

    @Test
    public void testDemonstrateLengthComparison_CentimetersToInches_SameValue() {
        var result = demonstrateLengthComparison(1.0, LengthUnit.CENTIMETRE, 0.393701, LengthUnit.INCHES);
        assertTrue(result);
    }

    @Test
    public void testDemonstrateLengthComparison_CentimetersToFeet_DifferentSameValue() {
        var result = demonstrateLengthComparison(1.0, LengthUnit.CENTIMETRE, 1.0, LengthUnit.FEET);
        assertFalse(result);
    }


    @Test
    public void testDemonstrateLengthComparison_MultiUnit_TransitiveProperty() {
        assertAll(
                () -> assertTrue(demonstrateLengthComparison(1.0, LengthUnit.YARDS, 3.0, LengthUnit.FEET)),
                () -> assertTrue(demonstrateLengthComparison(3.0, LengthUnit.FEET, 36.0, LengthUnit.INCHES)),
                () -> assertTrue(demonstrateLengthComparison(1.0, LengthUnit.YARDS, 36.0, LengthUnit.INCHES))
        );
    }

    @Test
    public void testDemonstrateLengthComparison_YardSameReference() {
        Double first_val = 1.0;
        LengthUnit yards = LengthUnit.YARDS;

        Double second_vale = first_val;
        var result = demonstrateLengthComparison(1.0, LengthUnit.YARDS, second_vale, LengthUnit.YARDS);
        assertTrue(result);
    }

    @Test
    public void testDemonstrateLengthComparison_CentimeterSameReference() {
        Double first_val = 1.0;
        LengthUnit yards = LengthUnit.CENTIMETRE;

        Double second_vale = first_val;
        var result = demonstrateLengthComparison(1.0, LengthUnit.CENTIMETRE, second_vale, LengthUnit.CENTIMETRE);
        assertTrue(result);
    }


    @Test
    public void testDemonstrateLengthComparison_AllUnits_ComplexScenario() {
        assertTrue(demonstrateLengthComparison(2.0, LengthUnit.YARDS, 6.0, LengthUnit.FEET));
        assertTrue(demonstrateLengthComparison(6.0, LengthUnit.FEET, 72.0, LengthUnit.INCHES));
    }

    @Test
    public void testDemonstrateLengthConversion_FeetToInches() {
        assertEquals(new Length(12.0, LengthUnit.INCHES), demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES));
    }

    @Test
    public void testDemonstrateLengthConversion_InchesToFeet() {
        assertEquals(new Length(2.0, LengthUnit.FEET), demonstrateLengthConversion(24.0, LengthUnit.INCHES, LengthUnit.FEET));
    }

    @Test
    public void testDemonstrateLengthConversion_YardsToInches() {
        assertEquals(new Length(36.0, LengthUnit.INCHES), demonstrateLengthConversion(1.0, LengthUnit.YARDS, LengthUnit.INCHES));
    }

    @Test
    public void testDemonstrateLengthConversion_InchesToYards() {
        assertEquals(new Length(2.0, LengthUnit.YARDS), demonstrateLengthConversion(72.0, LengthUnit.INCHES, LengthUnit.YARDS));
    }

    @Test
    public void testDemonstrateLengthConversion_CentimetersToInches() {
        assertEquals(new Length(1.0, LengthUnit.INCHES), demonstrateLengthConversion(2.54, LengthUnit.CENTIMETRE, LengthUnit.INCHES));
    }

    @Test
    public void testDemonstrateLengthConversion_FeedToYards() {
        assertEquals(new Length(2.0, LengthUnit.YARDS), demonstrateLengthConversion(6.0, LengthUnit.FEET, LengthUnit.YARDS));
    }

    @Test
    public void testDemonstrateLengthConversion_RoundTrip_PreservesValue() {
        Length length = new Length(6.0, LengthUnit.FEET);
        Length v = length.convertTo(LengthUnit.YARDS);
        assertEquals(length, demonstrateLengthConversion(v, LengthUnit.YARDS));
    }

    @Test
    public void testDemonstrateLengthConversion_Zero_Value() {
        assertEquals(new Length(0.0, LengthUnit.INCHES), demonstrateLengthConversion(0.0, LengthUnit.FEET, LengthUnit.INCHES));
    }

    @Test
    public void testDemonstrateLengthConversion_NegativeValue() {
        assertEquals(new Length(-12.0, LengthUnit.INCHES), demonstrateLengthConversion(-1.0, LengthUnit.FEET, LengthUnit.INCHES));
    }

    @Test
    public void testDemonstrateLengthConversion_Invalid_Throw() {
        assertThrows(IllegalArgumentException.class, () -> demonstrateLengthConversion(-1.0, null, LengthUnit.INCHES));
    }

    @Test
    public void testDemonstrateLengthConversion_NaN_Throw() {
        assertThrows(IllegalArgumentException.class, () -> demonstrateLengthConversion(Double.NaN, LengthUnit.FEET, LengthUnit.INCHES));
    }

    @Test
    public void testDemonstrateLengthConversion_PrecisionTolerance() {
        assertEquals(new Length(2.54e-6, LengthUnit.CENTIMETRE), demonstrateLengthConversion(0.000001, LengthUnit.INCHES, LengthUnit.CENTIMETRE));
    }

    @Test
    public void testDemonstrateLengthAddition_SameUnit_FeetPlusFeet() {
        assertEquals(new Length(3.0, LengthUnit.FEET), demonstrateLengthAddition(new Length(1.0, LengthUnit.FEET), new Length(2.0, LengthUnit.FEET)));
    }

    @Test
    public void testDemonstrateLengthAddition_SameUnit_InchPlusInch() {
        assertEquals(new Length(12.0, LengthUnit.INCHES), demonstrateLengthAddition(new Length(6.0, LengthUnit.INCHES), new Length(6.0, LengthUnit.INCHES)));
    }

    @Test
    public void testDemonstrateLengthAddition_CrossUnit_FeetPlusInches() {
        assertEquals(new Length(2.0, LengthUnit.FEET), demonstrateLengthAddition(new Length(1.0, LengthUnit.FEET), new Length(12.0, LengthUnit.INCHES)));
    }

    @Test
    public void testDemonstrateLengthAddition_CrossUnit_InchesPlusFeet() {
        assertEquals(new Length(24.0, LengthUnit.INCHES), demonstrateLengthAddition(new Length(12.0, LengthUnit.INCHES), new Length(1.0, LengthUnit.FEET)));
    }

    @Test
    public void testDemonstrateLengthAddition_CrossUnit_YardPlusFeet() {
        assertEquals(new Length(2.0, LengthUnit.YARDS), demonstrateLengthAddition(new Length(1.0, LengthUnit.YARDS), new Length(3.0, LengthUnit.FEET)));
    }

    @Test
    public void testDemonstrateLengthAddition_CrossUnit_CentimeterPlusInches() {
        assertEquals(new Length(5.08, LengthUnit.CENTIMETRE), demonstrateLengthAddition(new Length(2.54, LengthUnit.CENTIMETRE), new Length(1.0, LengthUnit.INCHES)));
    }

    @Test
    public void testDemonstrateLengthAddition_Commutativity() {
        Length length1 = new Length(1.0, LengthUnit.FEET);
        Length length2 = new Length(12.0, LengthUnit.INCHES);
        assertEquals(demonstrateLengthAddition(length1, length2), demonstrateLengthAddition(length2, length1));
    }

    @Test
    public void testDemonstrateLengthAddition_WithZero() {
        assertEquals(new Length(5.0, LengthUnit.FEET), demonstrateLengthAddition(new Length(5.0, LengthUnit.FEET), new Length(0.0, LengthUnit.INCHES)));
    }

    @Test
    public void testDemonstrateLengthAddition_NegativeValues() {
        assertEquals(new Length(3.0, LengthUnit.FEET), demonstrateLengthAddition(new Length(5.0, LengthUnit.FEET), new Length(-2.0, LengthUnit.FEET)));
    }

    @Test
    public void testDemonstrateLengthAddition_NullSecondOperand() {
        assertThrows(IllegalArgumentException.class, () -> demonstrateLengthAddition(new Length(3.0, LengthUnit.FEET), null));
    }

    @Test
    public void testDemonstrateLengthAddition_LargeValues() {
        assertEquals(new Length(2e6, LengthUnit.FEET), demonstrateLengthAddition(new Length(1e6, LengthUnit.FEET), new Length(1e6, LengthUnit.FEET)));
    }

    @Test
    public void testDemonstrateLengthAddition_SmallValues() {
        assertEquals(new Length(0.003, LengthUnit.FEET), demonstrateLengthAddition(new Length(0.001, LengthUnit.FEET), new Length(0.002, LengthUnit.FEET)));
    }

    @Test
    public void testDemonstrateLengthAddition_ExplicitTargetUnit_Feet() {
        assertEquals(new Length(2.0, LengthUnit.FEET),
                demonstrateLengthAddition(new Length(1.0, LengthUnit.FEET),
                        new Length(12.0, LengthUnit.INCHES), LengthUnit.FEET));
    }

    @Test
    public void testDemonstrateLengthAddition_ExplicitTargetUnit_Inches() {
        assertEquals(new Length(24.0, LengthUnit.INCHES), demonstrateLengthAddition(new Length(1.0, LengthUnit.FEET), new Length(12.0, LengthUnit.INCHES), LengthUnit.INCHES));
    }

    @Test
    public void testDemonstrateLengthAddition_ExplicitTargetUnit_Yards() {
        assertEquals(new Length(0.67, LengthUnit.YARDS), demonstrateLengthAddition(new Length(1.0, LengthUnit.FEET), new Length(12.0, LengthUnit.INCHES), LengthUnit.YARDS));
    }

    @Test
    public void testDemonstrateLengthAddition_ExplicitTargetUnit_Centimeters() {
        assertEquals(new Length(5.08, LengthUnit.CENTIMETRE), demonstrateLengthAddition(new Length(1.0, LengthUnit.INCHES), new Length(1.0, LengthUnit.INCHES), LengthUnit.CENTIMETRE));
    }

    @Test
    public void testDemonstrateLengthAddition_ExplicitTargetUnit_SameAsFirstOperand() {
        assertEquals(new Length(3.0, LengthUnit.YARDS), demonstrateLengthAddition(new Length(2.0, LengthUnit.YARDS), new Length(3.0, LengthUnit.FEET), LengthUnit.YARDS));
    }

    @Test
    public void testDemonstrateLengthAddition_ExplicitTargetUnit_SameAsSecondOperand() {
        assertEquals(new Length(9.0, LengthUnit.FEET), demonstrateLengthAddition(new Length(2.0, LengthUnit.YARDS), new Length(3.0, LengthUnit.FEET), LengthUnit.FEET));
    }

    @Test
    public void testDemonstrateLengthAddition_ExplicitTargetUnit_Commutativity() {
        Length length1 = demonstrateLengthAddition(new Length(1.0, LengthUnit.FEET), new Length(12.0, LengthUnit.INCHES), LengthUnit.YARDS);
        Length length2 = demonstrateLengthAddition(new Length(12.0, LengthUnit.INCHES), new Length(1.0, LengthUnit.FEET), LengthUnit.YARDS);
        assertEquals(length1, length2);
    }

    @Test
    public void testDemonstrateLengthAddition_ExplicitTargetUnit_WithZero() {
        assertEquals(new Length(1.67, LengthUnit.YARDS), demonstrateLengthAddition(new Length(5.0, LengthUnit.FEET), new Length(0.0, LengthUnit.INCHES), LengthUnit.YARDS));
    }

    @Test
    public void testDemonstrateLengthAddition_ExplicitTargetUnit_NegativeValues() {
        assertEquals(new Length(36.0, LengthUnit.INCHES), demonstrateLengthAddition(new Length(5.0, LengthUnit.FEET), new Length(-2.0, LengthUnit.FEET), LengthUnit.INCHES));
    }

    @Test
    public void testDemonstrateLengthAddition_ExplicitTargetUnit_NullTargetUnit() {
        assertThrows(IllegalArgumentException.class, () -> demonstrateLengthAddition(new Length(1.0, LengthUnit.FEET), new Length(12.0, LengthUnit.INCHES), null));
    }

    @Test
    public void testDemonstrateLengthAddition_ExplicitTargetUnit_LargeToSmallScale() {
        assertEquals(new Length(18000.0, LengthUnit.INCHES), demonstrateLengthAddition(new Length(1000.0, LengthUnit.FEET), new Length(500.0, LengthUnit.FEET), LengthUnit.INCHES));
    }

    @Test
    public void testDemonstrateLengthAddition_ExplicitTargetUnit_SmallToLargeScale() {
        assertEquals(new Length(0.67, LengthUnit.YARDS), demonstrateLengthAddition(new Length(12.0, LengthUnit.INCHES), new Length(12.0, LengthUnit.INCHES), LengthUnit.YARDS));
    }

    @Test
    public void testDemonstrateLengthAddition_ExplicitTargetUnit_AllUnitCombinations() {
        assertEquals(new Length(1.34, LengthUnit.YARDS),
                demonstrateLengthAddition(demonstrateLengthAddition(new Length(12.0, LengthUnit.INCHES),
                        new Length(12.0, LengthUnit.INCHES),
                        LengthUnit.YARDS), demonstrateLengthAddition(new Length(12.0, LengthUnit.INCHES),
                        new Length(12.0, LengthUnit.INCHES), LengthUnit.YARDS), LengthUnit.YARDS));
    }

    @Test
    public void testEquality_KilogramToKilogram_SameValue() {
        assertTrue(demonstrateWeightEquality(new Weight(1.0, WeightUnit.KILOGRAM), new Weight(1.0, WeightUnit.KILOGRAM)));
    }

    @Test
    public void testEquality_KilogramToKilogram_DifferentValue() {
        assertFalse(demonstrateWeightEquality(new Weight(1.0, WeightUnit.KILOGRAM), new Weight(10.0, WeightUnit.KILOGRAM)));
    }

    @Test
    public void testEquality_KilogramToGram_EquivalentValue() {
        assertTrue(demonstrateWeightEquality(new Weight(1.0, WeightUnit.KILOGRAM), new Weight(1000.0, WeightUnit.GRAM)));
    }

    @Test
    public void testEquality_GramToKilogram_EquivalentValue() {
        assertTrue(demonstrateWeightEquality(new Weight(1000.0, WeightUnit.GRAM), new Weight(1.0, WeightUnit.KILOGRAM)));
    }

    @Test
    public void testEquality_WeightVSLength_Incompatible() {
        assertFalse(new Weight(1000.0, WeightUnit.GRAM).equals(new Length(10.0, LengthUnit.FEET)));
    }

    @Test
    public void testEquality_NullComparison() {
        assertFalse(demonstrateWeightEquality(new Weight(1000.0, WeightUnit.GRAM), null));
    }

    @Test
    public void testEquality_SameReference_ForWeight() {
        Weight w1 = new Weight(1000.0, WeightUnit.GRAM);
        Weight w2 = w1;
        assertTrue(demonstrateWeightEquality(w1, w2));
    }

    @Test
    public void testEquality_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> new Weight(10.0, null));
    }

    @Test
    public void testEquality_TransitivityProperty() {
        Weight w1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000.0, WeightUnit.GRAM);

        assertAll(
                () -> assertTrue(demonstrateWeightEquality(w1, w2)),
                () -> assertTrue(demonstrateWeightEquality(w1, w2)),
                () -> assertTrue(demonstrateWeightEquality(w1, new Weight(1.0, WeightUnit.KILOGRAM)))
        );
    }


    @Test
    public void testEquality_ZeroValue() {
        assertTrue(demonstrateWeightEquality(new Weight(0.0, WeightUnit.GRAM), new Weight(0.0, WeightUnit.KILOGRAM)));
    }

    @Test
    public void testEquality_NegativeWeight() {
        assertTrue(demonstrateWeightEquality(new Weight(-1.0, WeightUnit.KILOGRAM), new Weight(-1000.0, WeightUnit.GRAM)));
    }

    @Test
    public void testEquality_LargeWeightValue() {
        assertTrue(demonstrateWeightEquality(new Weight(1000000.0, WeightUnit.GRAM), new Weight(1000.0, WeightUnit.KILOGRAM)));
    }

    @Test
    public void testEquality_SmallWeightValue() {
        assertTrue(demonstrateWeightEquality(new Weight(0.001, WeightUnit.KILOGRAM), new Weight(1.0, WeightUnit.GRAM)));
    }


    @Test
    public void testConversion_PoundToKilogram() {
        assertEquals(new Weight(1.0, WeightUnit.KILOGRAM), demonstrateWeightConversion(2.20462, WeightUnit.POUND, WeightUnit.KILOGRAM));
    }

    @Test
    public void testConversion_KilogramToPound() {
        assertEquals(new Weight(2.2, WeightUnit.POUND), demonstrateWeightConversion(1.0, WeightUnit.KILOGRAM, WeightUnit.POUND));
    }


    @Test
    public void testConversion_SameUnit() {
        assertEquals(new Weight(1.0, WeightUnit.KILOGRAM), demonstrateWeightConversion(1.0, WeightUnit.KILOGRAM, WeightUnit.KILOGRAM));
    }

    @Test
    public void testConversion_ZeroValue() {
        assertEquals(new Weight(0.0, WeightUnit.KILOGRAM), demonstrateWeightConversion(0.0, WeightUnit.KILOGRAM, WeightUnit.KILOGRAM));
    }

    @Test
    public void testConversion_NegativeValue() {
        assertEquals(new Weight(-1000.0, WeightUnit.GRAM), demonstrateWeightConversion(-1.0, WeightUnit.KILOGRAM, WeightUnit.GRAM));
    }

    @Test
    public void testConversion_RoundTrip() {
        assertEquals(new Weight(1.5, WeightUnit.KILOGRAM), demonstrateWeightConversion(1.5, WeightUnit.KILOGRAM, WeightUnit.GRAM).convertTo(WeightUnit.KILOGRAM));
    }

    @Test
    public void testAddition_SameUnit_KilogramPlusKilogram() {
        assertEquals(new Weight(3.0, WeightUnit.KILOGRAM), demonstrateWeightAddition(new Weight(1.0, WeightUnit.KILOGRAM), new Weight(2.0, WeightUnit.KILOGRAM)));
    }

    @Test
    public void testAddition_CrossUnit_KilogramPlusGram() {
        assertEquals(new Weight(2.0, WeightUnit.KILOGRAM), demonstrateWeightAddition(new Weight(1.0, WeightUnit.KILOGRAM), new Weight(1000.0, WeightUnit.GRAM)));
    }

    @Test
    public void testAddition_CrossUnit_PoundPlusKilogram() {
        assertEquals(new Weight(4.41, WeightUnit.POUND), demonstrateWeightAddition(new Weight(2.20462, WeightUnit.POUND), new Weight(1.0, WeightUnit.KILOGRAM)));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Kilogram() {
        assertEquals(new Weight(2000.0, WeightUnit.GRAM), demonstrateWeightAddition(new Weight(1.0, WeightUnit.KILOGRAM), new Weight(1000.0, WeightUnit.GRAM), WeightUnit.GRAM));
    }

    @Test
    public void testAddition_Commutativity() {
        Weight w1 = new Weight(1.0, WeightUnit.KILOGRAM);
        Weight w2 = new Weight(1000.0, WeightUnit.GRAM);
        assertEquals(demonstrateWeightAddition(w1, w2), demonstrateWeightAddition(w2, w1));
    }

    @Test
    public void testAddition_WithZero() {
        assertEquals(new Weight(2.0, WeightUnit.KILOGRAM), demonstrateWeightAddition(new Weight(2.0, WeightUnit.KILOGRAM), new Weight(0.0, WeightUnit.GRAM), WeightUnit.KILOGRAM));
    }


    @Test
    public void testAddition_NegativeValues() {
        assertEquals(new Weight(3.0, WeightUnit.KILOGRAM), demonstrateWeightAddition(new Weight(5.0, WeightUnit.KILOGRAM), new Weight(-2000.0, WeightUnit.GRAM), WeightUnit.KILOGRAM));
    }

    @Test
    public void testAddition_LargeValues() {
        assertEquals(new Weight(2e6, WeightUnit.KILOGRAM), demonstrateWeightAddition(new Weight(1e6, WeightUnit.KILOGRAM), new Weight(1e6, WeightUnit.KILOGRAM)));
    }
}
