package Modelo.Entidades;

import java.util.Date;

public class Matricula {
    private String id ;
    private Cliente cliente;
    private Curso curso;
    private Modalidad modalidad;
    private Horario horario;
    private Date fechaInicio;
    private double costoTotal;

    public Matricula() {
    }
   
    public Matricula(String id, Cliente cliente, Curso curso, Modalidad modalidad, Horario horario, Date fechaInicio, double costoTotal) {
        this.id = id;
        this.cliente = cliente;
        this.curso = curso;
        this.modalidad = modalidad;
        this.horario = horario;
        this.fechaInicio = fechaInicio;
        this.costoTotal = costoTotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    @Override
    public String toString() {
        return "Matricula{" + "id=" + id + ", cliente=" + cliente + ", curso=" + curso + ", modalidad=" + modalidad + ", horario=" + horario + ", fechaInicio=" + fechaInicio + ", costoTotal=" + costoTotal + '}';
    }
    
    
}
