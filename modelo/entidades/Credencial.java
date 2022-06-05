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
public class Credencial implements Serializable {
    
    private String nombre_credencial;
    private String password_credencial;

    public String getNombreCredencial() {
        return nombre_credencial;
    }

    public void setNombreCredencial(String nombre_credencial) {
        this.nombre_credencial = nombre_credencial;
    }
    
    public String getPasswordCredencial() {
        return password_credencial;
    }

    public void setPasswordCredencial(String password_credencial) {
        this.password_credencial = password_credencial;
    }
}
