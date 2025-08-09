package model;

public class Producto {
    private int idProducto;
    private int idCategoriaProducto;
    private String codigoBarras;
    private String nombre;
    private double precioUnitario;
    private String unidadMedida;
    private int stock;

    public Producto() {}

    public Producto(int idProducto, int idCategoriaProducto, String codigoBarras, String nombre, double precioUnitario, String unidadMedida, int stock) {
        this.idProducto = idProducto;
        this.idCategoriaProducto = idCategoriaProducto;
        this.codigoBarras = codigoBarras;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.unidadMedida = unidadMedida;
        this.stock = stock;
    }

    // Getters y setters
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(int idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

