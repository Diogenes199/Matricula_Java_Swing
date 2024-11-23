package Modelo.Entidades;


public class Usuario {
    
 private String id, nombre,paterno,materno,dni,usuario,contra,celular1,celular2,direccion;
 private Rol rol;

    public Usuario() {
    }

    public Usuario(String id) {
        this.id = id;
    }
    
    
    public Usuario(String id, String nombre, String paterno, String materno, String dni, String usuario, String contra, String celular1, String celular2, String direccion, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.dni = dni;
        this.usuario = usuario;
        this.contra = contra;
        this.celular1 = celular1;
        this.celular2 = celular2;
        this.direccion = direccion;
        this.rol = rol;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public String getCelular1() {
        return celular1;
    }

    public void setCelular1(String celular1) {
        this.celular1 = celular1;
    }

    public String getCelular2() {
        return celular2;
    }

    public void setCelular2(String celular2) {
        this.celular2 = celular2;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", dni=" + dni + ", usuario=" + usuario + ", contra=" + contra + ", celular1=" + celular1 + ", celular2=" + celular2 + ", direccion=" + direccion + ", rol=" + rol + '}';
    }
 
 
  
}
