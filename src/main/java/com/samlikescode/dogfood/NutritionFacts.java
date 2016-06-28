package com.samlikescode.dogfood;

import static java.util.Objects.requireNonNull;

public class NutritionFacts {
    private final Nutrient protein;
    private final Nutrient fat;
    private final Nutrient carbohydrate;
    private final Double calories;

    public NutritionFacts(Nutrient protein,
                          Nutrient fat,
                          Nutrient carbohydrate,
                          Double calories) {
        this.protein = requireNonNull(protein);
        this.fat = requireNonNull(fat);
        this.carbohydrate = requireNonNull(carbohydrate);
        this.calories = requireNonNull(calories);
    }

    public Nutrient getProtein() {
        return protein;
    }

    public Nutrient getFat() {
        return fat;
    }

    public Nutrient getCarbohydrate() {
        return carbohydrate;
    }

    public Double getCalories() {
        return calories;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Nutrient protein = Nutrient.of("Protein", 0, "grams");
        private Nutrient fat = Nutrient.of("Protein", 0, "grams");
        private Nutrient carbohydrate = Nutrient.of("Protein", 0, "grams");
        private Double calories = 0.0;

        public Builder setProtein(double quantity) {
            this.protein = Nutrient.of("Protein", quantity, "grams");
            return this;
        }

        public Builder setFat(double quantity) {
            this.fat = Nutrient.of("Fat", quantity, "grams");
            return this;
        }

        public Builder setCarbohydrate(double quantity) {
            this.carbohydrate = Nutrient.of("Carbohydrate", quantity, "grams");
            return this;
        }

        public Builder setCalories(double quantity) {
            this.calories = quantity;
            return this;
        }

        public Nutrient getProtein() {
            return protein;
        }

        public Nutrient getFat() {
            return fat;
        }

        public Nutrient getCarbohydrate() {
            return carbohydrate;
        }

        public Double getCalories() {
            return calories;
        }

        public NutritionFacts build() {
            return new NutritionFacts(protein,
                    fat,
                    carbohydrate,
                    calories);
        }
    }
}
