
package gestiondiscapacidad;

/**
 *
 * @author usuario
 */
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    // Atributos privados con nombres nuevos
    private String nombre;
    private int edad;
    private String diagnostico;
    
    // ¡LA COLECCIÓN ANIDADA! (SIA1.5)
    private List<Prestacion> prestacionesRecibidas;

    // Constructor
    public Usuario(String nombre, int edad, String diagnostico) {
        this.nombre = nombre;
        this.edad = edad;
        this.diagnostico = diagnostico;
        this.prestacionesRecibidas = new ArrayList<>(); // Inicializamos la lista
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public List<Prestacion> getPrestacionesRecibidas() {
        return prestacionesRecibidas;
    }

    public void setPrestacionesRecibidas(List<Prestacion> prestacionesRecibidas) {
        this.prestacionesRecibidas = prestacionesRecibidas;
    }
    // Métodos para agregar prestaciones (Sobrecarga - SIA1.6)
    public void agregarPrestacion(Prestacion prestacion) {
    this.prestacionesRecibidas.add(prestacion);
    }

    public void agregarPrestacion(String nombre, String profesional, String detalles) {
    Prestacion nuevaPrestacion = new Prestacion(nombre, profesional, detalles);
    this.prestacionesRecibidas.add(nuevaPrestacion);
    }
}

