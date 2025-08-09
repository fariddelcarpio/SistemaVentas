package model;

public class CategoriaProducto {
    private int idCategoriaProducto;
    private String nombreCategoria;

    public CategoriaProducto() {}

    public CategoriaProducto(int idCategoriaProducto, String nombreCategoria) {
        this.idCategoriaProducto = idCategoriaProducto;
        this.nombreCategoria = nombreCategoria;
    }

    public int getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(int idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}

