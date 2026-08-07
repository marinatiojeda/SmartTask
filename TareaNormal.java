package com.smarttask.app;

public class TareaNormal extends Tarea implements Accionable {

    public TareaNormal(int id, String nombre) {
        super(id, nombre, "Media");
    }

    @Override
    public void ejecutarAccion() {
        System.out.println("Ejecutando tarea normal: " + getNombre());
    }
}