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

curl -X POST -H "Content-Type: application/json" -d '{ "name": "Spaghetti Carbonara", "description": "Pasta italiana con salsa de huevo, queso y panceta.", "instructions": "Cocinar la pasta, mezclar con huevo batido, queso y panceta crujiente.", "rating": 5, "ingredients": "Spaghetti:200g, Huevo:2 unidades, Panceta:100g, Queso parmesano:50g, Pimienta negra:1 pizca" }' http://localhost:8080/recipes
curl -X POST -H "Content-Type: application/json" -d '{ "name": "Crema de Calabaza", "description": "Sopa cremosa de calabaza con un toque de jengibre.", "instructions": "Cocinar la calabaza, mezclar con caldo y triturar hasta obtener una crema suave.", "rating": 4, "ingredients": "Calabaza:500g, Cebolla:1 unidad, Caldo de verduras:500ml, Jengibre:1 cucharadita, Nata:100ml" }' http://localhost:8080/recipes
