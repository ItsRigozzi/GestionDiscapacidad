
package gestiondiscapacidad;

/**
 *
 * @author usuario
 */

public class Prestacion {
    // Atributos privados con nombres simplificados
    private String nombre;
    private String profesional;
    private String detalles;

    // Constructor
    public Prestacion(String nombre, String profesional, String detalles) {
        this.nombre = nombre;
        this.profesional = profesional;
        this.detalles = detalles;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesional() {
        return profesional;
    }

    public void setProfesional(String profesional) {
        this.profesional = profesional;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
}

