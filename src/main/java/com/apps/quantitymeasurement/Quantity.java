package com.apps.quantitymeasurement;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private final Double value;
    private final U unit;

    public Quantity(Double value, U unit) {
        if (Objects.isNull(value) || Objects.isNull(unit)) {
            throw new IllegalArgumentException("Null value is not allowed");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be numeric");
        }
        this.value = value;
        this.unit = unit;
    }

    public Double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    public <U extends IMeasurable> Quantity<U> convertTo(U targetUnit) {
        if (Objects.isNull(targetUnit)) {
            throw new IllegalArgumentException("Unit should not be null");
        }

        return new Quantity<>(targetUnit.convertFromBaseUnit(unit.convertToBaseUnit(value)), targetUnit);
    }

    public Quantity<U> add(Quantity<U> other) {
        if (other == null) {
            throw new IllegalArgumentException("Quantity object should not be null");
        }
        Double baseSumValue = unit.convertToBaseUnit(value) + other.unit.convertToBaseUnit(other.getValue());
        return new Quantity<>(unit.convertFromBaseUnit(baseSumValue), unit);
    }

    public Quantity<U> add(Quantity<U> other, U targetUnit) {
        if (other == null) {
            throw new IllegalArgumentException("Quantity object should not be null");
        }
        Double baseSumValue = unit.convertToBaseUnit(value) + other.unit.convertToBaseUnit(other.getValue());
        return new Quantity<>(targetUnit.convertFromBaseUnit(baseSumValue), targetUnit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quantity<U> quantity = (Quantity<U>) o;
        if ((this.value == null && quantity.value == null) && (this.unit == null && quantity.unit == null)) {
            return true;
        }
        if (this.value == null || quantity.value == null || this.unit == null || quantity.unit == null) {
            return false;
        }
        return this.compare(quantity);
    }

    public boolean compare(Quantity<U> targetUnit) {
        if (targetUnit == null) {
            return false;
        }
        return Double.compare(unit.convertToBaseUnit(value), targetUnit.unit.convertToBaseUnit(targetUnit.value)) == 0;
    }

    @Override
    public String toString() {
        return "Quantity{" +
                "value=" + value +
                ", unit=" + unit +
                '}';
    }

    public static void main(String[] args) {
        //For equals
        Quantity<LengthUnit> lengthUnitInFeet = new Quantity<LengthUnit>(10.0, LengthUnit.FEET);
        Quantity<LengthUnit> lengthUnitInInches = new Quantity<LengthUnit>(120.0, LengthUnit.INCHES);

        System.out.println("Equals for length..." + lengthUnitInFeet.equals(lengthUnitInInches));

        Quantity<WeightUnit> weightUnitInKilogram = new Quantity<>(1.0, WeightUnit.KILOGRAM);
        Quantity<WeightUnit> weightUnitIngram = new Quantity<>(1000.0, WeightUnit.GRAM);

        System.out.println("Equals for weight..." + weightUnitInKilogram.equals(weightUnitIngram));

        // For conversion
        System.out.println("Length in inches.." + lengthUnitInFeet.convertTo(LengthUnit.INCHES));
        System.out.println("Length in feet.." + lengthUnitInInches.convertTo(LengthUnit.FEET));

        System.out.println("Weight in KG.." + weightUnitIngram.convertTo(WeightUnit.KILOGRAM));
        System.out.println("Weight in tonne.." + weightUnitInKilogram.convertTo(WeightUnit.TONNE));

        //For Addition
        System.out.println("Length addition .." + lengthUnitInFeet.add(lengthUnitInFeet));
        System.out.println("Length addition .." + lengthUnitInInches.add(lengthUnitInInches));
        System.out.println("Length addition .." + lengthUnitInFeet.add(new Quantity<LengthUnit>(10.0, LengthUnit.YARDS)));


        System.out.println("Weight addition .." + weightUnitInKilogram.add(weightUnitInKilogram));
        System.out.println("Weight addition .." + weightUnitIngram.add(weightUnitIngram));
        System.out.println("Weight addition for pound .." + weightUnitInKilogram.add(weightUnitIngram, WeightUnit.POUND));

    }
}
