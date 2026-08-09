package com.smarttask.app;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * Clase de pruebas unitarias para validar las funcionalidades de la clase {@link GestorTareas}.
 * <p>
 * Verifica la correcta adición, eliminación, filtrado por estado y asignación 
 * de tipos de tareas utilizando el framework JUnit 5.
 * </p>
 */
public class GestorTareasTest {
	

/**
 * Intancia del gestor de tareas que se reutiliza en cada prueba.
 */
    private GestorTareas gestor;

    /**
     * Inicializa un nuevo entorno de prueba antes de la ejecución de cada método @Test.
     * Garantiza que las pruebas sean independientes entre sí.
     */
    @BeforeEach
    public void setUp() {
        gestor = new GestorTareas();
    }

    /**
     * Verifica que una nueva tarea se agregue correctamente al gestor 
     * y conserve el nombre asignado.
     */
    @Test
    public void testAgregarTarea() {
        gestor.agregarTarea("Estudiar Java", "Alta");
        assertEquals(1, gestor.listarTodas().size(), "Debería haber 1 tarea en la lista.");
        assertEquals("Estudiar Java", gestor.listarTodas().get(0).getNombre());
    }

    /**
     * Verifica que al marcar una tarea como completada, se actualice su estado,
     * se mueva a la lista de completadas y se remueva de la lista de tareas activas.
     */
    @Test
    public void testMarcarComoCompletada() {
        gestor.agregarTarea("Entregar Proyecto", "Alta");
        boolean resultado = gestor.marcarComoCompletada(1);

        assertTrue(resultado, "El método debe retornar true si la tarea existe.");
        assertEquals(1, gestor.listarCompletadas().size(), "Debería haber 1 tarea completada.");
        assertEquals(0, gestor.listarActivas().size(), "No deberían quedar tareas activas.");
    }

    /**
     * Verifica que una tarea se elimine correctamente de la lista general usando su identificador.
     */
    @Test
    public void testEliminarTarea() {
        gestor.agregarTarea("Tarea para borrar", "Baja");
        boolean resultado = gestor.eliminarTarea(1);

        assertTrue(resultado, "El método debe retornar true si la tarea se eliminó.");
        assertEquals(0, gestor.listarTodas().size(), "La lista debería quedar vacía.");
    }
    
    /**
     * Verifica la lógica de polimorfismo instanciando objetos {@link TareaUrgente} o {@link TareaNormal}
     * según la prioridad enviada ("Alta" vs "Media").
     */
    @Test
    public void testTiposDeTarea() {
        gestor.agregarTarea("Estudiar Java", "Alta");
        gestor.agregarTarea("Ordenar apuntes", "Media");

        List<Tarea> tareas = gestor.listarTodas();

        assertTrue(tareas.get(0) instanceof TareaUrgente);
        assertTrue(tareas.get(1) instanceof TareaNormal);
    }
    
    /**
     * Verifica que el método de listado devuelva la cantidad total de tareas agregadas
     * y mantenga el orden de inserción.
     */
    @Test
    public void testListarTareas() {
        gestor.agregarTarea("Estudiar Java", "Alta");
        gestor.agregarTarea("Hacer ejercicios", "Baja");

        List<Tarea> tareas = gestor.listarTodas();

        assertEquals(2, tareas.size());
        assertEquals("Estudiar Java", tareas.get(0).getNombre());
        assertEquals("Hacer ejercicios", tareas.get(1).getNombre());
    }
}