# SmartTask - Sistema de Gestión de Tareas en Java

## Descripción del Proyecto
SmartTask es una aplicación de consola desarrollada en Java enfocada en la gestión interactiva de tareas (Creación, Lectura, Actualización y Eliminación - CRUD). Aplica principios de Programación Orientada a Objetos (POO), arquitectura limpia y pruebas unitarias con JUnit 5.

---

## Arquitectura y Requerimientos Técnicos

1. **Programación Orientada a Objetos (POO) y Herencia:**
   - **`Tarea`**: Clase abstracta base que encapsula los atributos comunes (`id`, `titulo`, `completada`).
   - **`TareaNormal`** y **`TareaUrgente`**: Clases hijas que heredan de `Tarea`, aplicando polimorfismo.

2. **Interfaces:**
   - **`Accionable`**: Interfaz que define comportamientos o acciones específicas ejecutables por las tareas.

3. **Manejo de Colecciones:**
   - **`GestorTareas`**: Clase encargada de la lógica de negocio que administra las tareas mediante `List<Tarea>` e implementaciones de `ArrayList`.

4. **Pruebas Unitarias (JUnit 5):**
   - Cobertura de pruebas completa en **`GestorTareasTest`** validando la adición, listado, marcado de estado y eliminación de tareas.

---

## Estructura del Proyecto
src/
└── com/
    └── smarttask/
        └── app/
            ├── Accionable.java
            ├── GestorTareas.java
            ├── GestorTareasTest.java
            ├── Main.java
            ├── Tarea.java
            ├── TareaNormal.java
            └── TareaUrgente.java

---

## Ejecución del Proyecto
1. **Consola Interactiva:** Ejecutar `Main.java` desde cualquier IDE compatible con Java.
2. **Pruebas Unitarias:** Ejecutar `GestorTareasTest.java` como **JUnit Test**.


