package Modelo.Entidades;

import java.util.logging.Logger;

public class Modalidad {
    private String id,descripcion;

    public Modalidad(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
     }

    public Modalidad() {
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Modalidad{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }
    
    
    
}
