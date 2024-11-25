package Modelo.Entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Devolucion {
    private String id;
    private Pago pago;
    private LocalDate fechaDevolucion;
    private double montoDevuelto;
    private String motivo;
    private Usuario usuario;
    private LocalDateTime fechaRegistro;

    public Devolucion() {
    }

    public Devolucion(String id, Pago pago, LocalDate fechaDevolucion, double montoDevuelto, String motivo, Usuario usuario, LocalDateTime fechaRegistro) {
        this.id = id;
        this.pago = pago;
        this.fechaDevolucion = fechaDevolucion;
        this.montoDevuelto = montoDevuelto;
        this.motivo = motivo;
        this.usuario = usuario;
        this.fechaRegistro = fechaRegistro;
    }

    public Devolucion(String id, Pago pago, LocalDate fechaDevolucion, double montoDevuelto, String motivo, Usuario usuario) {
        this.id = id;
        this.pago = pago;
        this.fechaDevolucion = fechaDevolucion;
        this.montoDevuelto = montoDevuelto;
        this.motivo = motivo;
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public double getMontoDevuelto() {
        return montoDevuelto;
    }

    public void setMontoDevuelto(double montoDevuelto) {
        this.montoDevuelto = montoDevuelto;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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
        return "Devoluciones{" + "id=" + id + ", pago=" + pago + ", fechaDevolucion=" + fechaDevolucion + ", montoDevuelto=" + montoDevuelto + ", motivo=" + motivo + ", usuario=" + usuario + ", fechaRegistro=" + fechaRegistro + '}';
    }
    
}
