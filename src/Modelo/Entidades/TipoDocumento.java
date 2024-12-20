package Modelo.Entidades;

public class TipoDocumento {
    private String 
            id,
            descripcion;

    public TipoDocumento() {
    }

    public TipoDocumento(String id) {
        this.id = id;
    }

    
    
    public TipoDocumento(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
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
        return "TipoDocumento{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }
    
}
