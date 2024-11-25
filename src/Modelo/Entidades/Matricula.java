package Modelo.Entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Matricula {

    private String id;
    private Cliente cliente;
    private Curso curso;
    private Modalidad modalidad;
    private Horario horario;
    private LocalDate fechaInscripcion;
    private double costoTotal;
    private Usuario usuario;
    private LocalDateTime fechaRegistro;

    public Matricula() {
    }

    public Matricula(String id) {
        this.id = id;
    }

    public Matricula(String id, Cliente cliente, Curso curso, Modalidad modalidad, Horario horario, LocalDate fechaInscripcion, double costoTotal, Usuario usuario) {
        this.id = id;
        this.cliente = cliente;
        this.curso = curso;
        this.modalidad = modalidad;
        this.horario = horario;
        this.fechaInscripcion = fechaInscripcion;
        this.costoTotal = costoTotal;
        this.usuario = usuario;
    }

    public Matricula(String id, Cliente cliente, Curso curso, Modalidad modalidad, Horario horario, LocalDate fechaInscripcion, double costoTotal, Usuario usuario, LocalDateTime fechaRegistro) {
        this.id = id;
        this.cliente = cliente;
        this.curso = curso;
        this.modalidad = modalidad;
        this.horario = horario;
        this.fechaInscripcion = fechaInscripcion;
        this.costoTotal = costoTotal;
        this.usuario = usuario;
        this.fechaRegistro = fechaRegistro;
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

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
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
        return "Matricula{" + "id=" + id + ", cliente=" + cliente + ", curso=" + curso + ", modalidad=" + modalidad + ", horario=" + horario + ", fechaInscripcion=" + fechaInscripcion + ", costoTotal=" + costoTotal + ", usuario=" + usuario + ", fechaRegistro=" + fechaRegistro + '}';
    }
    
}
