package com.samlikescode.dogfood;

import static java.util.Objects.requireNonNull;

public class Nutrient {
    private final String displayName;
    private final double quantity;
    private final String unit;

    public Nutrient(String displayName,
                    double quantity,
                    String unit) {
        this.displayName = requireNonNull(displayName);
        this.quantity = requireNonNull(quantity);
        this.unit = requireNonNull(unit);
    }

    public static Nutrient of(String displayName,
                              double quantity,
                              String unit) {
        return new Nutrient(displayName, quantity, unit);
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }
}
