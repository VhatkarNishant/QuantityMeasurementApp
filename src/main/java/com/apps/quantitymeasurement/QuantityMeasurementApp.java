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
        Length length1 = new Length(2.0, Length.LengthUnit.FEET);
        Length length2 = new Length(24.0, Length.LengthUnit.INCHES);
        boolean result = demonstrateLengthEquality(length1, length2);
        System.out.println(result ? "FeetUsingLengthInches ::: Equal(true)" : "FeetUsingLengthInches :::  Not-Equal(false)");
    }

    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    public static boolean demonstrateLengthComparison(Double first_value, Length.LengthUnit first_unit,
                                                      Double second_value, Length.LengthUnit second_unit) {
        Length length1 = new Length(first_value, first_unit);
        Length length2 = new Length(second_value, second_unit);

        return length1.equals(length2);
    }

    public static Length demonstrateLengthConversion(Double value, Length.LengthUnit fromUnit, Length.LengthUnit toUnit) throws IllegalArgumentException {
        Length length = new Length(value, fromUnit);
        return length.convertTo(toUnit);
    }

    public static Length demonstrateLengthConversion(Length fromLength, Length.LengthUnit toUnit) {
        return fromLength.convertTo(toUnit);
    }

    public static void main(String[] args) {
//        demonstrateFeetEquality();
//        demonstrateInchesEquality();
//        demonstrateFeetInchesComparison();

        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET, 12.0, Length.LengthUnit.INCHES);

        System.out.println(demonstrateLengthComparison(1.0, Length.LengthUnit.FEET, 12.0, Length.LengthUnit.INCHES)
                ? "Equal(true)" : "Not-Equal(false)");

        System.out.println(demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS, 36.0, Length.LengthUnit.INCHES)
                ? "Equal(true)" : "Not-Equal(false)");

        System.out.println(demonstrateLengthComparison(1.0, Length.LengthUnit.CENTIMETRE, 0.393701, Length.LengthUnit.INCHES)
                ? "Equal(true)" : "Not-Equal(false)");

        System.out.println(demonstrateLengthComparison(3.0, Length.LengthUnit.FEET, 1.0, Length.LengthUnit.YARDS)
                ? "Equal(true)" : "Not-Equal(false)");

        System.out.println(demonstrateLengthComparison(30.48, Length.LengthUnit.CENTIMETRE, 1.0, Length.LengthUnit.FEET)
                ? "Equal(true)" : "Not-Equal(false)");

        System.out.println("Converted val::" + demonstrateLengthConversion(1.0, Length.LengthUnit.FEET, Length.LengthUnit.CENTIMETRE));
        System.out.println("Converted val::" + demonstrateLengthConversion(new Length(1.0, Length.LengthUnit.FEET), Length.LengthUnit.CENTIMETRE));
    }
}
