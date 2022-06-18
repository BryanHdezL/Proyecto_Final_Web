/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author cafe_
 */
public class Producto implements Serializable {
    
    private int id_producto;
    private String nombre_producto;
    private int precio_producto;
    private int id_categoria;

    public int getIdProducto() {
        return id_producto;
    }

    public void setIdProducto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombreProducto() {
        return nombre_producto;
    }

    public void setNombreProducto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
    
    public int getPrecioProducto() {
        return id_producto;
    }

    public void setPrecioProducto(int precio_producto) {
        this.precio_producto = precio_producto;
    }
    
    public int getIdCategoria() {
        return id_categoria;
    }

    public void setIdCategoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
}
