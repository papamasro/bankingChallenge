Requerimientos
--
Backend
Tecnologías: a crterio

Desarrollar con buenas practicas de arquitectura de software los siguientes endpoints:
1. POST /accounts: Crea una nueva cuenta bancaria. Este endpoint debería aceptar
   detalles de la cuenta como el nombre y el número de cuenta, y devolver un ID de
   cuenta.


2. GET /accounts/<id>/balance: Obtiene el balance de la cuenta bancaria.


3. POST /transactions: Realiza una transacción bancaria. Este endpoint debería
   aceptar detalles de la transacción como el ID de la cuenta, el tipo de transacción
   (depósito o retiro) y el monto de la transacción.
   Además, implementa un middleware que registre en la consola cada vez que se realiza un
   depósito de más de 10,000 US$.


4.
   Requerimientos de Arquitectura

   El sistema debe seguir los principios y patrones de Domain-Driven Design (DDD) para el diseño
   de la arquitectura y la estructura del código.
   El sistema debe utilizar Event Sourcing para el almacenamiento y recuperación de los cambios
   en las tareas. Cada acción realizada sobre una tarea (creación, actualización, eliminación,
   marcado como completada) debe ser registrada como un evento y almacenada en un registro
   de eventos.

   Implementa pruebas unitarias con Jest y asegúrate de que la cobertura de las pruebas sea
   completa. Incluye un archivo README que explique cómo ejecutar el código y las pruebas.
   Debes entregar un diagrama de alto nivel de como implementarías la solución en AWS.
   Requisitos Generales


5. Debes asegurarte de que el código sea de alta calidad, fácil de mantener y cumpla con
   los principios de diseño y buenas prácticas


6. El Sistema completo debe poder levantarse en local mediante el uso de docker-compose.
   Por favor, ten en cuenta que el código que entregues puede estar incompleto en cuanto a
   funcionalidad, pero siempre debe ser capaz de compilar y ejecutar las pruebas.




Introducción
---


¡Bienvenido al repositorio del proyecto Xepelin Challenge! Este proyecto está desarrollado utilizando Spring y PostgreSQL.

Dependencias
--
El proyecto actualmente tiene las siguientes dependencias:

Java 17,
Spring Framework 3,
PostgreSQL,
springdoc


Arquitectura
--
El proyecto sigue una clara separación de responsabilidades con los siguientes componentes:

Controlador (Controller): Responsable de manejar las solicitudes entrantes/salientes, manejo de Middlewares .

Servicio (Service): Contiene la lógica del negocio y se encarga de procesar y validar datos.

Repositorio (Repository): Maneja las interacciones con las bases de datos, proporcionando una abstracción para el acceso a datos.

Modelo (Model) donde se encuentran todas las entidades del negocio, requests y response de los servicios

Configuración (Configuration): Administra la configuración de las dependencias utilizadas en toda la aplicación.



Ejecutar el proyecto localmente
--

Ejecutar JAVA localmente:

Primero, asegúrate de tener instalado Java 17, IntelliJ y Git.
Clona el repositorio https://github.com/papamasro/bankingChallenge.git.
repositorio con postman para pruebas https://github.com/papamasro/bankingChallenge/tree/main/Collection
.

Abre el proyecto y configura las variables de entorno:
~~~
DATABASE_URL=jdbc:postgresql://localhost:5432/postgres;DATABASE_USERNAME=postgres;DATABASE_PASSWORD=mysecretpassword
~~~
Ejecutar PostgreSQL localmente:

Para ejecutar una base de datos PostgreSQL de forma local, puedes utilizar el siguiente comando de Docker:
~~~
docker run -p 5432:5432 --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -d postgres
~~~


Ejecutar el proyecto en Docker
--


Para correr el servicio mediante docker-compose, desde la carpeta raíz del proyecto, utiliza este comando:

~~~
docker-compose up --build
~~~

La api corre con una basic authentication (no recomendada, pero implementada por falta de tiempo)

~~~
Username:admin
Password:admin
~~~



Mejoras Obligatorias
---

Integración de JWT: Implementar JWT (JSON Web Tokens) para una autenticación y autorización seguras, actualmente por la falta de tiempo para implementar se esta usando basic authentication que no es recomendada.

Mejora de la Seguridad: Asegurar que la información sensible, como las contraseñas de los usuarios y las URL de las bases de datos, no estén expuestas ni se almacenen en texto plano.

Integración de Micrometer y Grafana: Integrar Micrometer con Grafana para un monitoreo avanzado y la recopilación de métricas.

Builders: Implementar builders en vez de constructores.

Manejo de Errores: Actualmente, la implementación para manejar errores se considera deficiente y necesita mejoras. Se requiere un análisis cuidadoso y mejoras en esta área para asegurar un manejo robusto de errores en toda la aplicación.

Mejoras Opcionales
--
Integración de Lombok: Considerar integrar Lombok para reducir el código repetitivo en el proyecto.

MapStruct: Explorar la posibilidad de utilizar MapStruct para simplificar el mapeo.

Documentación con Swagger: La documentación de Swagger se encuentra en construcción, puedes verla con la configuración básica en: http://localhost:8080/swagger-ui/index.html
