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
public class Usuario implements Serializable {
    
    private int id_usuario;
    private String nombre_usuario;
    private String telefono_usuario;
    private String puesto_usuario;
    private String nombre_credencial;

    public int getIdUsuario() {
        return id_usuario;
    }

    public void setIdUsuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombreUsuario() {
        return nombre_usuario;
    }

    public void setNombreUsuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }
    
    public String getTelefonoUsuario() {
        return telefono_usuario;
    }

    public void setTelefonoUsuario(String telefono_usuario) {
        this.telefono_usuario = telefono_usuario;
    }
    
    public String getPuestoUsuario() {
        return puesto_usuario;
    }

    public void setPuestoUsuario(String puesto_usuario) {
        this.puesto_usuario = puesto_usuario;
    }
    
    public String getNombreCredencial() {
        return nombre_credencial;
    }

    public void setNombreCredencial(String nombre_credencial) {
        this.nombre_credencial = nombre_credencial;
    }
}
