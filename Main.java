package com.smarttask.app;

import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que ejecuta la aplicación SmartTask.
 * <p>
 * Se encarga de gestionar el flujo de navegación por consola, capturar 
 * las entradas del usuario y delegar las operaciones de negocio al {@link GestorTareas}.
 * </p>
 */
public class Main {

	/**
     * Punto de entrada principal de la aplicación.
     * Inicializa el menú interactivo y procesa las opciones seleccionadas por el usuario.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        System.out.println("=========================================");
        System.out.println("       ¡Bienvenido a SmartTask!          ");
        System.out.println("=========================================");

        while (!salir) {
            mostrarMenu();
            System.out.print("Selecciona una opción: ");
            
            int opcion = -1;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Entrada inválida. Debe ingresar un número.");
                continue;
            }

            switch (opcion) {
                case 1:
                    agregarTareaUI(gestor, scanner);
                    break;
                case 2:
                    listarTareasUI(gestor);
                    break;
                case 3:
                    marcarCompletadaUI(gestor, scanner);
                    break;
                case 4:
                    eliminarTareaUI(gestor, scanner);
                    break;
                case 5:
                    salir = true;
                    System.out.println("¡Gracias por usar SmartTask!");
                    break;
                default:
                    System.out.println("⚠️ Opción no válida. Intente nuevamente.");
            }
            System.out.println();
        }

        scanner.close();
    }

    /**
     * Despliega en consola el menú con las opciones disponibles para el usuario.
     */
    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Agregar Tarea");
        System.out.println("2. Listar Tareas (Activas y Completadas)");
        System.out.println("3. Marcar Tarea como Completada");
        System.out.println("4. Eliminar Tarea por ID");
        System.out.println("5. Salir");
    }

    /**
     * Solicita los datos al usuario desde la consola para crear y registrar una nueva tarea.
     *
     * @param gestor  Instancia de {@link GestorTareas} encargada de almacenar la tarea.
     * @param scanner Objeto {@link Scanner} para la lectura de datos por consola.
     */
    private static void agregarTareaUI(GestorTareas gestor, Scanner scanner) {
        System.out.print("Ingrese el nombre/descripción de la tarea: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese la prioridad (Alta, Media, Baja): ");
        String prioridad = scanner.nextLine();

        gestor.agregarTarea(nombre, prioridad);
        System.out.println("✅ Tarea agregada con éxito.");
    }

    /**
     * Muestra la lista de tareas registradas divididas entre activas y completadas.
     *
     * @param gestor Instancia de {@link GestorTareas} desde donde se recuperan las listas.
     */
    private static void listarTareasUI(GestorTareas gestor) {
        System.out.println("\n--- TAREAS ACTIVAS ---");
        List<Tarea> activas = gestor.listarActivas();
        if (activas.isEmpty()) {
            System.out.println("No hay tareas activas.");
        } else {
            for (Tarea t : activas) {
                System.out.println(t);
            }
        }

        System.out.println("\n--- TAREAS COMPLETADAS ---");
        List<Tarea> completadas = gestor.listarCompletadas();
        if (completadas.isEmpty()) {
            System.out.println("No hay tareas completadas.");
        } else {
            for (Tarea t : completadas) {
                System.out.println(t);
            }
        }
    }

    /**
     * Solicita el identificador de una tarea y solicita su actualización a estado completada.
     *
     * @param gestor  Instancia de {@link GestorTareas} que realiza la búsqueda y cambio de estado.
     * @param scanner Objeto {@link Scanner} para leer el identificador.
     */
    private static void marcarCompletadaUI(GestorTareas gestor, Scanner scanner) {
        System.out.print("Ingrese el ID de la tarea a marcar como completada: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            if (gestor.marcarComoCompletada(id)) {
                System.out.println("✅ Tarea #" + id + " marcada como completada.");
            } else {
                System.out.println("❌ No se encontró ninguna tarea con el ID " + id);
            }
        } catch (NumberFormatException e) {
            System.out.println("⚠️ El ID debe ser un número entero.");
        }
    }

    /**
     * Solicita el identificador de una tarea y procesa su eliminación del gestor.
     *
     * @param gestor  Instancia de {@link GestorTareas} que ejecuta la remoción de la tarea.
     * @param scanner Objeto {@link Scanner} para leer el identificador.
     */
    private static void eliminarTareaUI(GestorTareas gestor, Scanner scanner) {
        System.out.print("Ingrese el ID de la tarea a eliminar: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            if (gestor.eliminarTarea(id)) {
                System.out.println("🗑️ Tarea #" + id + " eliminada exitosamente.");
            } else {
                System.out.println("❌ No se encontró ninguna tarea con el ID " + id);
            }
        } catch (NumberFormatException e) {
            System.out.println("⚠️ El ID debe ser un número entero.");
        }
    }
}