package com.apps.quantitymeasurement;

import java.text.DecimalFormat;
import java.util.Objects;

public class Length {
    public static final String FLOATING_POINT = "#.###";
    private Double value;
    private LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETRE(0.393701);

        private final double conversionFactor;

        LengthUnit(Double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public Double getConversionFactor() {
            return conversionFactor;
        }
    }

    public Length(Double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    private Double convertToBaseUnit() {
        DecimalFormat df = new DecimalFormat(FLOATING_POINT);
        return Double.parseDouble(df.format(value * unit.getConversionFactor()));
    }

    public boolean compare(Length length) {
        if (length == null) {
            return false;
        }
        return Double.compare(convertToBaseUnit(), length.convertToBaseUnit()) == 0;
    }

    public Length convertTo(LengthUnit targetUnit) throws IllegalArgumentException {
        if (!Double.isFinite(this.value)) {
            throw new IllegalArgumentException("Value must be numeric");
        }
        if (Objects.isNull(unit) || Objects.isNull(targetUnit)) {
            throw new IllegalArgumentException("Unit should not be null");
        }
        DecimalFormat df = new DecimalFormat(FLOATING_POINT);
        Double sourceValue = value * unit.getConversionFactor();
        return new Length(Double.parseDouble(df.format(sourceValue / targetUnit.getConversionFactor())), targetUnit);
    }

    public Length add(Length targetLength) {
        if (targetLength == null) {
            throw new IllegalArgumentException("Length object should not be null");
        }

        if (!Double.isFinite(this.value) || !Double.isFinite(targetLength.value)) {
            throw new IllegalArgumentException("Value must be numeric");
        }
        Length length = new Length(convertToBaseUnit() + targetLength.convertToBaseUnit(), LengthUnit.INCHES);
        return length.convertTo(this.unit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Length other = (Length) o;
        if ((this.value == null && other.value == null) && (this.unit == null && other.unit == null)) {
            return true;
        }
        if (this.value == null || other.value == null || this.unit == null || other.unit == null) {
            return false;
        }
        return this.compare(other);
    }

    @Override
    public String toString() {
        return "Length{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }

    public static void main(String[] args) {
        Length length1 = new Length(2.0, LengthUnit.FEET);
        Length length2 = new Length(24.0, LengthUnit.INCHES);
        System.out.println("Are length equals: " + length1.equals(length2));

        Length length3 = new Length(1.0, LengthUnit.YARDS);
        Length length4 = new Length(36.0, LengthUnit.INCHES);
        System.out.println("Are length equals: " + length3.equals(length4));

        Length length5 = new Length(1.0, LengthUnit.CENTIMETRE);
        Length length6 = new Length(0.393701, LengthUnit.INCHES);
        System.out.println("Are length equals: " + length5.equals(length6));

        Length l1 = new Length(1.0, LengthUnit.FEET);
        System.out.println("Convert::==" + l1.convertTo(LengthUnit.CENTIMETRE));
        System.out.println("Convert::==" + l1.convertTo(LengthUnit.CENTIMETRE));

        Length length7 = new Length(1.0, LengthUnit.YARDS);
        Length length8 = new Length(3.0, LengthUnit.FEET);

        System.out.println("VLLLLLLLLLLLLL" + length7.add(length8));

    }
}
