/**
 * Clase principal que contiene el menú de consola para interactuar con el sistema.
 * Permite registrar usuarios, asignar prestaciones y mostrar la información.
 *
 * @author Joaquin
 * @author Francisco Espinoza
 * @author Rigoberto
 */
package gestiondiscapacidad;

import java.util.ArrayList;
import java.util.HashMap; // Import para HashMap
import java.util.List;
import java.util.Map; // Import para Map
import java.util.Scanner;

public class GestionDiscapacidad {

    public static void main(String[] args) {
        
        // 1. Crear la colección principal usando un Map (SIA1.7)
        Map<Integer, Usuario> mapaUsuarios = new HashMap<>();
        int proximoId = 1; // Un contador para generar IDs únicos

        // 2. Crear datos iniciales (SIA1.4)
        Usuario usuarioDePrueba = new Usuario("Ana Rojas", 25, "Trastorno del espectro autista");
        usuarioDePrueba.getPrestacionesRecibidas().add(new Prestacion("Fonoaudiología", "Carla Soto", "Sesiones de lenguaje"));
        mapaUsuarios.put(proximoId, usuarioDePrueba);
        proximoId++;

        // 3. Lógica del menú (SIA1.8)
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- SISTEMA DE GESTIÓN DE USUARIOS ---");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Asignar prestación a un usuario");
            System.out.println("3. Mostrar usuarios y sus prestaciones");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = teclado.nextInt();
            teclado.nextLine(); // Importante: consume el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Registro de Nuevo Usuario ---");
                    System.out.print("Ingrese nombre: ");
                    String nombre = teclado.nextLine();
                    System.out.print("Ingrese edad: ");
                    int edad = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Ingrese diagnóstico: ");
                    String diagnostico = teclado.nextLine();
                    
                    Usuario nuevoUsuario = new Usuario(nombre, edad, diagnostico);
                    mapaUsuarios.put(proximoId, nuevoUsuario);
                    System.out.println("¡Usuario '" + nombre + "' registrado con éxito con el ID: " + proximoId + "!");
                    proximoId++;
                    break;
                case 2:
                    System.out.println("\n--- Asignar Prestación a Usuario ---");
                    if (mapaUsuarios.isEmpty()) {
                        System.out.println("No hay usuarios registrados.");
                        break;
                    }
                    
                    System.out.println("Seleccione un usuario por su ID:");
                    for (Map.Entry<Integer, Usuario> entry : mapaUsuarios.entrySet()) {
                        System.out.println("ID: " + entry.getKey() + " -> Nombre: " + entry.getValue().getNombre());
                    }
                    System.out.print("Ingrese el ID del usuario: ");
                    int idSeleccionado = teclado.nextInt();
                    teclado.nextLine();

                    if (mapaUsuarios.containsKey(idSeleccionado)) {
                        Usuario usuarioSeleccionado = mapaUsuarios.get(idSeleccionado);
                        
                        System.out.println("\n(Una prestación es una terapia, ayuda o servicio, ej: Kinesiología)");
                        System.out.print("Ingrese nombre de la prestación: ");
                        String nombrePrestacion = teclado.nextLine();
                        System.out.print("Ingrese profesional a cargo: ");
                        String profesional = teclado.nextLine();
                        
                        System.out.println("(Detalles como la frecuencia, objetivos o cualquier nota relevante)");
                        System.out.print("Ingrese detalles: ");
                        String detalles = teclado.nextLine();
                        
                        Prestacion nuevaPrestacion = new Prestacion(nombrePrestacion, profesional, detalles);
                        usuarioSeleccionado.agregarPrestacion(nuevaPrestacion); // Usando el método de sobrecarga
                        
                        System.out.println("¡Prestación asignada a " + usuarioSeleccionado.getNombre() + " con éxito!");
                    } else {
                        System.out.println("ID de usuario no válido.");
                    }
                    break;
                case 3:
                    System.out.println("\n--- Listado de Usuarios y Prestaciones ---");
                    if (mapaUsuarios.isEmpty()) {
                        System.out.println("No hay usuarios registrados.");
                        break;
                    }
                    
                    for (Map.Entry<Integer, Usuario> entry : mapaUsuarios.entrySet()) {
                        Usuario user = entry.getValue();
                        System.out.println("----------------------------------------");
                        System.out.println("ID: " + entry.getKey() + " | Usuario: " + user.getNombre());
                        System.out.println("Edad: " + user.getEdad() + " | Diagnóstico: " + user.getDiagnostico());
                        
                        if (user.getPrestacionesRecibidas().isEmpty()) {
                            System.out.println("  -> Sin prestaciones asignadas.");
                        } else {
                            System.out.println("  Prestaciones Asignadas:");
                            for (Prestacion prest : user.getPrestacionesRecibidas()) {
                                System.out.println("    - " + prest.getNombre() + " (Profesional: " + prest.getProfesional() + ")");
                            }
                        }
                    }
                    System.out.println("----------------------------------------");
                    break;
                case 4:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
