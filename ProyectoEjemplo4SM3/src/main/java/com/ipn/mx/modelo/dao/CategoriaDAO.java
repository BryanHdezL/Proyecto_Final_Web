/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.CategoriaDTO;
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
public class CategoriaDAO {

    private static final String SQL_INSERT = "insert into Categoria(nombre_categoria) values ( ? )";
    private static final String SQL_UPDATE = "update Categoria set nombre_categoria = ? where id_categoria = ? ";
    private static final String SQL_DELETE = "delete from Categoria where id_categoria = ?";
    private static final String SQL_READ = "select nombre_categoria,id_categoria from Categoria where id_categoria = ? ";
    private static final String SQL_READ_ALL = "select * from Categoria";

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

    public void create(CategoriaDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEntidad().getNombreCategoria());
            
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

    public void update(CategoriaDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEntidad().getNombreCategoria());
            ps.setInt(2, dto.getEntidad().getIdCategoria());
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

    public void delete(CategoriaDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        try {
            ps = conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getEntidad().getIdCategoria());
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

    public CategoriaDTO read(CategoriaDTO dto) throws SQLException {
        conectar();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conexion.prepareStatement(SQL_READ);
            ps.setInt(1, dto.getEntidad().getIdCategoria());
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (CategoriaDTO) resultados.get(0);
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
            CategoriaDTO dto = new CategoriaDTO();
            dto.getEntidad().setNombreCategoria(rs.getString("nombre_categoria"));
            dto.getEntidad().setIdCategoria(rs.getInt("id_categoria"));
            resultado.add(dto);
        }
        return resultado;
    }

    public static void main(String[] args) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.getEntidad().setIdCategoria(4);
        //dto.getEntidad().setNombreEstado("escom");

        CategoriaDAO dao = new CategoriaDAO();
        try {
            //dao.create(dto);
            //dao.update(dto);
            //dao.delete(dto);
            System.out.println(dao.read(dto));
            //System.out.println(dao.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
