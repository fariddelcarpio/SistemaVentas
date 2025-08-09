package model;

import java.util.Date;
import java.util.List;

public class Factura {
    private int idVentaCabecera;
    private Date fecha;
    private int idCliente;
    private double montoTotal;

    // Datos del cliente (opcional, útil para mostrar en reportes o detalles)
    private String clienteNombre;
    private List<DetalleFactura> detalles;

    public Factura() {}

    public int getIdVentaCabecera() {
        return idVentaCabecera;
    }

    public void setIdVentaCabecera(int idVentaCabecera) {
        this.idVentaCabecera = idVentaCabecera;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }
    
    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleFactura> detalles) {
        this.detalles = detalles;
    }
}
