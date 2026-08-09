package com.smarttask.app;

/**
 * Define el contrato para aquellos objetos del sistema SmartTask que pueden ser ejecutados.
 * <p>
 * Cualquier clase que implemente esta interfaz (como {@link TareaNormal}) 
 * debe proporcionar su propia lógica específica de ejecución cuando se invoque 
 * el método {@link #ejecutarAccion()}.
 * </p>
 * 
 * @author MaritzaOjeda
 * @version 1.0
 * @see TareaNormal
 */
public interface Accionable {
	
	/**
     * Ejecuta la acción o lógica principal asociada a la tarea o elemento.
     * <p>
     * Las clases implementadoras deben definir qué pasos o procesos específicos
     * se llevan a cabo al activar este método.
     * </p>
     */
    void ejecutarAccion(); 
}