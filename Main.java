package com.smarttask.app;

import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que ejecuta la aplicación SmartTask y maneja el menú interactivo.
 */
public class Main {

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

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Agregar Tarea");
        System.out.println("2. Listar Tareas (Activas y Completadas)");
        System.out.println("3. Marcar Tarea como Completada");
        System.out.println("4. Eliminar Tarea por ID");
        System.out.println("5. Salir");
    }

    private static void agregarTareaUI(GestorTareas gestor, Scanner scanner) {
        System.out.print("Ingrese el nombre/descripción de la tarea: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese la prioridad (Alta, Media, Baja): ");
        String prioridad = scanner.nextLine();

        gestor.agregarTarea(nombre, prioridad);
        System.out.println("✅ Tarea agregada con éxito.");
    }

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