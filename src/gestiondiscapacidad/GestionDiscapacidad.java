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
import java.util.List;
import java.util.Scanner;

public class GestionDiscapacidad {

    public static void main(String[] args) {
        
        // 1. Crear la colección principal que guardará a los usuarios
        List<Usuario> listaUsuarios = new ArrayList<>();

        // 2. Crear datos iniciales
        Usuario usuarioDePrueba = new Usuario("Ana Rojas", 25, "Trastorno del espectro autista");
        usuarioDePrueba.getPrestacionesRecibidas().add(new Prestacion("Fonoaudiología", "Carla Soto", "Sesiones de lenguaje"));
        listaUsuarios.add(usuarioDePrueba);

        // 3. Lógica del menú
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
                    // Lógica para agregar un usuario
                    System.out.println("\n--- Registro de Nuevo Usuario ---");
                    System.out.print("Ingrese nombre: ");
                    String nombre = teclado.nextLine();
                    
                    System.out.print("Ingrese edad: ");
                    int edad = teclado.nextInt();
                    teclado.nextLine(); // Consume el salto de línea
                    
                    System.out.print("Ingrese diagnóstico: ");
                    String diagnostico = teclado.nextLine();
                    
                    Usuario nuevoUsuario = new Usuario(nombre, edad, diagnostico);
                    listaUsuarios.add(nuevoUsuario);
                    
                    System.out.println("¡Usuario '" + nombre + "' registrado con éxito!");
                    break;
                case 2:
                    // Lógica para asignar una prestación
                    System.out.println("\n--- Asignar Prestación a Usuario ---");
                    if (listaUsuarios.isEmpty()) {
                        System.out.println("No hay usuarios registrados. Por favor, registre un usuario primero.");
                        break;
                    }
                    
                    System.out.println("Seleccione un usuario:");
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        System.out.println((i + 1) + ". " + listaUsuarios.get(i).getNombre());
                    }
                    System.out.print("Ingrese el número del usuario: ");
                    int indiceUsuario = teclado.nextInt() - 1;
                    teclado.nextLine(); // Consume el salto de línea

                    if (indiceUsuario >= 0 && indiceUsuario < listaUsuarios.size()) {
                        Usuario usuarioSeleccionado = listaUsuarios.get(indiceUsuario);
                        
                        System.out.print("Ingrese nombre de la prestación: ");
                        String nombrePrestacion = teclado.nextLine();
                        
                        System.out.print("Ingrese profesional a cargo: ");
                        String profesional = teclado.nextLine();
                        
                        System.out.print("Ingrese detalles: ");
                        String detalles = teclado.nextLine();
                        
                        Prestacion nuevaPrestacion = new Prestacion(nombrePrestacion, profesional, detalles);
                        usuarioSeleccionado.getPrestacionesRecibidas().add(nuevaPrestacion);
                        
                        System.out.println("¡Prestación '" + nombrePrestacion + "' asignada a " + usuarioSeleccionado.getNombre() + " con éxito!");
                    } else {
                        System.out.println("Número de usuario no válido.");
                    }
                    break;
                case 3:
                    // Lógica para mostrar todo
                    System.out.println("\n--- Listado de Usuarios y Prestaciones ---");
                    if (listaUsuarios.isEmpty()) {
                        System.out.println("No hay usuarios registrados.");
                        break;
                    }
                    
                    for (Usuario user : listaUsuarios) {
                        System.out.println("----------------------------------------");
                        System.out.println("Usuario: " + user.getNombre());
                        System.out.println("Edad: " + user.getEdad());
                        System.out.println("Diagnóstico: " + user.getDiagnostico());
                        
                        if (user.getPrestacionesRecibidas().isEmpty()) {
                            System.out.println("  -> Sin prestaciones asignadas.");
                        } else {
                            System.out.println("  Prestaciones Asignadas:");
                            for (Prestacion prest : user.getPrestacionesRecibidas()) {
                                System.out.println("    - Prestación: " + prest.getNombre());
                                System.out.println("      Profesional: " + prest.getProfesional());
                                System.out.println("      Detalles: " + prest.getDetalles());
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

