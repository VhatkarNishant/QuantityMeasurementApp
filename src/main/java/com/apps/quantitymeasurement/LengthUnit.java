package com.apps.quantitymeasurement;

import java.text.DecimalFormat;

public enum LengthUnit implements IMeasurable {

    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETRE(0.393701);

    private final double conversionFactor;

    LengthUnit(Double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

//    public Double getConversionFactor() {
//        return conversionFactor;
//    }

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


//    public static final String FLOATING_POINT = "#.###";
//    DecimalFormat df = new DecimalFormat(FLOATING_POINT);
//
//    public Double convertToBaseUnit(Double value) {
//        //DecimalFormat df = new DecimalFormat(FLOATING_POINT);
//        return Double.parseDouble(df.format(value * this.getConversionFactor()));
//    }
//
//
//    public Double convertFromBaseUnit(Double baseValue) {
//        //DecimalFormat df = new DecimalFormat(FLOATING_POINT);
//        return Double.parseDouble(df.format(baseValue / this.getConversionFactor()));
//    }


}
