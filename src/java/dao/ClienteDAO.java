package dao;

import config.Conexion;
import java.sql.*;
import java.util.*;
import model.Cliente;

public class ClienteDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNombres(rs.getString("nombres"));
                c.setApellidoPaterno(rs.getString("apellidoPaterno"));
                c.setDni(rs.getString("dni"));
                c.setDireccion(rs.getString("direccion"));
                c.setCorreoElectronico(rs.getString("correoElectronico"));
                lista.add(c);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public void agregar(Cliente c) {
        String sql = "INSERT INTO Cliente(nombres, apellidoPaterno, dni, direccion, correoElectronico) VALUES (?, ?, ?, ?, ?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombres());
            ps.setString(2, c.getApellidoPaterno());
            ps.setString(3, c.getDni());
            ps.setString(4, c.getDireccion());
            ps.setString(5, c.getCorreoElectronico());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Cliente obtenerPorId(int id) {
        Cliente c = new Cliente();
        String sql = "SELECT * FROM Cliente WHERE idCliente=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                c.setIdCliente(rs.getInt("idCliente"));
                c.setNombres(rs.getString("nombres"));
                c.setApellidoPaterno(rs.getString("apellidoPaterno"));
                c.setDni(rs.getString("dni"));
                c.setDireccion(rs.getString("direccion"));
                c.setCorreoElectronico(rs.getString("correoElectronico"));
            }
        } catch (Exception e) {
        }
        return c;
    }

    public void actualizar(Cliente c) {
        String sql = "UPDATE Cliente SET nombres=?, apellidoPaterno=?, dni=?, direccion=?, correoElectronico=? WHERE idCliente=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNombres());
            ps.setString(2, c.getApellidoPaterno());
            ps.setString(3, c.getDni());
            ps.setString(4, c.getDireccion());
            ps.setString(5, c.getCorreoElectronico());
            ps.setInt(6, c.getIdCliente());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM Cliente WHERE idCliente=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}

