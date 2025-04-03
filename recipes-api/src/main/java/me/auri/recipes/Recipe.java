package me.auri.recipes;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Recipe extends PanacheEntity {
    public String name;
    public String description;
    public String instructions;
    public String ingredients; // Ej: "Harina:200g, Huevo:2, Leche:250ml"
}
