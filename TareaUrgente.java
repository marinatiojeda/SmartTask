package com.smarttask.app;

/**
 * Representa una tarea de prioridad alta o urgente dentro del sistema SmartTask.
 * <p>
 * Hereda de la clase abstracta {@link Tarea} e implementa la interfaz {@link Accionable}.
 * A diferencia de una tarea convencional, asigna automáticamente el nivel de prioridad "Alta"
 * al momento de su creación.
 * </p>
 */
public class TareaUrgente extends Tarea implements Accionable {
	
	/**
     * Construye una nueva instancia de {@code TareaUrgente}.
     * Asigna automáticamente la prioridad "Alta" al invocar al constructor base.
     *
     * @param id     El identificador único de la tarea.
     * @param nombre El nombre o descripción corta de la tarea.
     */
	public TareaUrgente(int id, String nombre) {
        super(id, nombre, "Alta");
    }

	/**
     * Ejecuta la acción asociada a la tarea urgente.
     * <p>
     * Imprime en la consola un mensaje de alerta destacado junto con el nombre de la tarea.
     * </p>
     */
    @Override
    public void ejecutarAccion() {
        System.out.println("🚨 ATENCIÓN: Ejecutando tarea URGENTE: " + getNombre());
    }
}

