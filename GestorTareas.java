package com.smarttask.app;

import java.util.ArrayList;
import java.util.List;

public class GestorTareas {

	// Lista principal de tareas y contador para IDs únicos
    private List<Tarea> tareas = new ArrayList<>();
    private int contadorId = 1;

    /**
     * Agrega una nueva tarea a la lista con un ID autoincrementable.
     * 
     * @param nombre Nombre o descripción de la tarea.
     * @param prioridad Nivel de prioridad (Alta, Media, Baja).
     */
    public void agregarTarea(String nombre, String prioridad) {
        Tarea nuevaTarea;

        if (prioridad.equalsIgnoreCase("Alta")) {
            nuevaTarea = new TareaUrgente(contadorId++, nombre);
        } else {
            nuevaTarea = new TareaNormal(contadorId++, nombre, prioridad);
        }

        tareas.add(nuevaTarea);
    }
    /**
     * Obtiene una copia con todas las tareas registradas.
     * 
     * @return Lista completa de tareas.
     */
    public List<Tarea> listarTodas() {
        return new ArrayList<>(tareas);
    }

    /**
     * Obtiene solamente las tareas activas (no completadas).
     * 
     * @return Lista de tareas no completadas.
     */
    public List<Tarea> listarActivas() {
        List<Tarea> activas = new ArrayList<>();
        for (Tarea tarea : tareas) {
            if (!tarea.isCompletado()) {
                activas.add(tarea);
            }
        }
        return activas;
    }

    /**
     * Obtiene solamente las tareas completadas.
     * 
     * @return Lista de tareas completadas.
     */
    public List<Tarea> listarCompletadas() {
        List<Tarea> completadas = new ArrayList<>();
        for (Tarea tarea : tareas) {
            if (tarea.isCompletado()) {
                completadas.add(tarea);
            }
        }
        return completadas;
    }

    /**
     * Marca una tarea como completeda según su ID.
     * 
     * @param id Identificador de la tarea.
     * @return true si la encontró y actualizó, false si no existe.
     */
    public boolean marcarComoCompletada(int id) {
        for (Tarea tarea : tareas) {
            if (tarea.getId() == id) {
                tarea.setCompletado(true);
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina una tarea según su ID.
     * 
     * @param id Identificador de la tarea a eliminar.
     * @return true si la eliminó, false si no la encontró.
     */
    public boolean eliminarTarea(int id) {
        return tareas.removeIf(tarea -> tarea.getId() == id);
    }
}	
