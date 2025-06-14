# cook-with-quarkus

A recipes-based demo to illustrate Quarkus 3.x features for Commit conf 2025

## Demonstrated features

* Dev mode - `recipes-api`
* Spring compatibility - `recipes-api`
* Hibernate with Panache - `recipes-api`
* Kafka (write) - `recipes-api`
* Virtual Threads - `recipes-api`
* Dev UI - `recipes-api`
* Continuous testing - `recipes-api`
* Swagger UI - `recipes-api`
* Arc (bean removal) - `recipes-api`
* Native compilation - `recipes-api`
* Deploy to OpenShift - `recipes-api`
* Kafka consumption using virtual threads - `recipes-stream`
* SSE - `recipes-stream`
* REST Client - `recipes-stream`
* Fault Tolerance - `recipes-stream`
* LLM integration - `recipes-api`

### Ejemplos de json recetas:
{
"name": "Chili con Carne",
"description": "Un plato picante y contundente de la cocina tex-mex.",
"instructions": "Dorar la carne, añadir alubias y salsa de tomate. Cocinar a fuego lento con especias.",
"ingredients": "Carne picada:500g, Alubias rojas:400g, Tomate triturado:300g, Cebolla:1 unidad, Ajo:2 dientes, Chile en polvo:1 cucharada, Comino:1 cucharadita, Sal:al gusto"
}
{
"name": "Menestra de Verduras",
"description": "Plato saludable con una mezcla de verduras cocidas.",
"instructions": "Cocer todas las verduras hasta que estén tiernas y servir con un poco de aceite de oliva.",
"ingredients": "Zanahoria:2 unidades, Judías verdes:150g, Guisantes:100g, Alcachofas:2 unidades, Patata:1 unidad, Aceite de oliva:30ml, Sal:al gusto"
}
{
"name": "Tarta de Queso",
"description": "Postre cremoso y delicioso con base de galleta.",
"instructions": "Mezclar queso crema, huevos y azúcar, verter sobre una base de galletas y hornear.",
"ingredients": "Queso crema:500g, Galletas:200g, Mantequilla:100g, Azúcar:150g, Huevo:3 unidades, Nata:200ml, Esencia de vainilla:1 cucharadita"
}
{
"name": "Lasaña",
"description": "Plato italiano con capas de pasta, carne y bechamel.",
"instructions": "Alternar capas de pasta, carne en salsa y bechamel, hornear a 180°C durante 30 minutos.",
"ingredients": "Pasta para lasaña:12 láminas, Carne picada:500g, Tomate triturado:400g, Cebolla:1 unidad, Ajo:2 dientes, Bechamel:500ml, Queso rallado:100g, Sal:al gusto"
}
{
"name": "Sopa de Cebolla",
"description": "Sopa francesa con cebolla caramelizada y queso gratinado.",
"instructions": "Cocinar lentamente la cebolla hasta caramelizar, añadir caldo y servir con pan y queso gratinado.",
"ingredients": "Cebolla:3 unidades, Caldo de carne:1 litro, Pan:4 rebanadas, Queso gruyere:100g, Mantequilla:50g, Vino blanco:100ml, Sal:al gusto"
}
{
"name": "Gazpacho",
"description": "Sopa fría española a base de tomate y verduras frescas.",
"instructions": "Triturar todos los ingredientes hasta obtener una mezcla homogénea y servir frío.",
"ingredients": "Tomate:500g, Pimiento verde:1 unidad, Pepino:1 unidad, Ajo:1 diente, Pan:50g, Aceite de oliva:30ml, Vinagre:15ml, Sal:al gusto"
}
{
"name": "Croquetas de Jamon",
"description": "Crujientes croquetas caseras con un cremoso interior de jamón.",
"instructions": "Preparar una bechamel con jamón picado, dejar enfriar, formar las croquetas, empanar y freír.",
"ingredients": "Jamón serrano:100g, Harina:100g, Mantequilla:50g, Leche:500ml, Huevo:1 unidad, Pan rallado:100g, Aceite para freír:500ml, Sal:al gusto"
}
{
"name": "Empanada Gallega",
"description": "Empanada tradicional con relleno de atún y pimientos.",
"instructions": "Preparar el relleno de atún, cebolla y pimientos. Extender la masa, rellenar y hornear a 180°C durante 40 minutos.",
"ingredients": "Masa para empanada:500g, Atún en lata:200g, Pimiento rojo:1 unidad, Pimiento verde:1 unidad, Cebolla:1 unidad, Tomate frito:100g, Aceite de oliva:30ml, Sal:al gusto"
}
{
"name": "Fabada Asturiana",
"description": "Plato contundente de la gastronomía asturiana con fabes y embutidos.",
"instructions": "Cocinar las fabes a fuego lento con el chorizo, morcilla y panceta hasta que estén tiernas.",
"ingredients": "Fabes:500g, Chorizo:2 unidades, Morcilla:1 unidad, Panceta:150g, Cebolla:1 unidad, Ajo:2 dientes, Pimentón:1 cucharadita, Sal:al gusto"
}
{
"name": "Pisto Manchego",
"description": "Guiso de verduras similar a la ratatouille francesa.",
"instructions": "Cocinar todas las verduras a fuego lento hasta que estén tiernas y el tomate reduzca.",
"ingredients": "Calabacín:1 unidad, Berenjena:1 unidad, Pimiento rojo:1 unidad, Pimiento verde:1 unidad, Cebolla:1 unidad, Tomate triturado:500g, Aceite de oliva:50ml, Sal:al gusto"
}

# Deploy to OpenShift

recipes-api:

```shell
quarkus deploy openshift --image-build -Dquarkus.openshift.route.expose=true -Dquarkus.profile=kubernetes
```

















curl -X POST -H "Content-Type: application/json" -d '{ "name": "Spaghetti Carbonara", "description": "Pasta italiana con salsa de huevo, queso y panceta.", "instructions": "Cocinar la pasta, mezclar con huevo batido, queso y panceta crujiente.", "rating": 5, "ingredients": "Spaghetti:200g, Huevo:2 unidades, Panceta:100g, Queso parmesano:50g, Pimienta negra:1 pizca" }' http://localhost:8080/recipes
curl -X POST -H "Content-Type: application/json" -d '{ "name": "Crema de Calabaza", "description": "Sopa cremosa de calabaza con un toque de jengibre.", "instructions": "Cocinar la calabaza, mezclar con caldo y triturar hasta obtener una crema suave.", "rating": 4, "ingredients": "Calabaza:500g, Cebolla:1 unidad, Caldo de verduras:500ml, Jengibre:1 cucharadita, Nata:100ml" }' http://localhost:8080/recipes
