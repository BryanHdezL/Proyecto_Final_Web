/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.CategoriaDTO;
import com.ipn.mx.modelo.dto.ProductoDTO;
import com.ipn.mx.modelo.dto.VentaDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author darkdestiny
 */
public class ProductoDAO {

    private static final String SQL_INSERT = "insert into Producto(nombre_producto,precio_producto,categoria_producto,id_categoria)"
            + " values ( ?,?,? )";
    private static final String SQL_UPDATE = "update Producto set nombre_Producto = ?,precio_producto = ?,id_categoria = ?"
            + " where id_producto = ? ";
    private static final String SQL_DELETE = "delete from Producto where id_producto = ?";
    private static final String SQL_READ = "select id_producto,nombre_producto,precio_producto,id_categoria"
            + " from Producto where id_producto = ?";
    private static final String SQL_READ_ALL = "select * from Producto";
    private static final String SQL_READ_TOP10 = "SELECT producto.nombre_producto, SUM(1) as cantidad\n" +
"    FROM venta JOIN producto ON venta.id_producto = producto.id_producto\n" +
"    GROUP BY producto.id_producto\n" +
"    ORDER BY cantidad DESC LIMIT 10;";
    private static final String SQL_READ_TOP10_M = "SELECT producto.nombre_producto, SUM(1) as cantidad\n" +
"    FROM venta JOIN producto ON venta.id_producto = producto.id_producto\n" +
"    WHERE fecha_venta BETWEEN '21-01-01' AND '21-01-28'\n" +
"    GROUP BY producto.id_producto\n" +
"    ORDER BY cantidad DESC LIMIT 10;";
    private static final String SQL_READ_TOP5 = "SELECT producto.nombre_producto, SUM(1) as cantidad\n" +
"    FROM venta JOIN producto JOIN categoria ON venta.id_producto = producto.id_producto and categoria.id_categoria = producto.id_categoria\n" +
"    where categoria.nombre_categoria = 'TECNOLOGIA'\n" +
"    GROUP BY producto.id_producto\n" +
"    ORDER BY cantidad DESC LIMIT 5;";

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
    
     public List readTop10() throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ_TOP10);
            rs = ps.executeQuery();
            List resultados = obtenerResultados2(rs);
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
     
    public List readTop10M() throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ_TOP10_M);
            //ps.setDate(1, '2021-01-01');
            //ps.setDate(2, java.sql.Date(21-01-01));
            rs = ps.executeQuery();
            List resultados = obtenerResultados2(rs);
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
    
    public List readTop5() throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ_TOP5);
            rs = ps.executeQuery();
            List resultados = obtenerResultados2(rs);
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

    private List obtenerResultados2(ResultSet rs) throws SQLException {
        List resultado = new ArrayList();
        while (rs.next()) {
            String producto = rs.getString("nombre_producto");
            resultado.add(producto);
            String cantidad = String.valueOf(rs.getInt("cantidad"));
            resultado.add(cantidad);
        }
        return resultado;
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
        VentaDTO dto2 = new VentaDTO();
        CategoriaDTO dto3 = new CategoriaDTO();
        //dto.getEntidad().setIdProducto(4);
        //dto.getEntidad().setNombreEstado("escom");
        //dto.getEntidad().setPrecioProducto(1);
        //dto2.getEntidad().setFechaVenta(Date.toString("21-01-01"));
        dto3.getEntidad().setNombreCategoria("TECNOLOGIA");

        ProductoDAO dao = new ProductoDAO();
        try {
            //dao.create(dto);
            //dao.update(dto);
            //dao.delete(dto);
            //System.out.println(dao.read(dto));
            //System.out.println(dao.readAll());
            //System.out.println(dao.readTop10());
            //System.out.println(dao.readTop10M());
            System.out.println(dao.readTop5());
        } catch (SQLException ex) {
            Logger.getLogger(ProductoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
