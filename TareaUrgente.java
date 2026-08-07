package com.smarttask.app;

public class TareaUrgente extends Tarea implements Accionable {
	
	public TareaUrgente(int id, String nombre) {
        super(id, nombre, "Alta");
    }

    @Override
    public void ejecutarAccion() {
        System.out.println("🚨 ATENCIÓN: Ejecutando tarea URGENTE: " + getNombre());
    }
}

