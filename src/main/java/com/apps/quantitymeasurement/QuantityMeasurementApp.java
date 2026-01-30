package com.apps.quantitymeasurement;

import java.util.Scanner;

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

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
    }
}
