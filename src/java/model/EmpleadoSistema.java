package model;

public class EmpleadoSistema {
    private int idEmpleadoSistema;
    private int idEmpleado;
    private String usuario;
    private String password;
    private int idPerfilUsuario;

    // Getters y Setters
    public int getIdEmpleadoSistema() {
        return idEmpleadoSistema;
    }
    public void setIdEmpleadoSistema(int idEmpleadoSistema) {
        this.idEmpleadoSistema = idEmpleadoSistema;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdPerfilUsuario() {
        return idPerfilUsuario;
    }
    public void setIdPerfilUsuario(int idPerfilUsuario) {
        this.idPerfilUsuario = idPerfilUsuario;
    }
}
