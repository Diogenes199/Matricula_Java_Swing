package Modelo.Entidades;

public class TipoComprobante {
    private String id,descripcion;

    public TipoComprobante() {
    }
    
    public TipoComprobante(String id) {
        this.id = id;
    }
    
    public TipoComprobante(String id, String descripcion) {
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
        return "TipoComprobante{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }
    
    
}
