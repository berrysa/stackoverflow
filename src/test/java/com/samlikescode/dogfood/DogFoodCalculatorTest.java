package com.samlikescode.dogfood;

import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class DogFoodCalculatorTest {
    private DogFoodCalculator dogFoodCalculator;

    @Before
    public void setUp() throws Exception {
        dogFoodCalculator = new DogFoodCalculator();
    }

    @Test
    public void testCalculateTotalNutrients_protein() throws Exception {
        NutritionFacts groundBeef90to10 = NutritionFacts.builder()
                .setProtein(22)
                .setCarbohydrate(0)
                .setFat(11)
                .setCalories(200)
                .build();

        NutritionFacts eggWhite = NutritionFacts.builder()
                .setProtein(4)
                .setCarbohydrate(0)
                .setFat(0)
                .setCalories(16)
                .build();

        NutritionFacts whiteRice = NutritionFacts.builder()
                .setProtein(4)
                .setCarbohydrate(37)
                .setFat(0)
                .setCalories(169)
                .build();

        ImmutableMap<Double, NutritionFacts> input = ImmutableMap.<Double, NutritionFacts>builder()
                .put(4.32, groundBeef90to10)
                .put(15.0, eggWhite)
                .put(4.0, whiteRice)
                .build();

        NutritionFacts total = dogFoodCalculator.calculateTotalNutrients(input);

        assertEquals(total.getProtein().getQuantity(), 171.04, 0.001);
        assertEquals(total.getCarbohydrate().getQuantity(), 148, 0.001);
        assertEquals(total.getFat().getQuantity(), 47.52, 0.001);
        assertEquals(total.getCalories(), 1780, 0.001);
    }

    @Test
    public void testTest() throws Exception {
        new File("/hostname/username");
    }
}
