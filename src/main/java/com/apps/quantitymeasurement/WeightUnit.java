package com.apps.quantitymeasurement;

public enum WeightUnit implements IMeasurable {
    MILLIGRAM(0.001),
    GRAM(1.0),
    KILOGRAM(1000.0),
    POUND(453.592),
    TONNE(1_000_000.0);

    private final Double conversionFactor;

    WeightUnit(Double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

//    public Double getConversionFactor() {
//        return conversionFactor;
//    }
//
//
//    public Double convertToBaseUnit(Double value) {
//        return value * this.getConversionFactor();
//    }
//
//    public Double convertFromBaseUnit(Double baseValue) {
//        return Math.round((baseValue / this.getConversionFactor()) * 100.00) / 100.0;
//    }

    @Override
    public Double getConversionFactor() {
        return conversionFactor;
    }

    @Override
    public Double convertToBaseUnit(Double value) {
        return Math.round((value * this.getConversionFactor()) * 100.00) / 100.0;
    }

    @Override
    public Double convertFromBaseUnit(Double baseValue) {
        return Math.round((baseValue / this.getConversionFactor()) * 100.00) / 100.0;
    }

    public static void main(String[] args) {
        Double kilogram = 10.0;
        Double gram = WeightUnit.KILOGRAM.convertToBaseUnit(kilogram);
        System.out.println(kilogram + " kilogram is " + gram + " gram. ");
    }
}
