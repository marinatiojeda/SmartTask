package com.smarttask.app;

/**
 * Clase que representa el modelo de una Tarea individual en el sistema.
 */
public class Tarea {
    
    private int id;
    private String nombre;
    private String prioridad; // "Alta", "Media", "Baja"
    private boolean completado;

    // Constructor
    public Tarea(int id, String nombre, String prioridad) {
        this.id = id;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.completado = false; // Al crearse, la tarea inicia no completada
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    @Override
    public String toString() {
        String estado = completado ? "[X] Completada" : "[ ] Pendiente";
        return "ID: " + id + " | Tarea: " + nombre + " | Prioridad: " + prioridad + " | Estado: " + estado;
    }
}