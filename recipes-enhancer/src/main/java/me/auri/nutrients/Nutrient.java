package me.auri.nutrients;

import java.util.Objects;

public class Nutrient {

    private String label;
    private float quantity;
    private String unit;

    public Nutrient(String label, float quantity, String unit) {
        this.label = label;
        this.quantity = quantity;
        this.unit = unit;
    }

    public String getLabel() {
        return label;
    }

    public float getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Nutrient nutrient))
            return false;
        return Double.compare(getQuantity(), nutrient.getQuantity()) == 0
                && Objects.equals(getLabel(), nutrient.getLabel()) && Objects.equals(getUnit(), nutrient.getUnit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLabel(), getQuantity(), getUnit());
    }

    @Override
    public String toString() {
        return label + ": " + quantity + " " + unit;
    }
}
