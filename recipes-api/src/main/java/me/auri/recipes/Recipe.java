package me.auri.recipes;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Recipe {
    public String name;
    public String description;
    public String instructions;
    public String ingredients;
}
