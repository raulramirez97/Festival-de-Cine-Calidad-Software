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

Para testear la aplicación, hay que ejecutar los siguientes comandos en dos ventanas de línea de comando (ya sea *SH o PowerShell):

### En la primera ventana:
1. `mvn clean` : Permite limpiar todas las versiones de paquetes de Maven descargadas.
2. `mvn compile` : Permite compilar todos los ficheros .java con los paquetes de Maven, y unirlos en el target.
3. `mvn package jetty:run` : Permite ejecutar el servidor o "Servlet" de Jetty, y ponerlo en escucha (FestivalCineManager).

### En la segunda ventana:
4. `mvn exec:java -Pclient -X` : Permite ejecutar el cliente (FestivalCineController).

Para ejecutar las clases de test: `mvn test`. No obstante, ahora mismo los tests están comentados para que no molesten con el resto del desarrollo.

## Prototipo

Para entender mejor a qué va a tender esta aplicación, se ha generado un prototipo mediante Marvel App para poder ilustrarlo. URL: https://marvelapp.com/d2h27dh/screen/63095209

_____

# Autores:

- Beñat Galdós ([Benny96](https://github.com/Benny96 "Perfil de GitHub de Beñat Galdós"))
- Anne Idigoras ([anneidigoras](https://github.com/anneidigoras "Perfil de GitHub de Anne Idigoras"))
- Julen Elcoro-Iribe ([elkerr](https://github.com/Elkerr "Perfil de GitHub de Julen Elcoro-Iribe"))
- Raúl Ramirez ([raulramirez97](https://github.com/raulramirez97 "Perfil de GitHub de Raúl Ramirez"))
