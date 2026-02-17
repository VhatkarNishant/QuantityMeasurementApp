package com.apps.quantitymeasurement;

public interface IMeasurable {
    Double getConversionFactor();

    Double convertToBaseUnit(Double value);

    Double convertFromBaseUnit(Double baseValue);

    String getUnitName();

    public static void main(String[] args) {

    }
}
