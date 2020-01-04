# Festival de Cine

[![Build Status](https://travis-ci.com/raulramirez97/Festival-de-Cine-Calidad-Software.svg?branch=master)](https://travis-ci.com/raulramirez97/Festival-de-Cine-Calidad-Software/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## Contexto

Repo que contiene un proyecto para la asignatura Proceso y Calidad de Software, impartida por la Universidad de Deusto.

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
    - Nombre de usuario: admin
    - Contraseña: admin
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

<b>NOTA</b>: El code coverage obtenido es relativamente bajo de base (50% en recorrido de código general sobre el 30% de 
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
documentación on-line generada para este proyecto.

URL de la documentación: https://github.com/Benny96

<b>NOTA</b>: A la hora de utilizar el comando `mvn site`, es probable que haya errores a la hora de crear el directorio de
`Dependencies` del informe de Apache. Esto es así por la utilización de diversas versiones en este proyecto. 
Se ha decidido dejar así dado que no es un error bloqueante y porque la documentación generada vía Doxygen se actualiza 
sin problema.
_____

# Autores:

- Beñat Galdós ([Benny96](https://github.com/Benny96 "Perfil de GitHub de Beñat Galdós"))
- Anne Idigoras ([anneidigoras](https://github.com/anneidigoras "Perfil de GitHub de Anne Idigoras"))
- Julen Elcoro-Iribe ([elkerr](https://github.com/Elkerr "Perfil de GitHub de Julen Elcoro-Iribe"))
- Raúl Ramirez ([raulramirez97](https://github.com/raulramirez97 "Perfil de GitHub de Raúl Ramirez"))
