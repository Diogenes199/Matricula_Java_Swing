package Modelo.Entidades;


public class Rol {
    private String id, rol;

    public Rol() {
    }

    public Rol(String id, String rol) {
        this.id = id;
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Rol{" + "id=" + id + ", rol=" + rol + '}';
    }
    
}
