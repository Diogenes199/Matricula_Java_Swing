package Modelo.Entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cliente {
    private String id;
     private TipoDocumento documento;
     private String 
             numeroDocumento,
             nombre,
             paterno,
             materno,
             email,
             celular1,
             celular2,
             sexo;                     ;
     private LocalDate fechaNacimiento;     
     private String 
             ubigeo,
             pais,
             departamento,
             provincia,
             distrito;
     private Usuario usuario;
     private LocalDateTime fechaRegistro;

    public Cliente() {
    }
    
    public Cliente(String id, TipoDocumento documento, String numeroDocumento, String nombre, String paterno, String materno, String email, String celular1, String celular2, String sexo, LocalDate fechaNacimiento, String ubigeo, String pais, String departamento, String provincia, String distrito, Usuario usuario) {
        this.id = id;
        this.documento = documento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.email = email;
        this.celular1 = celular1;
        this.celular2 = celular2;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.ubigeo = ubigeo;
        this.pais = pais;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.usuario = usuario;
    }

    public Cliente(String id, TipoDocumento documento, String numeroDocumento, String nombre, String paterno, String materno, String email, String celular1, String celular2, String sexo, LocalDate fechaNacimiento, String ubigeo, String pais, String departamento, String provincia, String distrito, Usuario usuario, LocalDateTime fechaRegistro) {
        this.id = id;
        this.documento = documento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.email = email;
        this.celular1 = celular1;
        this.celular2 = celular2;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.ubigeo = ubigeo;
        this.pais = pais;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
        this.usuario = usuario;
        this.fechaRegistro = fechaRegistro;
    }

    public Cliente(String id) {
        this.id = id;
    }

     public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoDocumento getDocumento() {
        return documento;
    }

    public void setDocumento(TipoDocumento documento) {
        this.documento = documento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", documento=" + documento + ", numeroDocumento=" + numeroDocumento + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", email=" + email + ", celular1=" + celular1 + ", celular2=" + celular2 + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + ", ubigeo=" + ubigeo + ", pais=" + pais + ", departamento=" + departamento + ", provincia=" + provincia + ", distrito=" + distrito + ", usuario=" + usuario + ", fechaRegistro=" + fechaRegistro + '}';
    }
    
}