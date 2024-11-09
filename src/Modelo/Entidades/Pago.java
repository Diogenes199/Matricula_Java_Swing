package Modelo.Entidades;

import java.util.Date;

public class Pago {
    private String id;
    private Matricula matricula;
    private Date fechaPago;
    private double monto;
    private String detalle;
    private TipoComprobante comprobante;
    private String numeroComprobante;
    private Usuario Usuario;
    private String observaciones;

    public Pago() {
    }

    public Pago(String id, Matricula matricula, Date fechaPago, double monto, String detalle, TipoComprobante comprobante, String numeroComprobante, Usuario Usuario, String observaciones) {
        this.id = id;
        this.matricula = matricula;
        this.fechaPago = fechaPago;
        this.monto = monto;
        this.detalle = detalle;
        this.comprobante = comprobante;
        this.numeroComprobante = numeroComprobante;
        this.Usuario = Usuario;
        this.observaciones = observaciones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public TipoComprobante getComprobante() {
        return comprobante;
    }

    public void setComprobante(TipoComprobante comprobante) {
        this.comprobante = comprobante;
    }

    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Pago{" + "id=" + id + ", matricula=" + matricula + ", fechaPago=" + fechaPago + ", monto=" + monto + ", detalle=" + detalle + ", comprobante=" + comprobante + ", numeroComprobante=" + numeroComprobante + ", Usuario=" + Usuario + ", observaciones=" + observaciones + '}';
    }
    
    
    
}
