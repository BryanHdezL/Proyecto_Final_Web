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
public class Categoria implements Serializable {
    
    private int id_categoria;
    private String nombre_categoria;

    public int getIdCategoria() {
        return id_categoria;
    }

    public void setIdCategoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombreCategoria() {
        return nombre_categoria;
    }

    public void setNombreCategoria(String nombre_categoria) {
        this.nombre_categoria = nombre_categoria;
    }
}
