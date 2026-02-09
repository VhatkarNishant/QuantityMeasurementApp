package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthUnitTest {

    @Test
    public void testLengthUnitEnum_FeetConstance() {
        assertEquals(12.0, LengthUnit.FEET.getConversionFactor());
    }

    @Test
    public void testLengthUnitEnum_InchesConstance() {
        assertEquals(1.0, LengthUnit.INCHES.getConversionFactor());
    }

    @Test
    public void testLengthUnitEnum_YardsConstance() {
        assertEquals(36.0, LengthUnit.YARDS.getConversionFactor());
    }

    @Test
    public void testLengthUnitEnum_CentimeterConstance() {
        assertEquals(0.393701, LengthUnit.CENTIMETRE.getConversionFactor());
    }

    @Test
    public void testConvertToBaseUnit_FeetToFeet() {
        assertEquals(60.0, LengthUnit.FEET.convertToBaseUnit(5.0));
    }

    @Test
    public void testConvertToBaseUnit_FeetToInches() {
        assertEquals(12.0, LengthUnit.FEET.convertToBaseUnit(1.0));
    }

    @Test
    public void testConvertToBaseUnit_InchesToFeet() {
        assertEquals(1.0, LengthUnit.INCHES.convertToBaseUnit(1.0));
    }

    @Test
    public void testConvertToBaseUnit_YardToInches() {
        assertEquals(36.0, LengthUnit.YARDS.convertToBaseUnit(1.0));
    }

    @Test
    public void testConvertToBaseUnit_CentimetersToFeet() {
        assertEquals(12.0, LengthUnit.CENTIMETRE.convertToBaseUnit(30.48));
    }

    @Test
    public void testConvertToBaseUnit_FeetToYard() {
        assertEquals(36.0, LengthUnit.FEET.convertToBaseUnit(3.0));
    }

    @Test
    public void testConvertFromBaseUnit_InchesToInches() {
        assertEquals(1.0, LengthUnit.INCHES.convertFromBaseUnit(1.0));
    }

    @Test
    public void testConvertFromBaseUnit_InchesToFeet() {
        assertEquals(1.0, LengthUnit.FEET.convertFromBaseUnit(12.0));
    }

    @Test
    public void testConvertFromBaseUnit_InchesToYards() {
        assertEquals(1.0, LengthUnit.YARDS.convertFromBaseUnit(36.0));
    }

    @Test
    public void testConvertFromBaseUnit_InchesToCentimeter() {
        assertEquals(1.0, LengthUnit.CENTIMETRE.convertFromBaseUnit(0.393701));
    }

    @Test
    public void testUnitImmutability() throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Callable<Double>> tasks = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            tasks.add(LengthUnit.INCHES::getConversionFactor);
        }

        List<Future<Double>> results = executorService.invokeAll(tasks);
        for (Future<Double> result : results) {
            assertEquals(1.0, result.get());
        }

        executorService.shutdown();
    }

}
