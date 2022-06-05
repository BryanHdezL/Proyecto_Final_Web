/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Categoria;
import java.io.Serializable;

/**
 *
 * @author darkdestiny
 */
public class CategoriaDTO implements Serializable{
    private Categoria entidad;

    public CategoriaDTO() {
        entidad = new Categoria();
    }

    public Categoria getEntidad() {
        return entidad;
    }

    public void setEntidad(Categoria entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Clave Categoria : ").append(getEntidad().getIdCategoria()).append("\n");
        sb.append("Nombre Categoria : ").append(getEntidad().getNombreCategoria()).append("\n");
        
        return sb.toString();
    }
    
    
    public static void main(String[] args) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.getEntidad().setIdCategoria(1);
        dto.getEntidad().setNombreCategoria("Emiliano");
        
        System.out.println(dto);
    }
}
