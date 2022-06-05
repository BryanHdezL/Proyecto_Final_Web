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
public class Venta implements Serializable {
    
    private int id_venta;
    private Date fecha_venta;
    private int id_producto;

    public int getIdVenta() {
        return id_venta;
    }

    public void setIdVenta(int id_venta) {
        this.id_venta = id_venta;
    }

    public Date getFechaVenta() {
        return fecha_venta;
    }

    public void setFechaVenta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }
    
    public int getIdProducto() {
        return id_producto;
    }

    public void setIdProducto(int id_producto) {
        this.id_producto = id_producto;
    }
}
