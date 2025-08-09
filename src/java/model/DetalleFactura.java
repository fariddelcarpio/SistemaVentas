package model;

public class DetalleFactura {
    private int idVentasDetalle;
    private int idVentaCabecera;
    private int idProducto;
    private int cantidad;
    private double precioUnitario;
    private double subtotal;

    // Datos del producto (para mostrar en detalle)
    private String nombreProducto;

    public DetalleFactura() {}

    public int getIdVentasDetalle() {
        return idVentasDetalle;
    }

    public void setIdVentasDetalle(int idVentasDetalle) {
        this.idVentasDetalle = idVentasDetalle;
    }

    public int getIdVentaCabecera() {
        return idVentaCabecera;
    }

    public void setIdVentaCabecera(int idVentaCabecera) {
        this.idVentaCabecera = idVentaCabecera;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
