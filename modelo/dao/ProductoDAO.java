/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.ProductoDTO;
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
public class ProductoDAO {

    private static final String SQL_INSERT = "insert into Producto(nombre_producto,precio_producto,id_categoria)"
            + " values ( ?,?,? )";
    private static final String SQL_UPDATE = "update Producto set nombre_Producto = ?,precio_producto = ?,id_categoria = ?"
            + " where id_producto = ? ";
    private static final String SQL_DELETE = "delete from Producto where id_producto = ?";
    private static final String SQL_READ = "select id_producto,nombre_producto,precio_producto,id_categoria"
            + " from Producto where id_producto = ?";
    private static final String SQL_READ_ALL = "select * from Producto";

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
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void create(ProductoDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombreProducto());
            ps.setInt(2, dto.getEntidad().getPrecioProducto());
            ps.setInt(3, dto.getEntidad().getIdCategoria());
            
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

    public void update(ProductoDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombreProducto());
            ps.setInt(2, dto.getEntidad().getPrecioProducto());
            ps.setInt(3, dto.getEntidad().getIdCategoria());
            ps.setInt(4, dto.getEntidad().getIdProducto());
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

    public void delete(ProductoDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdProducto());
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

    public ProductoDTO read(ProductoDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdProducto());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (ProductoDTO) resultados.get(0);
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
            ProductoDTO dto = new ProductoDTO();
            dto.getEntidad().setIdProducto(rs.getInt("id_producto"));
            dto.getEntidad().setNombreProducto(rs.getString("nombre_producto"));
            dto.getEntidad().setPrecioProducto(rs.getInt("precio_producto"));
            dto.getEntidad().setIdCategoria(rs.getInt("id_categoria"));
            resultado.add(dto);
        }
        return resultado;
    }

    public static void main(String[] args) {
        ProductoDTO dto = new ProductoDTO();
        dto.getEntidad().setIdProducto(4);
        //dto.getEntidad().setNombreEstado("escom");

        ProductoDAO dao = new ProductoDAO();
        try {
            //dao.create(dto);
            //dao.update(dto);
            //dao.delete(dto);
            //System.out.println(dao.read(dto));
            System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
