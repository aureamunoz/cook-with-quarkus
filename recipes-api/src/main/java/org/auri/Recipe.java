package org.auri;

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

//    @Lob
    public String instructions;

    public int rating; // Puntuación de la receta (1-5, por ejemplo)

    public String ingredients; // Ej: "Harina:200g, Huevo:2, Leche:250ml"
//    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
//    public List<RecipeIngredient> ingredients;


//    Posible versión simplificada
//    @Entity
//    public class Recipe extends PanacheEntity {
//        public String name;
//        public String description;
//        public String instructions;
//        public int rating; // Puntuación (1-5)
//        public String ingredients; // Ej: "Harina:200g, Huevo:2, Leche:250ml"
//    }

}

