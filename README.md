# Festival de Cine

[![Build Status](https://travis-ci.com/raulramirez97/Festival-de-Cine-Calidad-Software.svg?branch=master)](https://travis-ci.com/raulramirez97/Festival-de-Cine-Calidad-Software/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

# Spanish

##### Documentación Online: https://raulramirez97.github.io/Festival-de-Cine-Calidad-Software/

##### Manual de Usuario: https://github.com/raulramirez97/Festival-de-Cine-Calidad-Software/blob/master/user_guide/ManualUsuario_FestCine.pdf

## Contexto

Repo que contiene un proyecto para la asignatura Proceso y Calidad de Software, impartida por la Universidad de Deusto.
La idea subyacente del proyecto ha sido generar una aplicación que simule de manera sencilla a FilmAffinity.

Los objetivos de este proyecto son de dos tipos:

### A) Humano / Organizativo

Este proyecto se enmarca dentro de un contexto en el que los autores han debido trabajar en base a una metodología Scrum.
Para ello, los autores han ido rotando tres roles (Scrum Master, Product Owner y Developer) en tres Sprints de 
desarrollo.

### B) Técnico

A su vez, este proyecto ha pretendido ser una excusa para que los alumnos pudieran aprender a manejar las siguientes
tecnologías:

- [Maven](https://maven.apache.org/ "Landing page de Maven").
- Comunicación mediante REST, usando [Jersey](https://eclipse-ee4j.github.io/jersey/ "Documentación de Jersey").
- [YouTrack](https://www.jetbrains.com/youtrack/ "Landing page de YouTrack, producto de JetBrains").

## Ejecución

## 0. Requisitos previos a la ejecución

Antes de llevar a cabo los pasos de ejecución, cabe destacar que:

1. Hay que tener alguna herramienta que permita acceder a una base de datos MySQL, como por ejemplo 
[MySQL Workbench](https://www.mysql.com/products/workbench/ "Landing page de MySQL Workbench").
2. Hay que instalar Maven en el equipo. Más información para la instalación 
[en su página web](https://maven.apache.org/install.html "URL de ayuda para instalar Maven").

## 1. Ejecución

Para preparar la base de datos MySQL:

1. Iniciar MySQL.
2. Crear el schema MySQL usando el script preparado en `src\main\sql`.

Para testear la aplicación, hay que ejecutar los siguientes comandos en dos ventanas de línea de comando 
(ya sea *SH o PowerShell):

### En la primera ventana:
1. `mvn clean` : Permite limpiar todas las versiones de paquetes de Maven descargadas.
2. `mvn compile` : Permite compilar todos los ficheros .java con los paquetes de Maven, y unirlos en el target.

3. Ejecución del servidor o "Servlet" de Jetty, y ponerlo en escucha (FestivalCineManager):
- Si se quieren ejecutar todos los tests al ejecutar : `mvn package jetty:run`
- Si solamente se quiere ejecutar el servidor : `mvn -DskipTests=true package jetty:run`

### En la segunda ventana:
`mvn exec:java -Pclient -X` : Permite ejecutar el cliente (FestivalCineController).

## Prototipo

La aplicación ha tomado como referencia un prototipo creado mediante Marvel App para su diseño y desarrollo. 
URL: https://marvelapp.com/d2h27dh/screen/63095209

## Sobre las imágenes

Un usuario de tipo administrador, con credenciales:

```
Nombre de usuario: admin
Contraseña: admin
```

Es capaz de insertar películas y actores en el sistema, y en el caso de estos primeros, puede seleccionar una imagen
para completar la ficha de una película. Para que el cargado de imágenes sea óptimo en cualquier situación, es 
recomendable que los nombres de estas no tengan espacios intermedios, sino que sean del formato `el_rey_leon.jpg`.

## 2. Testeo

Otra parte fundamental que se ha querido trabajar en este proyecto han sido los tests. Se han hecho tests y mejoras
de diverso tipo a lo largo de la aplicación:

| Objetivo | Tecnología |
| --- | --- |
| Desarrollo de tests unitarios | [JUnit4](https://junit.org/junit4/) |
| Desarrollo de tests de rendimiento | [ContiPERF](https://mvnrepository.com/artifact/org.databene/contiperf) |
| Desarrollo de Mocking o simulación de clases | [Mockito](https://site.mockito.org/) |
| Mejora del code coverage | [JaCoCo](https://www.eclemma.org/jacoco/) |
| Uso de Logging | [Log4j](https://logging.apache.org/log4j/2.x/) |
| Comprobación de checkstyle | [Maven Checkstyle Plugin](https://maven.apache.org/plugins/maven-checkstyle-plugin/) |
| Profiling de la aplicación | [VisualVM](https://visualvm.github.io/) |
| Generación de documentación JavaDoc (Apache) | [Maven Project Info Reports Plugin](https://maven.apache.org/plugins/maven-project-info-reports-plugin/) |
| Generación de documentación JavaDoc (Doxygen) | [Doxygen](http://www.doxygen.nl/) |
| Integración continua (CI) de este repositorio | [TravisCI](https://travis-ci.org/) |

La información sobre profiling con VisualVM se ha incluido en el directorio `profiling` de este repo. El log que muestra 
la integración correcta con TravisCI y la ejecución automatizada de este test se muestra en `travisci_log`.

<b>NOTA</b>: El code coverage obtenido es relativamente bajo de base (53% en recorrido de código general sobre el 30% de 
variantes disponibles). Por ello, se ha reducido a niveles bajos los indicadores de code coverage para que JaCoCo no 
bloqueara la ejecución de los tests.

### Comandos para ejecutar tests

Se insertan a continuación diversos comandos para poder interactuar con las clases de testeo. Antes de ejecutar estos,
habrá que ejecutar `mvn clean`.

| Objetivo | Comando |
| --- | --- |
| Ejecución de todos los tests. | ```mvn test``` |
| Evaluación de code coverage. | ```mvn jacoco:check``` |
| Ejecución de plugin de checkstyle, para detectar errores de estilo en la aplicación. | ```mvn checkstyle:checkstyle``` |
| Generación de un dashboard completo del proyecto, tanto en formato Doxygen como en formato Apache Maven. | ```mvn site``` |

A su vez, el comando ```mvn site``` genera una carpeta ```docs``` en el nivel superior, la cual alimenta a la
documentación on-line generada para este proyecto, presentada en la parte inicial de este README.

En lo que al checkstyle respecta, se han hecho varias revisiones de los ficheros, reduciendo de 4.000 errores iniciales
que había a algo menos de 2.000. Sin embargo, se ha decidido que muchos de ellos eran decisiones propias del diseño, así que se
ha preferido no alterar en exceso el codigo solo con el motivo de respetar lo que indica el plugin de checkstyle.
_____

## Autores:

- Beñat Galdós ([Benny96](https://github.com/Benny96 "Perfil de GitHub de Beñat Galdós"))
- Anne Idigoras ([anneidigoras](https://github.com/anneidigoras "Perfil de GitHub de Anne Idigoras"))
- Julen Elcoro-Iribe ([elkerr](https://github.com/Elkerr "Perfil de GitHub de Julen Elcoro-Iribe"))
- Raúl Ramirez de Cartagena ([raulramirez97](https://github.com/raulramirez97 "Perfil de GitHub de Raúl Ramirez de Cartagena"))

# English

##### Online Documentation [SPA]: https://raulramirez97.github.io/Festival-de-Cine-Calidad-Software/

##### User Manual [SPA]: https://github.com/raulramirez97/Festival-de-Cine-Calidad-Software/blob/master/user_guide/ManualUsuario_FestCine.pdf

## Context

Repo that contains a project for the subject Process and Software Quality, taught by the University of Deusto.
The underlying idea of the project has been to generate an application that simulates FilmAffinity in a simple way.

The objectives of this project are of two types:

### A) Human / Organizational

This project is framed within a context in which the authors have had to work based on a Scrum methodology.
For this, the authors have been rotating three roles (Scrum Master, Product Owner and Developer) in three Sprints of
development.

### B) Technical

Additionally, this project has been an excuse for students to learn to use the following
technologies:

- [Maven](https://maven.apache.org/ "Maven's Landing Page").
- RESTful Communications with [Jersey](https://eclipse-ee4j.github.io/jersey/ "Jersey Documentation").
- [YouTrack](https://www.jetbrains.com/youtrack/ "YouTrack's Landing Page, JetBrains' product").

## Run

## 0. Prerequisites for running

Before carrying out the execution steps, it should be noted that:

1. You have to have some tool that allows you to access a MySQL database, such as 
[MySQL Workbench](https://www.mysql.com/products/workbench/ "MySQL Workbench's Landing Page").
2. Maven must be installed on the computer. More information for installation 
[in their web page](https://maven.apache.org/install.html "URL describing Maven's installation process").

## 1. Running

To prepare the MySQL database:

1. Start MySQL.
2. Create the MySQL schema using the script prepared in `src \ main \ sql`.

To test the application, you must execute the following commands in two command line windows
(either * SH or PowerShell):

### In the first window:
1. `mvn clean`: It allows you to clean all versions of downloaded Maven packages.
2. `mvn compile`: It allows you to compile all the .java files with the Maven packages, and join them in the target.

3. Running the server or JeTTY "Servlet" and keep it listening to new input (FestivalCineManager):
- If you want to run all the tests: `mvn package jetty: run`
- If you only want to run the server: `mvn -DskipTests = true package jetty: run`

### In the second window:
`mvn exec: java -Pclient -X`: Run the client (FestivalCineController).

## Prototype

The application has been designed and developed considering a prototype created using MarvelApp.
URL: https://marvelapp.com/d2h27dh/screen/63095209

## About the images

An administrator user, with credentials:

```
Username: admin
Password: admin
```

Is able to insert movies and actors in the system, and in the case of the former, you can select an image
to complete a movie file. So that image loading works optimally in any situation, it is
recommended to remove whitespaces between file names, leaving a format like `el_rey_leon.jpg`.

## 2. Testing

The other essential part that has been developed with this project have been the tests. Tests and improvements of different types have been
included throughout the application:

| Objective | Technology |
| --- | --- |
| Development of unit tests | [JUnit4](https://junit.org/junit4/) |
| Performance test development | [ContiPERF](https://mvnrepository.com/artifact/org.databene/contiperf) |
| Mocking development or class simulation | [Mockito](https://site.mockito.org/) |
| Code coverage improvement | [JaCoCo](https://www.eclemma.org/jacoco/) |
| Use of Logging | [Log4j](https://logging.apache.org/log4j/2.x/) |
| Checkstyle check | [Maven Checkstyle Plugin](https://maven.apache.org/plugins/maven-checkstyle-plugin/) |
| Application profiling | [VisualVM](https://visualvm.github.io/) |
| JavaDoc documentation generation (Apache) | [Maven Project Info Reports Plugin](https://maven.apache.org/plugins/maven-project-info-reports-plugin/) |
| JavaDoc documentation generation (Doxygen) | [Doxygen](http://www.doxygen.nl/) |
| Continuous integration (CI) of this repository | [TravisCI](https://travis-ci.org/) |

Information on profiling with VisualVM has been included in the `profiling` directory of this repo. The log that shows
the correct integration with TravisCI and the automated execution of this test is shown in `travisci_log`.

<b>SIDENOTE</b>: The code coverage obtained is low (53% of instructions over 30% of branches). Therefore, the code 
coverage indicators have been reduced to low levels so that JaCoCo does not block the execution of the tests.

### Commands to run tests

Various commands are then inserted in order to interact with the test classes. Before running these tests,
`mvn clean` should be executed.

| Objective | Command |
| --- | --- |
| Execution of all tests. | ```mvn test``` |
| Code coverage evaluation. | ```mvn jacoco: check``` |
| Execution of checkstyle plugin to detect style errors in the application. | ```mvn checkstyle: checkstyle``` |
| Generation of a complete dashboard of the project, both in Doxygen format and in Apache Maven format. | ```mvn site``` |

Besides, the ```mvn site``` command generates a ```docs``` folder at the top level, which feeds the
on-line documentation generated for this project, presented in the initial part of this README.

As far as checkstyle is concerned, several revisions of the files have been made, reducing the amount of errors from 4,000 
to approximately 2,000. However, since many of those warnings given by the checkstyle plugin conflicted with our design decisions,
we preferred not to override the code.
_____

# Authors:

- Beñat Galdós ([Benny96](https://github.com/Benny96 "Beñat Galdós' GitHub profile"))
- Anne Idigoras ([anneidigoras](https://github.com/anneidigoras "Anne Idigoras' GitHub profile"))
- Julen Elcoro-Iribe ([elkerr](https://github.com/Elkerr "Julen Elcoro-Iribe's GitHub profile"))
- Raúl Ramirez de Cartagena ([raulramirez97](https://github.com/raulramirez97 "Raúl Ramirez de Cartagena's GitHub profile"))
