/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.CredencialDTO;
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
public class CredencialDAO {

    private static final String SQL_INSERT = "insert into Credencial(nombre_credencial,password_credencial) values ( ?,? )";
    private static final String SQL_UPDATE = "update Credencial set nombre_credencial = ?,password_credencial = ? where nombre_credencial = ? ";
    private static final String SQL_DELETE = "delete from Credencial where nombre_credencial = ?";
    private static final String SQL_READ = "select nombre_credencial,password_credencial where nombre_credencial = ?";
    private static final String SQL_READ_ALL = "select * from Credencial";

    private Connection conexion;

    private void conectar() {
        String usuario = "root";
        String clave = "password";
        String url = "jdbc:mysql://localhost:3306/eventos_web"; ////// Cambiar nombre de base de datos ///////////
        //?serverTimezone=America/Mexico_City&allowPublicKeyRetrieval=true&useSSL=false
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void create(CredencialDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombreCredencial());
            ps.setString(2, dto.getEntidad().getPasswordCredencial());
            
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

    public void update(CredencialDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombreCredencial());
            ps.setString(2, dto.getEntidad().getPasswordCredencial());
            ps.setString(3, dto.getEntidad().getNombreCredencial());
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

    public void delete(CredencialDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setString(1, dto.getEntidad().getNombreCredencial());
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

    public CredencialDTO read(CredencialDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ);
            ps.setString(1, dto.getEntidad().getNombreCredencial());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (CredencialDTO) resultados.get(0);
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
            CredencialDTO dto = new CredencialDTO();
            dto.getEntidad().setNombreCredencial(rs.getString("nombre_credencial"));
            dto.getEntidad().setPasswordCredencial(rs.getString("password_credencial"));
            resultado.add(dto);
        }
        return resultado;
    }

    public static void main(String[] args) {
        CredencialDTO dto = new CredencialDTO();
        dto.getEntidad().setNombreCredencial("Hallo Motto");
        //dto.getEntidad().setNombreEstado("escom");

        CredencialDAO dao = new CredencialDAO();
        try {
            //dao.create(dto);
            //dao.update(dto);
            //dao.delete(dto);
            //System.out.println(dao.read(dto));
            System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(CredencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
