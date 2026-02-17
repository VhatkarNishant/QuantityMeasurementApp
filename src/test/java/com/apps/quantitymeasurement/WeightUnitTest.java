package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeightUnitTest {

    @Test
    public void testWeightUnitEnum_MILLIGRAMConstance() {
        assertEquals(0.001, WeightUnit.MILLIGRAM.getConversionFactor());
    }

    @Test
    public void testWeightUnitEnum_GRAMConstance() {
        assertEquals(1.0, WeightUnit.GRAM.getConversionFactor());
    }

    @Test
    public void testWeightUnitEnum_KILOGRAMConstance() {
        assertEquals(1000.0, WeightUnit.KILOGRAM.getConversionFactor());
    }

    @Test
    public void testWeightUnitEnum_POUNDConstance() {
        assertEquals(453.592, WeightUnit.POUND.getConversionFactor());
    }

    @Test
    public void testWeightUnitEnum_TONNEConstance() {
        assertEquals(1_000_000.0, WeightUnit.TONNE.getConversionFactor());
    }

    @Test
    public void testConvertToBaseUnit_GramToGram() {
        assertEquals(1.0, WeightUnit.GRAM.convertToBaseUnit(1.0));
    }

    @Test
    public void testConvertToBaseUnit_KgToGram() {
        assertEquals(1000, WeightUnit.KILOGRAM.convertToBaseUnit(1.0));
    }

    @Test
    public void testConvertToBaseUnit_PoundToGram() {
        assertEquals(453.59, WeightUnit.POUND.convertToBaseUnit(1.0));
    }

    @Test
    public void testConvertToBaseUnit_TonneToGram() {
        assertEquals(1e+6, WeightUnit.TONNE.convertToBaseUnit(1.0));
    }

    @Test
    public void testWeightImmutability() throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Callable<Double>> tasks = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            tasks.add(WeightUnit.GRAM::getConversionFactor);
        }

        List<Future<Double>> results = executorService.invokeAll(tasks);
        for (Future<Double> result : results) {
            assertEquals(1.0, result.get());
        }

        executorService.shutdown();
    }
}
