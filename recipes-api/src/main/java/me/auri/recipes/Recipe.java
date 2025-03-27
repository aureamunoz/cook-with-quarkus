package me.auri.recipes;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Recipe extends PanacheEntity {
    public String name;
    public String description;
    public String instructions;
    public int rating;
    public String ingredients; // Ej: "Harina:200g, Huevo:2, Leche:250ml"
}

