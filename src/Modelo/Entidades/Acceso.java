package Modelo.Entidades;

import Modelo.Entidades.Enum.Rol;

public class Acceso {
    
        private String id;
        private String usuario;
        private String contra;
        private Rol rol;

    public Acceso() {
    }

    public Acceso(String id, String usuario, String contra, Rol rol) {
        this.id = id;
        this.usuario = usuario;
        this.contra = contra;
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
        
        
}
        