package com.smarttask.app;

/**
 * Representa una tarea estándar dentro del sistema SmartTask.
 * <p>
 * Esta clase hereda los atributos y comportamientos básicos de la clase abstracta {@link Tarea}
 * e implementa la interfaz {@link Accionable} para definir la lógica específica de ejecución
 * de una tarea convencional.
 * </p>
 * 
 * @author MaritzaOjeda
 * @version 1.0
 * @see Tarea
 * @see Accionable
 */
public class TareaNormal extends Tarea implements Accionable {

	/**
     * Construye una nueva instancia de {@code TareaNormal} con sus propiedades básicas.
     *
     * @param id        El identificador único de la tarea.
     * @param nombre    El nombre o descripción corta de la tarea.
     * @param prioridad El nivel de prioridad asignado a la tarea (ej. "Alta", "Media", "Baja").
     */
	public TareaNormal(int id, String nombre, String prioridad) {
	    super(id, nombre, prioridad);
	}

	/**
     * Ejecuta la acción asociada a la tarea normal.
     * <p>
     * Imprime en la consola un mensaje indicando el inicio de la ejecución
     * junto con el nombre de la tarea.
     * </p>
     */
    @Override
    public void ejecutarAccion() {
        System.out.println("Ejecutando tarea normal: " + getNombre());
    }
}