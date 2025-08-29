# Sistema de Gestión de Servicios de Atención a Personas con Discapacidad

Proyecto de Avance para la asignatura **INF2236 - Programación Avanzada**. Este sistema es una aplicación de consola desarrollada en Java que permite gestionar usuarios y las prestaciones de servicios que reciben.

---

## Autores

* Joaquin Alegria
* Francisco Espinoza
* Rigoberto Canales

---

## Requisitos Previos

Para poder compilar y ejecutar este proyecto, necesitarás tener instalado el siguiente software:

* **Java Development Kit (JDK)**: Versión 11 o superior.
* **Apache NetBeans IDE**: Versión 21 o superior.

---

## Instalación

Sigue estos pasos para poner en marcha el proyecto en tu máquina local:

### Paso 1: Descargar el Proyecto desde GitHub

Primero, necesitas obtener el código fuente en tu computadora. Tienes dos opciones:

* **Opción A: Descargar como ZIP (Recomendado)**
    1.  En la página principal de este repositorio, haz clic en el botón verde que dice `Code`.
    2.  En el menú que se despliega, selecciona `Download ZIP`.
    3.  Guarda el archivo y descomprímelo en una carpeta de tu elección.

* **Opción B: Clonar en nNetBeans (Avanzado)**
    Dentro de NetBeans:
    1. En el menú superior de NetBeans, haz clic en Team.
    2. En el menú que se despliega, ve a Git y luego selecciona Clone...
    ```bash
    3. Pega la URL https://github.com/ItsRigozzi/GestionDiscapacidad.git
    4. continua hasta elegir donde guardarasel proyecto y finalizas
    ```
### Paso 2 solo si descargas con Zip: Abrir el Proyecto en NetBeans

1.  Inicia Apache NetBeans.
2.  Ve al menú `File` > `Open Project...`.
3.  Navega hasta la carpeta donde descomprimiste o clonaste el proyecto.
4.  Selecciona la carpeta del proyecto (`GestionDiscapacidad`) y haz clic en `Open Project`.

---

## Ejecución

Una vez que el proyecto esté abierto en NetBeans, puedes ejecutarlo de la siguiente manera:

1.  En el panel "Projects" de la izquierda, navega hasta el archivo principal:
    `Source Packages` > `gestiondiscapacidad` > `GestionDiscapacidad.java`.
2.  Haz **clic derecho** sobre el archivo `GestionDiscapacidad.java`.
3.  En el menú contextual, selecciona la opción `Run File`.

La aplicación se ejecutará y verás el menú principal en la consola de "Output" en la parte inferior de NetBeans.

---

## Uso del Sistema

La aplicación presenta un menú de consola con las siguientes opciones:

1.  **Registrar nuevo usuario:** Pide por consola los datos de un nuevo usuario (nombre, edad y diagnóstico) y lo registra en el sistema con un ID único.
2.  **Asignar prestación a un usuario:** Muestra una lista de los usuarios existentes y permite seleccionar uno por su ID para asignarle una nueva prestación (terapia o servicio).
3.  **Mostrar usuarios y sus prestaciones:** Imprime en pantalla un listado completo de todos los usuarios registrados, junto con los detalles de las prestaciones que cada uno tiene asignadas.
4.  **Salir:** Termina la ejecución del programa.

