
# Start the database
start-infra:
    podman run --ulimit memlock=-1:-1 -d -it --rm=true \
        -e POSTGRES_USER=recipes \
        -e POSTGRES_PASSWORD=recipes \
        -e POSTGRES_DB=recipes \
        -p 5432:5432 postgres:15-bullseye

    podman run -d -p 9092:9092 -it --rm \
        -e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://localhost:9092 \
        quay.io/ogunalp/kafka-native:0.8.0-kafka-3.7.0

stop-infra:
    podman stop $(podman ps -q)

add-recipes host:
    curl -X POST -H "Content-Type: application/json" -d '{ "name": "Pizza Margarita", "description": "Clásica pizza italiana con tomate, mozzarella y albahaca.", "instructions": "Extender la masa, añadir tomate y mozzarella. Hornear a 220°C por 12 minutos.", "ingredients": "Harina:300g, Agua:200ml, Levadura:5g, Tomate:150g, Mozzarella:100g, Albahaca:5 hojas" }' {{host}}/recipes
    curl -X POST -H "Content-Type: application/json" -d '{ "name": "Ensalada Cesar", "description": "Ensalada fresca con lechuga, pollo y aderezo César.", "instructions": "Mezclar lechuga, pollo, crutones y aderezo. Servir con queso rallado.", "ingredients": "Lechuga:1 unidad, Pollo:150g, Crutones:50g, Queso parmesano:30g, Aderezo César:50ml" }' {{host}}/recipes
    curl -X POST -H "Content-Type: application/json" -d '{ "name": "Spaghetti Carbonara", "description": "Pasta italiana con salsa de huevo, queso y panceta.", "instructions": "Cocinar la pasta, mezclar con huevo batido, queso y panceta crujiente.", "ingredients": "Spaghetti:200g, Huevo:2 unidades, Panceta:100g, Queso parmesano:50g, Pimienta negra:1 pizca" }' {{host}}/recipes
    curl -X POST -H "Content-Type: application/json" -d '{ "name": "Crema de Calabaza", "description": "Sopa cremosa de calabaza con un toque de jengibre.", "instructions": "Cocinar la calabaza, mezclar con caldo y triturar hasta obtener una crema suave.", "rating": 4, "ingredients": "Calabaza:500g, Cebolla:1 unidad, Caldo de verduras:500ml, Jengibre:1 cucharadita, Nata:100ml" }' {{host}}/recipes
    curl -X POST -H "Content-Type: application/json" -d '{ "name": "Tortilla de Patata", "description": "Clásico plato español a base de patatas y huevos.", "instructions": "Freír las patatas con la cebolla, mezclar con huevo batido y cuajar en una sartén.", "ingredients": "Patatas:500g, Huevos:4 unidades, Cebolla:1 unidad, Aceite de oliva:50ml, Sal:al gusto" }' {{host}}/recipes
    curl -X POST -H "Content-Type: application/json" -d '{ "name": "Flan de Huevo", "description": "Postre clásico a base de huevo y leche con caramelo.", "instructions": "Mezclar huevos, leche y azúcar. Verter sobre caramelo y hornear al baño maría.", "ingredients": "Huevo:4 unidades, Leche:500ml, Azúcar:150g, Caramelo líquido:50g" }' {{host}}/recipes
    curl -X POST -H "Content-Type: application/json" -d '{ "name": "Albondigas en Salsa", "description": "Albóndigas caseras en una deliciosa salsa de tomate.", "instructions": "Formar albóndigas con carne picada, cocinarlas y añadir salsa de tomate.", "ingredients": "Carne picada:500g, Pan rallado:50g, Huevo:1 unidad, Leche:50ml, Ajo:1 diente, Perejil:1 cucharada, Tomate triturado:400g, Cebolla:1 unidad, Sal:al gusto" }' {{host}}/recipes
    curl -X POST -H "Content-Type: application/json" -d '{ "name": "Paella Valenciana", "description": "Plato típico de Valencia con arroz, pollo, conejo y verduras.", "instructions": "Dorar la carne, añadir verduras y arroz, cocinar con caldo hasta que esté en su punto.", "ingredients": "Arroz:400g, Pollo:200g, Conejo:200g, Judía verde:100g, Garrofón:100g, Tomate triturado:100g, Pimentón:1 cucharadita, Caldo de pollo:1 litro, Azafrán:1 pizca, Sal:al gusto" }' {{host}}/recipes
    curl -X POST -H "Content-Type: application/json" -d '{ "name": "Tiramisu", "description": "Postre italiano con capas de bizcocho de café y crema de mascarpone.", "instructions": "Empapar los bizcochos en café, alternar capas con crema de mascarpone y espolvorear cacao.", "ingredients": "Bizcochos de soletilla:200g, Café:200ml, Queso mascarpone:250g, Azúcar:100g, Cacao en polvo:30g, Huevo:3 unidades" }' {{host}}/recipes



