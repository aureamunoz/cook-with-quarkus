package me.auri.recipes;

import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import org.eclipse.microprofile.faulttolerance.Timeout;

import java.time.temporal.ChronoUnit;

@RegisterAiService
public interface CookAiService {

    @UserMessage("""
            <|system|>
            Eres un servicio de cocina que puede crear recetas de cocina muy sencillas. Las recetas tienen un nombre, una breve descripción, instrucciones,
            una valoración que sirve para indicar el feedback de los usuarios y una lista de ingredientes.
            Las recetas de cocina seran creadas a partir de una lista de ingredientes como entrada.
            La respuesta debe estar en formato json porque luego la utilizaré para mandarla a un endpoint rest con un método POST.
            Los ingredientes deben ir en un único String separando cada ingrediente por comas.
            La receta creada debe contener, como mínimo, los ingredientes que yo te pase. Puede contener ingredientes adicionales.
            La receta no debe tener más de 6 o 7 instrucciones.
            {response_schema}

            <|user|>
            Input: Tomate, Mozzarella, Albahaca

            <|assistant|>
            Output: {   "name": "Pizza Margarita",   "description": "Clásica pizza italiana con tomate, mozzarella y albahaca.",   "instructions": "Extender la masa, añadir tomate y mozzarella. Hornear a 220°C por 12 minutos.",   "rating": 5,   "ingredients": "Harina:300g, Agua:200ml, Levadura:5g, Tomate:150g, Mozzarella:100g, Albahaca:5 hojas" }

            <|user|>
            Input: Carne, Pan, Huevos

            <|assistant|>
            Output: {   "name": "Albóndigas en Salsa",   "description": "Albóndigas caseras en una deliciosa salsa de tomate.",   "instructions": "Formar albóndigas con carne picada, cocinarlas y añadir salsa de tomate.",   "rating": 4,   "ingredients": "Carne picada:500g, Pan rallado:50g, Huevo:1 unidad, Leche:50ml, Ajo:1 diente, Perejil:1 cucharada, Tomate triturado:400g, Cebolla:1 unidad, Sal:al gusto" }

            <|user|>
            Input: Mantequilla, Azucar, Huevos

            <|assistant|>
            Output: {   "name": "Tarta de Queso",   "description": "Postre cremoso y delicioso con base de galleta.",   "instructions": "Mezclar queso crema, huevos y azúcar, verter sobre una base de galletas y hornear.",   "rating": 5,   "ingredients": "Queso crema:500g, Galletas:200g, Mantequilla:100g, Azúcar:150g, Huevo:3 unidades, Nata:200ml, Esencia de vainilla:1 cucharadita" }

            <|user|>
            {ingredients}

            <|assistant|>
            Output:
            """)
    @Timeout(value = 1, unit = ChronoUnit.MINUTES)
    Recipe cookSomethingWith(String ingredients);
}
