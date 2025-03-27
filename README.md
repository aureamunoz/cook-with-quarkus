# cook-with-quarkus

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.

## Packaging and running the application

The application can be packaged using:

```shell script
./mvnw package
```

It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:

```shell script
./mvnw package -Dquarkus.package.jar.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using:

```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:

```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/cook-with-quarkus-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult <https://quarkus.io/guides/maven-tooling>.

## Related Guides

- Micrometer Registry Prometheus ([guide](https://quarkus.io/guides/micrometer)): Enable Prometheus support for Micrometer
- SmallRye OpenAPI ([guide](https://quarkus.io/guides/openapi-swaggerui)): Document your REST APIs with OpenAPI - comes with Swagger UI
- REST Jackson ([guide](https://quarkus.io/guides/rest#json-serialisation)): Jackson serialization support for Quarkus REST. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it
- Messaging - Kafka Connector ([guide](https://quarkus.io/guides/kafka-getting-started)): Connect to Kafka with Reactive Messaging
- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- Quarkus Extension for Spring Web API ([guide](https://quarkus.io/guides/spring-web)): Use Spring Web annotations to create your REST services
- SmallRye Health ([guide](https://quarkus.io/guides/smallrye-health)): Monitor service health
- Kubernetes ([guide](https://quarkus.io/guides/kubernetes)): Generate Kubernetes resources from annotations
- JDBC Driver - PostgreSQL ([guide](https://quarkus.io/guides/datasource)): Connect to the PostgreSQL database via JDBC

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

[Related Hibernate with Panache section...](https://quarkus.io/guides/hibernate-orm-panache)


### Messaging codestart

Use Quarkus Messaging

[Related Apache Kafka guide section...](https://quarkus.io/guides/kafka-reactive-getting-started)


### REST

Easily start your REST Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)

### SmallRye Health

Monitor your application's health using SmallRye Health

[Related guide section...](https://quarkus.io/guides/smallrye-health)

### Spring Web

Spring, the Quarkus way! Start your REST Web Services with a Spring Controller.

[Related guide section...](https://quarkus.io/guides/spring-web#greetingcontroller)

### Ejemplos de json recetas:

{
"name": "Pizza Margarita",
"description": "Clásica pizza italiana con tomate, mozzarella y albahaca.",
"instructions": "Extender la masa, añadir tomate y mozzarella. Hornear a 220°C por 12 minutos.",
"rating": 5,
"ingredients": "Harina:300g, Agua:200ml, Levadura:5g, Tomate:150g, Mozzarella:100g, Albahaca:5 hojas"
}

{
"name": "Ensalada César",
"description": "Ensalada fresca con lechuga, pollo y aderezo César.",
"instructions": "Mezclar lechuga, pollo, crutones y aderezo. Servir con queso rallado.",
"rating": 4,
"ingredients": "Lechuga:1 unidad, Pollo:150g, Crutones:50g, Queso parmesano:30g, Aderezo César:50ml"
}

{
"name": "Spaghetti Carbonara",
"description": "Pasta italiana con salsa de huevo, queso y panceta.",
"instructions": "Cocinar la pasta, mezclar con huevo batido, queso y panceta crujiente.",
"rating": 5,
"ingredients": "Spaghetti:200g, Huevo:2 unidades, Panceta:100g, Queso parmesano:50g, Pimienta negra:1 pizca"
}
{
"name": "Crema de Calabaza",
"description": "Sopa cremosa de calabaza con un toque de jengibre.",
"instructions": "Cocinar la calabaza, mezclar con caldo y triturar hasta obtener una crema suave.",
"rating": 4,
"ingredients": "Calabaza:500g, Cebolla:1 unidad, Caldo de verduras:500ml, Jengibre:1 cucharadita, Nata:100ml"
}
{
"name": "Pancakes",
"description": "Deliciosos pancakes esponjosos ideales para el desayuno.",
"instructions": "Mezclar harina, leche y huevo hasta obtener una masa homogénea. Cocinar en una sartén caliente hasta dorar por ambos lados.",
"rating": 5,
"ingredients": "Harina:200g, Leche:250ml, Huevo:1 unidad, Azúcar:50g, Mantequilla:30g, Polvo de hornear:5g, Sal:1 pizca"
}
{
"name": "Chili con Carne",
"description": "Un plato picante y contundente de la cocina tex-mex.",
"instructions": "Dorar la carne, añadir frijoles y salsa de tomate. Cocinar a fuego lento con especias.",
"rating": 4,
"ingredients": "Carne picada:500g, Frijoles rojos:400g, Tomate triturado:300g, Cebolla:1 unidad, Ajo:2 dientes, Chile en polvo:1 cucharada, Comino:1 cucharadita, Sal:al gusto"
}
{
"name": "Tortilla de Patata",
"description": "Clásico plato español a base de patatas y huevos.",
"instructions": "Freír las patatas con la cebolla, mezclar con huevo batido y cuajar en una sartén.",
"rating": 5,
"ingredients": "Patatas:500g, Huevos:4 unidades, Cebolla:1 unidad, Aceite de oliva:50ml, Sal:al gusto"
}
{
"name": "Albóndigas en Salsa",
"description": "Albóndigas caseras en una deliciosa salsa de tomate.",
"instructions": "Formar albóndigas con carne picada, cocinarlas y añadir salsa de tomate.",
"rating": 4,
"ingredients": "Carne picada:500g, Pan rallado:50g, Huevo:1 unidad, Leche:50ml, Ajo:1 diente, Perejil:1 cucharada, Tomate triturado:400g, Cebolla:1 unidad, Sal:al gusto"
}
{
"name": "Menestra de Verduras",
"description": "Plato saludable con una mezcla de verduras cocidas.",
"instructions": "Cocer todas las verduras hasta que estén tiernas y servir con un poco de aceite de oliva.",
"rating": 4,
"ingredients": "Zanahoria:2 unidades, Judías verdes:150g, Guisantes:100g, Alcachofas:2 unidades, Patata:1 unidad, Aceite de oliva:30ml, Sal:al gusto"
}
{
"name": "Tarta de Queso",
"description": "Postre cremoso y delicioso con base de galleta.",
"instructions": "Mezclar queso crema, huevos y azúcar, verter sobre una base de galletas y hornear.",
"rating": 5,
"ingredients": "Queso crema:500g, Galletas:200g, Mantequilla:100g, Azúcar:150g, Huevo:3 unidades, Nata:200ml, Esencia de vainilla:1 cucharadita"
}
{
"name": "Lasaña",
"description": "Plato italiano con capas de pasta, carne y bechamel.",
"instructions": "Alternar capas de pasta, carne en salsa y bechamel, hornear a 180°C durante 30 minutos.",
"rating": 5,
"ingredients": "Pasta para lasaña:12 láminas, Carne picada:500g, Tomate triturado:400g, Cebolla:1 unidad, Ajo:2 dientes, Bechamel:500ml, Queso rallado:100g, Sal:al gusto"
}
{
"name": "Sopa de Cebolla",
"description": "Sopa francesa con cebolla caramelizada y queso gratinado.",
"instructions": "Cocinar lentamente la cebolla hasta caramelizar, añadir caldo y servir con pan y queso gratinado.",
"rating": 4,
"ingredients": "Cebolla:3 unidades, Caldo de carne:1 litro, Pan:4 rebanadas, Queso gruyere:100g, Mantequilla:50g, Vino blanco:100ml, Sal:al gusto"
}
{
"name": "Gazpacho",
"description": "Sopa fría española a base de tomate y verduras frescas.",
"instructions": "Triturar todos los ingredientes hasta obtener una mezcla homogénea y servir frío.",
"rating": 5,
"ingredients": "Tomate:500g, Pimiento verde:1 unidad, Pepino:1 unidad, Ajo:1 diente, Pan:50g, Aceite de oliva:30ml, Vinagre:15ml, Sal:al gusto"
}
{
"name": "Croquetas de Jamón",
"description": "Crujientes croquetas caseras con un cremoso interior de jamón.",
"instructions": "Preparar una bechamel con jamón picado, dejar enfriar, formar las croquetas, empanar y freír.",
"rating": 5,
"ingredients": "Jamón serrano:100g, Harina:100g, Mantequilla:50g, Leche:500ml, Huevo:1 unidad, Pan rallado:100g, Aceite para freír:500ml, Sal:al gusto"
}
{
"name": "Empanada Gallega",
"description": "Empanada tradicional con relleno de atún y pimientos.",
"instructions": "Preparar el relleno de atún, cebolla y pimientos. Extender la masa, rellenar y hornear a 180°C durante 40 minutos.",
"rating": 4,
"ingredients": "Masa para empanada:500g, Atún en lata:200g, Pimiento rojo:1 unidad, Pimiento verde:1 unidad, Cebolla:1 unidad, Tomate frito:100g, Aceite de oliva:30ml, Sal:al gusto"
}
{
"name": "Fabada Asturiana",
"description": "Plato contundente de la gastronomía asturiana con fabes y embutidos.",
"instructions": "Cocinar las fabes a fuego lento con el chorizo, morcilla y panceta hasta que estén tiernas.",
"rating": 5,
"ingredients": "Fabes:500g, Chorizo:2 unidades, Morcilla:1 unidad, Panceta:150g, Cebolla:1 unidad, Ajo:2 dientes, Pimentón:1 cucharadita, Sal:al gusto"
}
{
"name": "Paella Valenciana",
"description": "Plato típico de Valencia con arroz, pollo, conejo y verduras.",
"instructions": "Dorar la carne, añadir verduras y arroz, cocinar con caldo hasta que esté en su punto.",
"rating": 5,
"ingredients": "Arroz:400g, Pollo:200g, Conejo:200g, Judía verde:100g, Garrofón:100g, Tomate triturado:100g, Pimentón:1 cucharadita, Caldo de pollo:1 litro, Azafrán:1 pizca, Sal:al gusto"
}
{
"name": "Pisto Manchego",
"description": "Guiso de verduras similar a la ratatouille francesa.",
"instructions": "Cocinar todas las verduras a fuego lento hasta que estén tiernas y el tomate reduzca.",
"rating": 4,
"ingredients": "Calabacín:1 unidad, Berenjena:1 unidad, Pimiento rojo:1 unidad, Pimiento verde:1 unidad, Cebolla:1 unidad, Tomate triturado:500g, Aceite de oliva:50ml, Sal:al gusto"
}
{
"name": "Flan de Huevo",
"description": "Postre clásico a base de huevo y leche con caramelo.",
"instructions": "Mezclar huevos, leche y azúcar. Verter sobre caramelo y hornear al baño maría.",
"rating": 5,
"ingredients": "Huevo:4 unidades, Leche:500ml, Azúcar:150g, Caramelo líquido:50g"
}
{
"name": "Tiramisú",
"description": "Postre italiano con capas de bizcocho de café y crema de mascarpone.",
"instructions": "Empapar los bizcochos en café, alternar capas con crema de mascarpone y espolvorear cacao.",
"rating": 5,
"ingredients": "Bizcochos de soletilla:200g, Café:200ml, Queso mascarpone:250g, Azúcar:100g, Cacao en polvo:30g, Huevo:3 unidades"
}

















curl -X POST -H "Content-Type: application/json" -d '{ "name": "Spaghetti Carbonara", "description": "Pasta italiana con salsa de huevo, queso y panceta.", "instructions": "Cocinar la pasta, mezclar con huevo batido, queso y panceta crujiente.", "rating": 5, "ingredients": "Spaghetti:200g, Huevo:2 unidades, Panceta:100g, Queso parmesano:50g, Pimienta negra:1 pizca" }' http://localhost:8080/recipes
curl -X POST -H "Content-Type: application/json" -d '{ "name": "Crema de Calabaza", "description": "Sopa cremosa de calabaza con un toque de jengibre.", "instructions": "Cocinar la calabaza, mezclar con caldo y triturar hasta obtener una crema suave.", "rating": 4, "ingredients": "Calabaza:500g, Cebolla:1 unidad, Caldo de verduras:500ml, Jengibre:1 cucharadita, Nata:100ml" }' http://localhost:8080/recipes
