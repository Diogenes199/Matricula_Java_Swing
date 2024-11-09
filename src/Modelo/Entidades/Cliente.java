package Modelo.Entidades;

import java.sql.Date;

public class Cliente {
    private String id;
     private Usuario usuario;
     private TipoDocumento documento;
     private String numeroDocumento;
     private String sexo;
     private Date fechaNacimiento;
     private String ubigeo;
     private String pais,departamento, provincia,distrito;

    public Cliente() {
    }

    public Cliente(String id, Usuario usuario, TipoDocumento documento, String numeroDocumento, String sexo, Date fechaNacimiento, String ubigeo, String pais, String departamento, String provincia, String distrito) {
        this.id = id;
        this.usuario = usuario;
        this.documento = documento;
        this.numeroDocumento = numeroDocumento;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.ubigeo = ubigeo;
        this.pais = pais;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
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

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", usuario=" + usuario + ", documento=" + documento + ", numeroDocumento=" + numeroDocumento + ", sexo=" + sexo + ", fechaNacimiento=" + fechaNacimiento + ", ubigeo=" + ubigeo + ", pais=" + pais + ", departamento=" + departamento + ", provincia=" + provincia + ", distrito=" + distrito + '}';
    }
     
     
}
