/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.VentaDTO;
import java.sql.Connection;
import java.sql.Date;
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
public class VentaDAO {

    private static final String SQL_INSERT = "insert into Venta(fecha_venta,id_producto) values ( ?,? )";
    private static final String SQL_UPDATE = "update Venta set fecha_venta = ?,id_producto = ? where id_venta = ? ";
    private static final String SQL_DELETE = "delete from Venta where id_venta = ?";
    private static final String SQL_READ = "select id_venta,fecha_venta,id_producto from Venta where id_venta = ?";
    private static final String SQL_READ_ALL = "select * from Venta";

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
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void create(VentaDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setDate(1, dto.getEntidad().getFechaVenta());
            ps.setInt(2, dto.getEntidad().getIdProducto());
            
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

    public void update(VentaDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setDate(1, dto.getEntidad().getFechaVenta());
            ps.setInt(2, dto.getEntidad().getIdProducto());
            ps.setInt(3, dto.getEntidad().getIdVenta());
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

    public void delete(VentaDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdVenta());
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

    public VentaDTO read(VentaDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdVenta());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (VentaDTO) resultados.get(0);
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
            VentaDTO dto = new VentaDTO();
            dto.getEntidad().setIdVenta(rs.getInt("id_venta"));
            dto.getEntidad().setFechaVenta(rs.getDate("fecha_venta"));
            dto.getEntidad().setIdProducto(rs.getInt("id_producto"));
            resultado.add(dto);
        }
        return resultado;
    }

    public static void main(String[] args) {
        VentaDTO dto = new VentaDTO();
        dto.getEntidad().setIdVenta(4);
        //dto.getEntidad().setNombreEstado("escom");

        VentaDAO dao = new VentaDAO();
        try {
            //dao.create(dto);
            //dao.update(dto);
            //dao.delete(dto);
            //System.out.println(dao.read(dto));
            System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
