/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.UsuarioDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author darkdestiny
 */
public class UsuarioDAO {

    private static final String SQL_INSERT = "insert into Usuario(nombre_usuario,telefono_usuario,puesto_usuario"
            + "nombre_credencial) values ( ?,?,?,? )";
    private static final String SQL_UPDATE = "update Usuario set nombre_usuario = ?,telefono_usuario = ?,puesto_usuario = ?"
            + ",nombre_credencial = ? where id_usuario = ? ";
    private static final String SQL_DELETE = "delete from Usuario where id_usuario = ?";
    private static final String SQL_READ = "select id_usuario,nombre_usuario,telefono_usuario,puesto_usuario,"
            + "nombre_credencial from Usuario where id_usuario = ?";
    private static final String SQL_READ_ALL = "select * from Usuario";

    private Connection conexion;

    private void conectar() {
        String usuario = "root"; // ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡ Revisar usuario !!!!!!!!!!!!!!!!!!!
        String clave = "This1Life2Is3Incredible"; // ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡ Revisar contraseña !!!!!!!!!!!!!!!!!!!
        String url = "jdbc:mysql://localhost:3306/proyectometa4cm3"; // ¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡ Revisar url !!!!!!!!!!!!!!!!!!!
        //?serverTimezone=America/Mexico_City&allowPublicKeyRetrieval=true&useSSL=false
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException ex) {
            /////////////// Tener cuidado con esta parte, porque todo estaba conectado a EstadoDAO ////////////////////////////
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void create(UsuarioDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombreUsuario());
            ps.setString(2, dto.getEntidad().getTelefonoUsuario());
            ps.setString(3, dto.getEntidad().getPuestoUsuario());
            ps.setString(4, dto.getEntidad().getNombreCredencial());
            
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void update(UsuarioDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombreUsuario());
            ps.setString(2, dto.getEntidad().getTelefonoUsuario());
            ps.setString(3, dto.getEntidad().getPuestoUsuario());
            ps.setString(4, dto.getEntidad().getNombreCredencial());
            ps.setInt(5, dto.getEntidad().getIdUsuario());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public void delete(UsuarioDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdUsuario());
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    public UsuarioDTO read(UsuarioDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdUsuario());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (UsuarioDTO) resultados.get(0);
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }
    public List readAll() throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ_ALL);
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados;
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }
    }

    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultado = new ArrayList();
        while (rs.next()) {
            UsuarioDTO dto = new UsuarioDTO();
            dto.getEntidad().setIdUsuario(rs.getInt("id_usuario"));
            dto.getEntidad().setNombreUsuario(rs.getString("nombre_usuario"));
            dto.getEntidad().setTelefonoUsuario(rs.getString("telefono_usuario"));
            dto.getEntidad().setPuestoUsuario(rs.getString("puesto_usuario"));
            dto.getEntidad().setNombreCredencial(rs.getString("nombre_credencial"));
            resultado.add(dto);
        }
        return resultado;
    }

    public static void main(String[] args) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.getEntidad().setIdUsuario(104);
        //dto.getEntidad().setNombreEstado("escom");

        UsuarioDAO dao = new UsuarioDAO();
        try {
            //dao.create(dto);
            //dao.update(dto);
            //dao.delete(dto);
            System.out.println(dao.read(dto));
            //System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
