# Festival de Cine

## Contexto

Repo que contiene un proyecto para la asignatura Proceso y Calidad de Software, impartida por la Universidad de Deusto.

Los objetivos de este proyecto son de dos tipos:

### A) Humano / Organizativo

Este proyecto se enmarca dentro de un contexto en el que los autores han debido trabajar en base a una metodología Scrum.
Para ello, los autores han ido rotando tres roles (Scrum Master, Product Owner y Developer) en tres Sprints de desarrollo.

### B) Técnico

A su vez, este proyecto ha pretendido ser una excusa para que los alumnos pudieran aprender a manejar las siguientes
tecnologías:

- [Maven](https://maven.apache.org/ "Landing page de Maven").
- Comunicación mediante REST.
- [YouTrack](https://www.jetbrains.com/youtrack/ "Landing page de YouTrack, producto de JetBrains").

## Ejecución

Se dan algunas pautas a continuación para poder replicar la ejecución del código subido a este repo.

## 0. Requisitos previos a la ejecución

Antes de llevar a cabo los pasos de ejecución, cabe destacar que:

1. Hay que tener alguna herramienta que permita acceder a una base de datos MySQL, como por ejemplo [MySQL Workbench](https://www.mysql.com/products/workbench/ "Landing page de MySQL Workbench").
2. Hay que instalar Maven en el equipo. Más información para la instalación [en su página web](https://maven.apache.org/install.html "URL de ayuda para instalar Maven").

## 1. Ejecución

Para preparar la base de datos MySQL:

1. Iniciar MySQL.
2. Crear el schema MySQL usando el script preparado en `src\main\sql`.

Para ejecutar la aplicación con ejemplos de prueba, antes de utilizar los ejemplos funcionales:

1. `mvn compile`
2. `mvn package jetty:run`
3. `mvn exec:java -Pfixture`

Para ejecutar la aplicación con ejemplos reales, habría que ejecutar los siguientes comandos:

1. `mvn compile`
2. `mvn exec:java -Pauth`
3. `mvn exec:java -Pserver`
4. `mvn exec:java -Pclient`

Para ejecutar las clases de test: `mvn test`

_____

# Autores:

- Beñat Galdós ([Benny96](https://github.com/Benny96 "Perfil de GitHub de Beñat Galdós"))
- Anne Idigoras ([anneidigoras](https://github.com/anneidigoras "Perfil de GitHub de Anne Idigoras"))
- Julen Elcoro-Iribe ([elkerr](https://github.com/Elkerr "Perfil de GitHub de Julen Elcoro-Iribe"))
- Raúl Ramirez ([raulramirez97](https://github.com/raulramirez97 "Perfil de GitHub de Raúl Ramirez"))
