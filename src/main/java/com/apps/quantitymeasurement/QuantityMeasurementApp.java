package com.apps.quantitymeasurement;

public class QuantityMeasurementApp {

    public static class Feet {
        private final Double value;

        public Feet(Double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Feet other = (Feet) o;
            if (this.value == null && other.value == null) {
                return true;
            }
            if (this.value == null || other.value == null) {
                return false;
            }
            return Double.compare(this.value, other.value) == 0;
        }
    }

    public static class Inches {
        private final Double value;

        public Inches(Double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Inches other = (Inches) o;
            if (this.value == null && other.value == null) {
                return true;
            }
            if (this.value == null || other.value == null) {
                return false;
            }
            return Double.compare(this.value, other.value) == 0;
        }
    }

    public static void demonstrateFeetEquality() {
        QuantityMeasurementApp.Feet feet_first_value = new Feet(1.0d);
        QuantityMeasurementApp.Inches inches_first_value = new Inches(12.0d);
        Double convertedInchesValue = convertInchesIntoFeet(inches_first_value);

        boolean feet_result = feet_first_value.equals(new Feet(convertedInchesValue));
        System.out.println(feet_result ? "Feet ::: Equal(true)" : "Feet ::: Not-Equal(false)");
    }

    private static Double convertInchesIntoFeet(Inches inchesFirstValue) {
        return inchesFirstValue.value / 12;
    }


    public static void demonstrateInchesEquality() {
        QuantityMeasurementApp.Inches inches_first_value = new Inches(10d);
        QuantityMeasurementApp.Inches inches_second_value = new Inches(10d);

        boolean inches_result = inches_first_value.equals(inches_second_value);
        System.out.println(inches_result ? "Inches ::: Equal(true)" : "Inches :::  Not-Equal(false)");
    }

    private static void demonstrateFeetInchesComparison() {
        Length length1 = new Length(2.0, LengthUnit.FEET);
        Length length2 = new Length(24.0, LengthUnit.INCHES);
        boolean result = demonstrateLengthEquality(length1, length2);
        System.out.println(result ? "FeetUsingLengthInches ::: Equal(true)" : "FeetUsingLengthInches :::  Not-Equal(false)");
    }

    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    public static boolean demonstrateLengthComparison(Double first_value, LengthUnit first_unit,
                                                      Double second_value, LengthUnit second_unit) {
        Length length1 = new Length(first_value, first_unit);
        Length length2 = new Length(second_value, second_unit);

        return length1.equals(length2);
    }

    public static Length demonstrateLengthConversion(Double value, LengthUnit fromUnit, LengthUnit toUnit) throws IllegalArgumentException {
        Length length = new Length(value, fromUnit);
        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthConversion(Length fromLength, LengthUnit toUnit) {
        return fromLength.convertTo(toUnit);
    }

    public static Length demonstrateLengthAddition(Length length1, Length length2) {
        return length1.add(length2);
    }

    public static Length demonstrateLengthAddition(Length length1, Length length2, LengthUnit targetUnit) {
        return length1.add(length2, targetUnit);
    }

    public static boolean demonstrateWeightEquality(Weight weight1, Weight weight2) {
        return weight1.equals(weight2);
    }

    public static boolean demonstrateWeightComparison(Double first_value, WeightUnit first_unit,
                                                      Double second_value, WeightUnit second_unit) {
        Weight weight1 = new Weight(first_value, first_unit);
        Weight weight2 = new Weight(second_value, second_unit);

        return weight1.equals(weight2);
    }

    public static Weight demonstrateWeightConversion(Double value, WeightUnit fromUnit, WeightUnit toUnit) {
        Weight weight = new Weight(value, fromUnit);
        return weight.convertTo(toUnit);
    }

    public static Weight demonstrateWeightConversion(Weight weight, WeightUnit toUnit) {
        return weight.convertTo(toUnit);
    }


    public static Weight demonstrateWeightAddition(Weight weight1, Weight weight2) {
        return weight1.add(weight2);
    }

    public static Weight demonstrateWeightAddition(Weight weight1, Weight weight2, WeightUnit targetUnit) {
        return weight1.add(weight2, targetUnit);
    }


    public static void main(String[] args) {
//        demonstrateFeetEquality();
//        demonstrateInchesEquality();
//        demonstrateFeetInchesComparison();

        demonstrateLengthComparison(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES);

        System.out.println(demonstrateLengthComparison(1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES)
                ? "Equal(true)" : "Not-Equal(false)");

        System.out.println(demonstrateLengthComparison(1.0, LengthUnit.YARDS, 36.0, LengthUnit.INCHES)
                ? "Equal(true)" : "Not-Equal(false)");

        System.out.println(demonstrateLengthComparison(1.0, LengthUnit.CENTIMETRE, 0.393701, LengthUnit.INCHES)
                ? "Equal(true)" : "Not-Equal(false)");

        System.out.println(demonstrateLengthComparison(3.0, LengthUnit.FEET, 1.0, LengthUnit.YARDS)
                ? "Equal(true)" : "Not-Equal(false)");

        System.out.println(demonstrateLengthComparison(30.48, LengthUnit.CENTIMETRE, 1.0, LengthUnit.FEET)
                ? "Equal(true)" : "Not-Equal(false)");

        System.out.println("Converted val::" + demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.CENTIMETRE));
        System.out.println("Converted val::" + demonstrateLengthConversion(new Length(1.0, LengthUnit.FEET), LengthUnit.CENTIMETRE));


        System.out.println("Add:::" + demonstrateLengthAddition(new Length(1.0, LengthUnit.YARDS), new Length(3.0, LengthUnit.FEET)));

        System.out.println("AddAndConvert:::" + demonstrateLengthAddition(new Length(1.0, LengthUnit.FEET), new Length(12.0, LengthUnit.INCHES), LengthUnit.FEET));


        Weight w1 = new Weight(10.0, WeightUnit.GRAM);
        Weight w2 = new Weight(10.0, WeightUnit.GRAM);
        Weight w3 = new Weight(1000.0, WeightUnit.GRAM);
        System.out.println("Weight equality::" + demonstrateWeightEquality(w1, w2));
        System.out.println("demonstrateWeightComparison::" + demonstrateWeightComparison(10.0, WeightUnit.GRAM, 10.0, WeightUnit.GRAM));
        System.out.println("demonstrateWeightConversion::" + demonstrateWeightConversion(w3, WeightUnit.KILOGRAM));
        System.out.println("demonstrateWeightAddition::" + demonstrateWeightAddition(new Weight(10.0, WeightUnit.KILOGRAM), w3));
        System.out.println("demonstrateWeightAddition::" + demonstrateWeightAddition(w3, w3, WeightUnit.KILOGRAM));


    }
}
