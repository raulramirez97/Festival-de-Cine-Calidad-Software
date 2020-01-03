# Festival de Cine

[![Build Status](https://travis-ci.com/raulramirez97/Festival-de-Cine-Calidad-Software.svg?branch=master)](https://travis-ci.com/raulramirez97/Festival-de-Cine-Calidad-Software/)

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

Se dan algunas pautas a continuación para poder replicar la ejecución del código subido a este repo.

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
3. `mvn package jetty:run` : Permite ejecutar el servidor o "Servlet" de Jetty, y ponerlo en escucha 
(FestivalCineManager).

### En la segunda ventana:
4. `mvn exec:java -Pclient -X` : Permite ejecutar el cliente (FestivalCineController).

## Prototipo

Para entender mejor a qué va a tender esta aplicación, se ha generado un prototipo mediante Marvel App para poder 
ilustrarlo. URL: https://marvelapp.com/d2h27dh/screen/63095209

## Sobre las imágenes

Solamente destacar que para que el cargado de imágenes sea óptimo en cualquier situación, es recomendble
que los nombres de estas no tengan espacios intermedios, sino que sean del formato ```el_rey_leon.jpg```.

## 2. Testeo

Otra parte fundamental que se ha querido trabajar en este proyecto han sido los tests. Se han hecho tests y mejoras
de diverso tipo a lo largo de la aplicación:
1. Tests unitarios con `JUnit3/4`.
2. Tests de rendimiento con `ContiPERF`.
3. Mocking o simulación de clases con `Mockito`.
4. Revisar el code coverage con `JaCoCo`.
5. Uso de Logging mediante `Log4j`.
6. Integración de este repositorio con una herramienta de CI como `TravisCI`.

A modo complementario, se ha hecho algo de profiling de la aplicación mediante la información obtenida con `VisualVM`.
Se han hecho algunas correcciones de checkstyle, aunque aún quedan unas cuantas pendientes por hacer.
Finalmente, se ha empezado a agregar algo de documentación JavaDoc, que posteriormente es interpretada por el 
plugin `Doxygen`.

La información sobre profiling con VisualVM se ha incluido en el directorio `profiling` de este repo. El log que muestra 
la integración correcta con TravisCI y la ejecución automatizada de este test se muestra en `travisci_log`.

NOTA: Dado que buena parte de las líneas de código se encuentran en la parte Cliente de la aplicación, y esta consta de 
muchas líneas para la interfaz gráfica de usuario, el code coverage obtenido es bastante bajo de base. Por ello, se ha 
reducido a niveles bastante bajos los indicadores de code coverage, para que JaCoCo no bloqueara la ejecución de los tests.

### Comandos para ejecutar tests

Se insertan a continuación diversos comandos para poder jugar con las clases de testeo. Antes de ejecutar estos,
habrá que ejecutar `mvn clean` y `mvn compile`. Los comandos son los que siguen:

- Ejecución de tests a nivel general: ```mvn test```
- Ejecución de code coverage: ```mvn jacoco:check```
- Ejecución de plugin de checkstyle, para corregir errores de estilo en la aplicación: ```mvn checkstyle:checkstyle```
- Generación de un dashboard completo del proyecto: ```mvn site```

NOTA: A la hora de utilizar el comando `mvn site`, es probable que haya errores a la hora de crear el directorio de
`Dependencies` del informe. Esto es así porque al parecer, Log4j intenta cargar JARs de Java 8 y Java 9, lo que
lleva a que Maven no sepa integrarlos correctamente en el informe. Más info: 
https://stackoverflow.com/questions/49383179/org-apache-bcel-classfile-classformatexception-invalid-byte-tag-in-constant-poo
_____

# Autores:

- Beñat Galdós ([Benny96](https://github.com/Benny96 "Perfil de GitHub de Beñat Galdós"))
- Anne Idigoras ([anneidigoras](https://github.com/anneidigoras "Perfil de GitHub de Anne Idigoras"))
- Julen Elcoro-Iribe ([elkerr](https://github.com/Elkerr "Perfil de GitHub de Julen Elcoro-Iribe"))
- Raúl Ramirez ([raulramirez97](https://github.com/raulramirez97 "Perfil de GitHub de Raúl Ramirez"))
