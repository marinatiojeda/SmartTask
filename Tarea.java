package com.smarttask.app;

/**
 * Clase abstracta que representa el modelo base de una Tarea en el sistema SmartTask.
 * <p>
 * Encapsula los atributos comunes de cualquier tipo de tarea (identificador, 
 * nombre, prioridad y estado) y sirve como superclase para especializaciones 
 * como {@link TareaNormal} y {@link TareaUrgente}.
 * </p>
 */
public abstract class Tarea {
    
	/** Ientificador unico de la tgarea. */
    private int id;
    
    /** Nombre o descripcion de la tarea.*/
    private String nombre;
    
    /** Nivel de prioridad asigando a la tarea ("alta", "media", "baja") */
    private String prioridad; 
    
    /** Indica si la tarea esta completada (ture) o pendiente (false)*/
    private boolean completado;

    /**
     * Construye una nueva instancia de una tarea en sus atributos base.
     * por defecto, toda tareainicia en estado no completado (false).
     * 
     * @param id   Identificacor unico de la tarea.
     * @param nombre  Nombre o descripcion de la tarea.
     * @param prioridad Nivel de prioridad asisgnado a la tarea.
     */
    public Tarea(int id, String nombre, String prioridad) {
        this.id = id;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.completado = false; 
    }

    /**
     * Obtiene el identificador único de la tarea.
     * 
     * @return El ID de la tarea.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre o descripción de la tarea.
     *
     * @return El nombre de la tarea.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre o descripción de la tarea.
     *
     * @param nombre El nuevo nombre para la tarea.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la prioridad asignada a la tarea.
     *
     * @return La prioridad de la tarea.
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * Actualiza el nivel de prioridad de la tarea.
     *
     * @param prioridad La nueva prioridad para la tarea.
     */
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * Indica el estado de finalización de la tarea.
     *
     * @return {@code true} si la tarea está completada; {@code false} si está pendiente.
     */
    public boolean isCompletado() {
        return completado;
    }

    /**
     * Modifica el estado de finalización de la tarea.
     *
     * @param completado {@code true} para marcar como completada, {@code false} para pendiente.
     */
    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    /**
     * Devuelve una representación en texto de la tarea, incluyendo su ID, nombre,
     * prioridad y estado visual ([X] Completada / [ ] Pendiente).
     *
     * @return Una cadena formateada con la información detallada de la tarea.
     */
    @Override
    public String toString() {
        String estado = completado ? "[X] Completada" : "[ ] Pendiente";
        return "ID: " + id + " | Tarea: " + nombre + " | Prioridad: " + prioridad + " | Estado: " + estado;
    }
}

