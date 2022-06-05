/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Producto;
import java.io.Serializable;

/**
 *
 * @author darkdestiny
 */
public class ProductoDTO implements Serializable{
    private Producto entidad;

    public ProductoDTO() {
        entidad = new Producto();
    }

    public Producto getEntidad() {
        return entidad;
    }

    public void setEntidad(Producto entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Clave Producto : ").append(getEntidad().getIdProducto()).append("\n");
        sb.append("Nombre Producto : ").append(getEntidad().getNombreProducto()).append("\n");
        sb.append("Precio Producto : ").append(getEntidad().getPrecioProducto()).append("\n");
        sb.append("Clave Categoría : ").append(getEntidad().getIdCategoria()).append("\n");
        
        return sb.toString();
    }
    
    
    public static void main(String[] args) {
        ProductoDTO dto = new ProductoDTO();
        dto.getEntidad().setIdProducto(1);
        dto.getEntidad().setNombreProducto("Emiliano");
        dto.getEntidad().setPrecioProducto(20);
        dto.getEntidad().setIdCategoria(1);
        
        System.out.println(dto);
    }
    
    
}
