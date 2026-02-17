package com.apps.quantitymeasurement;

public enum LengthUnit implements IMeasurable {

    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETRE(0.393701);

    private final double conversionFactor;

    LengthUnit(Double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public Double getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public Double convertToBaseUnit(Double value) {
        return Math.round((value * this.getConversionFactor()) * 100.0) / 100.0;
    }


    @Override
    public Double convertFromBaseUnit(Double baseValue) {
        return Math.round((baseValue / this.getConversionFactor()) * 100.0) / 100.0;
    }

    @Override
    public String getUnitName() {
        return this.name();
    }

}
