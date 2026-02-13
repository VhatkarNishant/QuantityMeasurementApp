package com.apps.quantitymeasurement;

public interface IMeasurable {
    Double getConversionFactor();

    Double convertToBaseUnit(Double value);

    Double convertFromBaseUnit(Double baseValue);

    public static void main(String[] args) {

    }
}
