package com.samlikescode.dogfood;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class DogFoodCalculator {

    public NutritionFacts calculateTotalNutrients(ImmutableMap<Double, NutritionFacts> quantityToNutritionFactsMap) {
        NutritionFacts.Builder resultBuilder = NutritionFacts.builder();
        for (Map.Entry<Double, NutritionFacts> entry : quantityToNutritionFactsMap.entrySet()) {
            double protein = resultBuilder.getProtein().getQuantity() + (entry.getKey() * entry.getValue().getProtein().getQuantity());
            double carb = resultBuilder.getCarbohydrate().getQuantity() + (entry.getKey() * entry.getValue().getCarbohydrate().getQuantity());
            double fat = resultBuilder.getFat().getQuantity() + (entry.getKey() * entry.getValue().getFat().getQuantity());
            double calorie = resultBuilder.getCalories() + (entry.getKey() * entry.getValue().getCalories());
            resultBuilder.setProtein(protein)
                    .setCarbohydrate(carb)
                    .setFat(fat)
                    .setCalories(calorie);
        }

        NutritionFacts results = resultBuilder.build();

        double finalProtein = results.getProtein().getQuantity();
        double finalCarb = results.getCarbohydrate().getQuantity();
        double finalFat = results.getFat().getQuantity();
        Double finalCalories = results.getCalories();

        System.out.println("Protein: " + finalProtein);
        System.out.println("Carbs: " + finalCarb);
        System.out.println("Fat: " + finalFat);
        System.out.println("Calories: " + finalCalories);

        System.out.println("# of Meals: " + finalCalories / 60);
        System.out.println("# of Days Of Food: " + finalCalories / 180);

        double finalProteinCalories = finalProtein * 4;
        double finalCarbCalories = finalCarb * 4;
        double finalFatCalories = finalFat * 9;
        Double totalCaloriesFromMacros = finalProteinCalories + finalCarbCalories + finalFatCalories;

        System.out.println("Total Macro Calories: " + totalCaloriesFromMacros);
        System.out.println("% Protein: " + finalProteinCalories / totalCaloriesFromMacros * 100);
        System.out.println("% Carbs: " + finalCarbCalories / totalCaloriesFromMacros * 100);
        System.out.println("% Fat: " + finalFatCalories / totalCaloriesFromMacros * 100);


        return results;
    }
}
