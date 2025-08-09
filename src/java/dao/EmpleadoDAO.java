package dao;

import java.sql.*;
import java.util.*;
import model.Empleado;
import config.Conexion;

public class EmpleadoDAO {
    private Connection cn = Conexion.getConexion();

    public List<Empleado> listar() {
        List<Empleado> lista = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Empleado";
            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Empleado e = new Empleado();
                e.setIdEmpleado(rs.getInt("idEmpleado"));
                e.setNombres(rs.getString("nombres"));
                e.setApellidoPaterno(rs.getString("apellidoPaterno"));
                e.setFechaNacimiento(rs.getString("fechaNacimiento"));
                e.setCorreoelectronico(rs.getString("correoelectronico"));
                e.setDireccion(rs.getString("direccion"));
                lista.add(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public void registrar(Empleado e) {
        try {
            String sql = "INSERT INTO Empleado(nombres, apellidoPaterno, fechaNacimiento, correoelectronico, direccion) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, e.getNombres());
            ps.setString(2, e.getApellidoPaterno());
            ps.setString(3, e.getFechaNacimiento());
            ps.setString(4, e.getCorreoelectronico());
            ps.setString(5, e.getDireccion());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
