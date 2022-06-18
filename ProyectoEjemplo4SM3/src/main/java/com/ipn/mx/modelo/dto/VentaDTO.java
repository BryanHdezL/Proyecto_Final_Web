/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Venta;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author darkdestiny
 */
public class VentaDTO implements Serializable{
    private Venta entidad;

    public VentaDTO() {
        entidad = new Venta();
    }

    public Venta getEntidad() {
        return entidad;
    }

    public void setEntidad(Venta entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Clave Venta : ").append(getEntidad().getIdVenta()).append("\n");
        sb.append("Fecha Venta : ").append(getEntidad().getFechaVenta()).append("\n");
        sb.append("Clave Producto : ").append(getEntidad().getIdProducto()).append("\n");
        
        return sb.toString();
    }
    
    
    public static void main(String[] args) {
        VentaDTO dto = new VentaDTO();
        dto.getEntidad().setIdVenta(1);
        dto.getEntidad().setFechaVenta(Date.valueOf("2015-03-31"));
        dto.getEntidad().setIdProducto(1);
        
        
        System.out.println(dto);
    }
    
    
}
