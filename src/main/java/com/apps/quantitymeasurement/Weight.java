package com.apps.quantitymeasurement;

import java.util.Objects;

public class Weight {
    private final Double value;
    private final WeightUnit unit;

    public Weight(Double value, WeightUnit unit) {
        if (Objects.isNull(value) || Objects.isNull(unit)) {
            throw new IllegalArgumentException("Null value is not allowed");
        }
        if (Double.isNaN(value)) {
            throw new IllegalArgumentException("Value must be numeric");
        }
        this.value = value;
        this.unit = unit;
    }

    public boolean compare(Weight weight) {
        if (weight == null) {
            return false;
        }
        return Double.compare(convertToBaseUnit(), weight.convertToBaseUnit()) == 0;
    }

    private Double convertToBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    public Weight convertTo(WeightUnit targetUnit) throws IllegalArgumentException {
        if (!Double.isFinite(this.value)) {
            throw new IllegalArgumentException("Value must be numeric");
        }
        if (Objects.isNull(unit) || Objects.isNull(targetUnit)) {
            throw new IllegalArgumentException("Unit should not be null");
        }

        Double sourceValue = value * unit.getConversionFactor();
        return convertFromBaseToTargetUnit(sourceValue, targetUnit);
    }

    public Weight add(Weight targetWeight) {
        if (targetWeight == null) {
            throw new IllegalArgumentException("Weight object should not be null");
        }
        if (Objects.isNull(targetWeight.unit) || Objects.isNull(this.unit)) {
            throw new IllegalArgumentException("Unit should not be null");
        }
        if (!Double.isFinite(this.value) || !Double.isFinite(targetWeight.value)) {
            throw new IllegalArgumentException("Value must be numeric");
        }
        Weight weight = new Weight(convertToBaseUnit() + targetWeight.convertToBaseUnit(), WeightUnit.GRAM);
        return weight.convertTo(this.unit);
    }

    public Weight add(Weight targetWeight, WeightUnit targetUnit) {
        if (targetWeight == null) {
            throw new IllegalArgumentException("Weight object should not be null");
        }
        if (Objects.isNull(targetUnit) || Objects.isNull(this.unit)) {
            throw new IllegalArgumentException("Unit should not be null");
        }
        if (!Double.isFinite(this.value) || !Double.isFinite(targetWeight.value)) {
            throw new IllegalArgumentException("Value must be numeric");
        }
        return addAndConvert(targetWeight, targetUnit);
    }

    private Weight addAndConvert(Weight targetWeight, WeightUnit targetUnit) {
        Weight weight = new Weight(convertToBaseUnit() + targetWeight.convertToBaseUnit(), WeightUnit.GRAM);
        return weight.convertFromBaseToTargetUnit(weight.value, targetUnit);
    }

    private Weight convertFromBaseToTargetUnit(Double weightInGram, WeightUnit targetUnit) {
        return new Weight(targetUnit.convertFromBaseUnit(weightInGram), targetUnit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight other = (Weight) o;
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
        return "Weight{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }


    public static void main(String[] args) {
        Weight w1 = new Weight(1000.0, WeightUnit.GRAM);
        System.out.println("Convert weight::" + w1.convertTo(WeightUnit.KILOGRAM));
    }
}
