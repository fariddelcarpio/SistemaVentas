package model;

public class TipoMovimiento {
    private int idTipoMovimiento;
    private String detalle;

    public TipoMovimiento() {}

    public TipoMovimiento(int idTipoMovimiento, String detalle) {
        this.idTipoMovimiento = idTipoMovimiento;
        this.detalle = detalle;
    }

    public int getIdTipoMovimiento() {
        return idTipoMovimiento;
    }

    public void setIdTipoMovimiento(int idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}
