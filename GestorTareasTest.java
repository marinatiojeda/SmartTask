package com.smarttask.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Clase de pruebas unitarias para GestorTareas utilizando JUnit 5.
 */
public class GestorTareasTest {

    private GestorTareas gestor;

    @BeforeEach
    public void setUp() {
        gestor = new GestorTareas();
    }

    @Test
    public void testAgregarTarea() {
        gestor.agregarTarea("Estudiar Java", "Alta");
        assertEquals(1, gestor.listarTodas().size(), "Debería haber 1 tarea en la lista.");
        assertEquals("Estudiar Java", gestor.listarTodas().get(0).getNombre());
    }

    @Test
    public void testMarcarComoCompletada() {
        gestor.agregarTarea("Entregar Proyecto", "Alta");
        boolean resultado = gestor.marcarComoCompletada(1);

        assertTrue(resultado, "El método debe retornar true si la tarea existe.");
        assertEquals(1, gestor.listarCompletadas().size(), "Debería haber 1 tarea completada.");
        assertEquals(0, gestor.listarActivas().size(), "No deberían quedar tareas activas.");
    }

    @Test
    public void testEliminarTarea() {
        gestor.agregarTarea("Tarea para borrar", "Baja");
        boolean resultado = gestor.eliminarTarea(1);

        assertTrue(resultado, "El método debe retornar true si la tarea se eliminó.");
        assertEquals(0, gestor.listarTodas().size(), "La lista debería quedar vacía.");
    }
}