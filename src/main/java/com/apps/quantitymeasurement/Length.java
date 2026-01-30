package com.apps.quantitymeasurement;

public class Length {
    private Double value;
    private LengthUnit unit;

    public enum LengthUnit {
        FEET(12.0),
        INCHES(1.0);

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
        return value * unit.getConversionFactor();
    }

    public boolean compare(Length length) {
        if (length == null) {
            return false;
        }
        return Double.compare(convertToBaseUnit(), length.convertToBaseUnit()) == 0;
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

    public static void main(String[] args) {
        Length length1 = new Length(2.0, LengthUnit.FEET);
        Length length2 = new Length(24.0, LengthUnit.INCHES);
        System.out.println("Are length equals: " + length1.equals(length2));
    }
}
