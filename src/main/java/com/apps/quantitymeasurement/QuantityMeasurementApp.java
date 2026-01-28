package com.apps.quantitymeasurement;

import java.util.Objects;
import java.util.Scanner;

public class QuantityMeasurementApp {

    public static class Feet {
        private final Double value;

        public Feet(Double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Feet feet = (Feet) o;
            return Double.compare(value, feet.value) == 0;
        }

    }

    public static void main(String[] args) {

        Scanner sc_first_value = new Scanner(System.in);
        System.out.println("Enter the first value:");
        String str_first_value = sc_first_value.nextLine();

        Scanner sc_second_value = new Scanner(System.in);
        System.out.println("Enter the second value:");
        String str_second_value = sc_second_value.nextLine();

        QuantityMeasurementApp.Feet feet_first_value = new Feet(Double.parseDouble(str_first_value));
        QuantityMeasurementApp.Feet feet_second_value = new Feet(Double.parseDouble(str_second_value));

        boolean result = feet_first_value.equals(feet_second_value);
        System.out.println(result ? "Equal(true)" : "Not-Equal(false)");

    }
}
